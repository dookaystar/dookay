package dookay.dklibrary.view.popup;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

import butterknife.OnClick;
import dookay.dklibrary.R;
import dookay.dklibrary.view.popup.basepopup.BasePopupWindow;


/**
 * @author：Qaufue
 * @date：2017/11/25
 * @time：14:52
 * @describe:
 */
public abstract class SelectPicturePopup extends BasePopupWindow {

    private View popupView;
    Activity activity;

    public SelectPicturePopup(Activity context) {
        super(context);
        activity = context;
        popupView.findViewById(R.id.tx_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclikView(0);
                dismiss();
            }
        });
        popupView.findViewById(R.id.tx_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclikView(1);
                dismiss();
            }
        });
        popupView.findViewById(R.id.tx_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclikView(2);
                dismiss();
            }
        });
    }


    public abstract void onclikView(int i);

    @Override
    protected Animation initShowAnimation() {
        return getTranslateAnimation(250 * 2, 0, 300);
    }

    @Override
    public View getClickToDismissView() {
        return popupView.findViewById(R.id.click_to_dismiss);
    }

    @Override
    public View onCreatePopupView() {
        popupView = LayoutInflater.from(getContext()).inflate(R.layout.popup_slide_from_bottom, null);
        return popupView;
    }

    @Override
    public View initAnimaView() {
        return popupView.findViewById(R.id.popup_anima);
    }
}