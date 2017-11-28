package dookay.dklibrary.view.popup;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.github.library.BaseRecyclerAdapter;
import com.github.library.BaseViewHolder;
import com.github.library.listener.OnRecyclerItemClickListener;

import java.util.List;

import dookay.dklibrary.R;
import dookay.dklibrary.utils.DimensUtils;
import dookay.dklibrary.utils.RecylerAdapterUtil;
import dookay.dklibrary.view.popup.basepopup.BasePopupWindow;


/**
 * Created by 大灯泡 on 2016/12/6.
 * <p>
 * 从顶部下滑的Poup
 */

public abstract class FourthChoicePopup extends BasePopupWindow {
    private List<String> stringList;
    private Activity activity;

    public FourthChoicePopup(Activity activity1, List<String> stringList1, int layoutView) {
        super(activity1);
        this.activity = activity1;
        this.stringList = stringList1;
        setBackPressEnable(false);
        setDismissWhenTouchOuside(true);
        RecyclerView listView = (RecyclerView) findViewById(R.id.popup_list);
        BaseRecyclerAdapter recyclerAdapter = new BaseRecyclerAdapter(activity, stringList, layoutView) {
            @Override
            protected void convert(BaseViewHolder helper, Object item) {
                helper.setText(R.id.item_tx, item + "");
            }
        };
        recyclerAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                onclikItem(stringList.get(position), position);
            }
        });
        RecylerAdapterUtil.SetAdapter(activity, listView, recyclerAdapter);
    }


    private int oKItem;
    private int colorClikTxt;
    private int colorTxt;
    private int colorline;
    private BaseRecyclerAdapter recyclerAdapter;
    private RecyclerView listView;

    /**
     * @param activity1
     * @param stringList1
     * @param layoutView    布局文件
     * @param okIteme       已经点击的控件
     * @param colorlinee    横线的颜色
     * @param colorTxte     字体的默认颜色
     * @param colorClikTxte 点击后的颜色
     */
    public FourthChoicePopup(Activity activity1, List<String> stringList1, int layoutView, int okIteme, int colorlinee, int colorTxte, int colorClikTxte) {
        super(activity1);
        this.oKItem = okIteme;
        this.colorClikTxt = colorClikTxte;
        this.colorTxt = colorTxte;
        this.colorline = colorlinee;
        this.activity = activity1;
        this.stringList = stringList1;
        setBackPressEnable(false);
        setDismissWhenTouchOuside(true);
        if (recyclerAdapter == null) {
            listView = (RecyclerView) findViewById(R.id.popup_list);
            recyclerAdapter = new BaseRecyclerAdapter(activity, stringList, layoutView) {
                @Override
                protected void convert(BaseViewHolder helper, Object item) {
                    TextView textView = helper.getView(R.id.item_tx);
                    textView.setText(item + "");
                    View viewline = helper.getView(R.id.view_line);
                    viewline.setBackgroundColor(ContextCompat.getColor(activity, colorline));
                    if (oKItem == helper.getAdapterPosition()) { //说明用户点击了这个选项
                        textView.setTextColor(ContextCompat.getColor(activity, colorClikTxt));
                    } else {
                        textView.setTextColor(ContextCompat.getColor(activity, colorTxt));
                    }
                }
            };
            recyclerAdapter.setOnRecyclerItemClickListener(new OnRecyclerItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    oKItem = position;
                    recyclerAdapter.notifyDataSetChanged();
                    onclikItem(stringList.get(position), position);
                }
            });
            RecylerAdapterUtil.SetAdapter(activity, listView, recyclerAdapter);
        } else {
            recyclerAdapter.setData(stringList);
        }
    }



   public   OnDismissListener onDismissListener = new OnDismissListener() {
        @Override
        public boolean onBeforeDismiss() {
            return super.onBeforeDismiss();
        }

        @Override
        public void onDismiss() {

        }
    };


    @Override
    protected Animation initShowAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, -DimensUtils.dipToPx(getContext(), 400f), 0);
        translateAnimation.setDuration(300);
        translateAnimation.setInterpolator(new OvershootInterpolator(0));  //设置 下滑 多一点然后还原
        return translateAnimation;
    }

    @Override
    public View getClickToDismissView() {
        return getPopupWindowView();
    }

    @Override
    public View onCreatePopupView() {
        return createPopupById(R.layout.popup_select_from_top);
    }

    @Override
    public View initAnimaView() {
        return findViewById(R.id.popup_anima);
    }

    public abstract void onclikItem(String str, int item);
}
