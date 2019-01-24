package app.yss.com.util.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import app.yss.com.util.R;


/**
 *  项目描述:recyclerView分割线
 *  作者: shenrunzhou 
 *  创建时间  :2019-01-21  17:09
 */

public class DividerItem
        extends RecyclerView.ItemDecoration {

    private Drawable mDivider;     //分割线Drawable
    private int      mDividerHeight;  //分割线高度

    /**
     * 使用line_divider中定义好的颜色
     * @param context
     * @param dividerHeight 分割线高度
     */
    public DividerItem(Context context, int dividerHeight) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
        mDividerHeight = dividerHeight;
    }

    /**
     *
     * @param context
     * @param divider 分割线Drawable
     * @param dividerHeight 分割线高度
     */
    public DividerItem(Context context, Drawable divider, int dividerHeight) {
        if (divider == null) {
            mDivider = ContextCompat.getDrawable(context, R.drawable.line_divider);
        } else {
            mDivider = divider;
        }
        mDividerHeight = dividerHeight;
    }

    //获取分割线尺寸
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);

       /* int childAdapterPosition = parent.getChildAdapterPosition(view);


        //设置第一个条目为
        if (childAdapterPosition == 0) {
            LogUtil.d("Divider===========" + childAdapterPosition);
            outRect.set(0, 0, 0, 0);
            mDivider.setVisible(false,false);

        }else {
            LogUtil.d("Divider===========" + childAdapterPosition);

            mDivider.setVisible(true,false);
        }*/

        outRect.set(0, 0, 0, mDividerHeight);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left  = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {


            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top    = child.getBottom() + params.bottomMargin;
            int bottom = top + mDividerHeight;
          /* if (i == 0){
               continue;
           }*/
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);

        }
    }
}