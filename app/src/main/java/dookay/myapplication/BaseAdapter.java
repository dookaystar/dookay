package dookay.myapplication;

import android.content.Context;

import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;
import com.github.library.listener.OnRecyclerItemClickListener;

import java.util.List;

/* ****************************************
 *                                       *
 *  @dookay.com Internet make it happen *
 *  ----------- -----------------------  *
 *  dddd  ddddd Internet make it happen  *
 *  o    o    o Internet make it happen  *
 *  k    k    k Internet make it happen  *
 *  a    a    a Internet make it happen  *
 *  yyyy  yyyyy Internet make it happen  *
 *  ----------- -----------------------  *
 *  @dookay.com Internet make it happen *
 *                                       *
 *************************************** */
/*
 * @author：Qaufue
 * @date：2017/12/19  13:19
 * @describe:
 */
public class BaseAdapter extends BaseRecyclerAdapter {

    public BaseAdapter(Context context, List data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }

    @Override
    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerViewItemClickListener) {
        super.setOnRecyclerItemClickListener(onRecyclerViewItemClickListener);
    }
}
