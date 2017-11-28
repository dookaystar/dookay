package dookay.dklibrary.view;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import dookay.dklibrary.R;


/**
 * User：Leo
 * Date：2017/1/10 0010
 * Time：13:33
 * Describe:
 */

public class ToastView {

    private Toast toast;
    private View view;
    private LayoutInflater layoutInflater;
    private ImageView ivShowPic;
    private TextView tvShowContent;

    Context context;
    public ToastView(Context context) {
        this.context = context;
    }

    /**
     * 时间为 LENGTH_SHORT
     *
     * @param content
     * @param type    为 1 正确 ； 2 为错误
     */
    public void showToast( String content, boolean type) {
        if (layoutInflater == null || view == null) {
            layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.toast_info, null);
            ivShowPic = (ImageView) view.findViewById(R.id.iv_show);
            tvShowContent = (TextView) view.findViewById(R.id.tv_prompt);
        }
        if (toast == null) {
            toast = new Toast(context);
            toast.setView(view);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            tvShowContent.setText(content);
        } else {
            tvShowContent.setText(content);
        }
        if (type) {
            ivShowPic.setImageResource(R.mipmap.ic_toast_ok);
        } else {
            ivShowPic.setImageResource(R.mipmap.ic_toast_error);
        }
        toast.show();
    }

    public void dissToast() {
        if (toast.getView().getVisibility() == View.VISIBLE) {
            toast.cancel();
        }
    }
}
