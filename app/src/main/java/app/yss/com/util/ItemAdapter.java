package app.yss.com.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 *  项目描述:
 *  作者: shenrunzhou 
 *  创建时间  :2019-01-24  11:43
 */

public class ItemAdapter
        extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    List<String>mList;
    Context mContext;
    public ItemAdapter(List<String>list, Context context) {

        this.mList = list;
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.name);
        }
    }
}
