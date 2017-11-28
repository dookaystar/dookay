package dookay.dklibrary.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import dookay.dklibrary.R;


/**
 * User：Leo
 * Date：2017/10/20 0020
 * Time：10:52
 * Describe:  标题栏
 */
public class TitleBarView extends LinearLayout {
    private RelativeLayout relativeLayout;
    private ViewGroup leftLayout;
    private ViewGroup rightLayout;
    private ViewGroup middleLayout;
    private TextView leftImage;
    private TextView rightText;
    public TextView midText;
    private ImageView rightPic;
    private ViewGroup delegate;

    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        delegate = (ViewGroup) LayoutInflater.from(context).inflate(getrootViewId(), null);
        relativeLayout = (RelativeLayout) delegate.findViewById(R.id.relative_title);
        leftLayout = (ViewGroup) delegate.findViewById(R.id.header_left_layout);
        rightLayout = (ViewGroup) delegate.findViewById(R.id.header_right_layout);
        middleLayout = (ViewGroup) delegate.findViewById(R.id.header_middle_view);
        leftImage = (TextView) delegate.findViewById(R.id.header_left_arrow);
        rightText = (TextView) delegate.findViewById(R.id.header_right_text);
        midText = (TextView) delegate.findViewById(R.id.middleText);
        rightPic = (ImageView) delegate.findViewById(R.id.header_right_pic);
        addView(delegate);
        Drawable nav_up = getResources().getDrawable(R.mipmap.ic_back);
        nav_up.setBounds(0, 0, nav_up.getMinimumWidth(), nav_up.getMinimumHeight());
        leftImage.setCompoundDrawables(nav_up, null, null, null);
        leftImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).onBackPressed();
                }
            }
        });
    }

    public void setLeftOnClickListener(OnClickListener leftOnClickListener) {
        leftLayout.setVisibility(View.VISIBLE);
        leftImage.setOnClickListener(leftOnClickListener);
    }

    public ViewGroup getLeftLayout() {
        return leftLayout;
    }

    public void setTitle(String title) {
        midText.setTextSize(17);
        midText.setText(title);
    }

    public TextView getRightText() {
        return rightText;
    }

    public void setRightText(CharSequence content) {
        rightText.setVisibility(View.VISIBLE);
        rightLayout.setVisibility(View.VISIBLE);
        rightText.setText(content);
    }

    public ImageView getRightPic() {
        return rightPic;
    }

    /**
     * 设置HeaderView 右侧的图片
     *
     * @param resId 图片的id
     */
    public void setRightPic(int resId) {
        rightPic.setImageResource(resId);
    }

    protected int getrootViewId() {
        return R.layout.view_titlebar;
    }

    public TextView getLeftImage() {
        return leftImage;
    }

    public RelativeLayout getAllBackground() {
        return relativeLayout;
    }

    public TextView getMiddleText() {
        return midText;
    }
}

