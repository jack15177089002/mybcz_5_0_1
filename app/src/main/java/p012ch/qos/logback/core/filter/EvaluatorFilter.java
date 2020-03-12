package p012ch.qos.logback.core.filter;

import p012ch.qos.logback.core.boolex.EvaluationException;
import p012ch.qos.logback.core.boolex.EventEvaluator;
import p012ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.core.filter.EvaluatorFilter */
public class EvaluatorFilter<E> extends AbstractMatcherFilter<E> {
    EventEvaluator<E> evaluator;

    public void start() {
        if (this.evaluator != null) {
            super.start();
        } else {
            addError("No evaluator set for filter " + getName());
        }
    }

    public EventEvaluator<E> getEvaluator() {
        return this.evaluator;
    }

    public void setEvaluator(EventEvaluator<E> eventEvaluator) {
        this.evaluator = eventEvaluator;
    }

    public FilterReply decide(E e) {
        if (!isStarted() || !this.evaluator.isStarted()) {
            return FilterReply.NEUTRAL;
        }
        try {
            if (this.evaluator.evaluate(e)) {
                return this.onMatch;
            }
            return this.onMismatch;
        } catch (EvaluationException e2) {
            addError("Evaluator " + this.evaluator.getName() + " threw an exception", e2);
            return FilterReply.NEUTRAL;
        }
    }
}
