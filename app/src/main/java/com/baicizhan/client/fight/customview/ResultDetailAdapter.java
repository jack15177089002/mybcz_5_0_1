package com.baicizhan.client.fight.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
//import com.baicizhan.client.fight.R;
import com.baicizhan.client.fight.VSManager;
import com.baicizhan.client.fight.jsonbean.Problem;
import com.baicizhan.client.fight.jsonbean.Problem.Option;
import com.baicizhan.client.fight.jsonbean.Result;
import com.baicizhan.client.fight.jsonbean.Score;
import com.baicizhan.client.fight.jsonbean.Score.Detail;
import com.jiongji.andriod.card.R;

import java.util.ArrayList;
import java.util.List;

public class ResultDetailAdapter extends BaseAdapter {
    private ArrayList<CompareResult> mCmpResults;
    private LayoutInflater mInflater;

    final class CompareResult {
        int meRes;
        String mean;
        int partRes;
        String word;

        private CompareResult() {
        }
    }

    class ViewHolder {
        View meCorrectness;
        TextView mean;
        View partCorrectness;
        TextView word;

        ViewHolder() {
        }
    }

    public ResultDetailAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void setResult(Result result) {
        this.mCmpResults = adapt(result);
    }

    private ArrayList<CompareResult> adapt(Result result) {
        if (result == null) {
            return null;
        }
        List problems = VSManager.getInstance().getProblems();
        if (problems == null) {
            return null;
        }
        Score a = result.getA();
        Score b = result.getB();
        if (a == null || b == null) {
            return null;
        }
        int size = problems.size();
        List details = a.getDetails();
        List details2 = b.getDetails();
        if (details == null || details2 == null || details.size() != size || details2.size() != size) {
            return null;
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            CompareResult compareResult = new CompareResult();
            Problem problem = (Problem) problems.get(i);
            Detail detail = (Detail) details.get(i);
            Detail detail2 = (Detail) details2.get(i);
            compareResult.word = problem.getTitle();
            compareResult.mean = ((Option) problem.getOptions().get(problem.getAnswer())).getMeanCn();
            compareResult.meRes = detail.res;
            compareResult.partRes = detail2.res;
            arrayList.add(compareResult);
        }
        return arrayList;
    }

    public int getCount() {
        if (this.mCmpResults != null) {
            return this.mCmpResults.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        if (this.mCmpResults != null) {
            return this.mCmpResults.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = this.mInflater.inflate(R.layout.fight_result_list_item, viewGroup, false);
            viewHolder.meCorrectness = view.findViewById(R.id.me_correctness);
            viewHolder.partCorrectness = view.findViewById(R.id.part_correctness);
            viewHolder.word = (TextView) view.findViewById(R.id.result_word);
            viewHolder.mean = (TextView) view.findViewById(R.id.result_mean);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.word.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                } else {
                    view.setSelected(true);
                }
            }
        });
        viewHolder.mean.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (view.isSelected()) {
                    view.setSelected(false);
                } else {
                    view.setSelected(true);
                }
            }
        });
        CompareResult compareResult = (CompareResult) this.mCmpResults.get(i);
        if (compareResult.meRes == 0) {
            viewHolder.meCorrectness.setBackgroundResource(R.drawable.fight_me_right);
        } else {
            viewHolder.meCorrectness.setBackgroundResource(R.drawable.fight_me_error);
        }
        if (compareResult.partRes == 0) {
            viewHolder.partCorrectness.setBackgroundResource(R.drawable.fight_part_right);
        } else {
            viewHolder.partCorrectness.setBackgroundResource(R.drawable.fight_part_error);
        }
        viewHolder.word.setText(compareResult.word);
        viewHolder.mean.setText(compareResult.mean);
        return view;
    }
}
