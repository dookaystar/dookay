package dookay.dklibrary.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import dookay.dklibrary.R;
import dookay.dklibrary.utils.ConstantIntUtils;
import dookay.dklibrary.view.animation.SpinKitView;
import dookay.dklibrary.view.animation.SpriteFactory;
import dookay.dklibrary.view.animation.Style;


/**
 * Date：2017/1/15 0015
 * Time：17:28
 * Describe: LoadingDialogUtils工具类
 */

public class LoadingDialogUtils {
    private Dialog mydialog;
    private SpinKitView spinKitView;
    private Context context;

    public LoadingDialogUtils(Context context) {
        this.context = context;
    }


    // 显示dialog
    public void showDialog() {
        if (mydialog != null) {
            mydialog.show();
        } else {
            mydialog = new Dialog(context, R.style.loading_dialog);
            mydialog.setContentView(R.layout.loading_dialoginfo);
            spinKitView = mydialog.findViewById(R.id.spinkitview);
            spinKitView.setIndeterminateDrawable(SpriteFactory.create(Style.values()[ConstantIntUtils.ZERO]));  // 常用的下标 0,1,2 共三个
            mydialog.setCanceledOnTouchOutside(false);
            mydialog.show();
        }
    }

    // 取消dialog
    public void dismissDialog() {
        if (mydialog == null) {
            return;
        }
        if (mydialog.isShowing()) {
            mydialog.dismiss();
            mydialog = null;
        }
    }
}
