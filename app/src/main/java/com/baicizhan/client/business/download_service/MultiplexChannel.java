package com.baicizhan.client.business.download_service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiplexChannel<E> {
    private static int CHANNEL_NUM = ChannelPriority.values().length;
    private List<Channel<E>> channels = new ArrayList(CHANNEL_NUM);
    private AtomicInteger count = new AtomicInteger();
    private Condition notEmpty = this.takeLock.newCondition();
    private ReentrantLock takeLock = new ReentrantLock();

    public class Channel<E> {
        boolean paused = false;
        BlockingQueue<E> queue = new LinkedBlockingDeque();
    }

    public MultiplexChannel() {
        for (int i = 0; i < CHANNEL_NUM; i++) {
            this.channels.add(new Channel());
        }
    }

    public void put(ChannelPriority channelPriority, E e) {
        this.takeLock.lock();
        try {
            getChannel(channelPriority).queue.offer(e);
            this.count.addAndGet(1);
            this.notEmpty.signalAll();
        } finally {
            this.takeLock.unlock();
        }
    }

    public E take() {
        E e;
        E e2 = null;
        this.takeLock.lock();
//        while (this.count.get() == 0) {
//            try {
//                this.notEmpty.await();
//            } finally {
//                this.takeLock.unlock();
//            }
//        }
        Iterator it = this.channels.iterator();
        while (true) {
            if (!it.hasNext()) {
                e = e2;
                break;
            }
            Channel channel = (Channel) it.next();
            if (!channel.paused) {
                e = (E) channel.queue.poll();
                if (e == null) {
                    e2 = e;
                } else if (this.count.getAndDecrement() > 1) {
                    this.notEmpty.signal();
                }
            }
        }
        return e;
    }

    public Channel<E> getChannel(ChannelPriority channelPriority) {
        return (Channel) this.channels.get(channelPriority.ordinal());
    }

    public void clearAll() {
        for (Channel channel : this.channels) {
            channel.queue.clear();
        }
    }

    public void clear(ChannelPriority channelPriority) {
        getChannel(channelPriority).queue.clear();
    }

    public void pause(ChannelPriority channelPriority) {
        this.takeLock.lock();
        try {
            getChannel(channelPriority).paused = true;
        } finally {
            this.takeLock.unlock();
        }
    }

    public void resume(ChannelPriority channelPriority) {
        this.takeLock.lock();
        try {
            getChannel(channelPriority).paused = false;
            this.notEmpty.signalAll();
        } finally {
            this.takeLock.unlock();
        }
    }
}
