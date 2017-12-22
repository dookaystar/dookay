package dookay.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jph.takephoto.PhotoUtil;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TResult;

import java.util.ArrayList;
import java.util.List;

import dookay.dklibrary.interfaceutil.ViewoClickInterface;
import dookay.dklibrary.settings.DateDecimalUtils;
import dookay.dklibrary.utils.SendMessageTimerUtils;
import dookay.dklibrary.utils.GlideImgUtils;
import dookay.dklibrary.view.LoadingDialogUtils;
import dookay.dklibrary.view.popup.ChoiceTopPopup;


public class MainPhotographActivity extends TakePhotoActivity {
    TextView textView, textViewtwo, txt_start;
    ImageView imgview;
    private SendMessageTimerUtils downTimerUtils;

    ChoiceTopPopup topPopup;

    PhotoUtil photoUtil;
    int a;
    int b;
    LoadingDialogUtils dialogUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txtinfo);
        textViewtwo = findViewById(R.id.txtinfo2);
        imgview = findViewById(R.id.imgview);
        txt_start = findViewById(R.id.txt_start);
        dialogUtils = new LoadingDialogUtils(MainPhotographActivity.this);
        int[] ints = {R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.drawable.bg_identify_code_normal, R.drawable.bg_identify_code_press};
        downTimerUtils = new SendMessageTimerUtils(MainPhotographActivity.this, textViewtwo, 110, ints, false, "重新发送:");
        photoUtil = new PhotoUtil(MainPhotographActivity.this, getTakePhoto(), true, true, 100, 1);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(i + "东方不败" + i);
        }

        a = 5;
        b = 20;
        a = b;
        a = a - 4;
        Log.e("info_ab", a + "---" + b);

        topPopup = new ChoiceTopPopup(MainPhotographActivity.this, strings, R.layout.item_popup_list) {
            @Override
            public void onclikItem(String str, int item) {
                Log.e("str", "---东方败--" + str);
            }
        };

        topPopup.dissOnClick(new ViewoClickInterface() {
            @Override
            public void onClick() {
                Log.e("infosss", "fdsljfoksdjifji");
            }
        });

        textViewtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoUtil.takePhotograph();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoUtil.choosePicture();
            }
        });
        txt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* topPopup.showPopupWindow(txt_start);*/
                startCountDownTime(20);
            }
        });


    }

    private void startCountDownTime(long time) {
        /**
         * 最简单的倒计时类，实现了官方的CountDownTimer类（没有特殊要求的话可以使用）
         * 即使退出activity，倒计时还能进行，因为是创建了后台的线程。
         * 有onTick，onFinsh、cancel和start方法
         */
        CountDownTimer timer = new CountDownTimer(time * 1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //每隔countDownInterval秒会回调一次onTick()方法
                Log.d("strdkko", "onTick  " + millisUntilFinished / 1000);
                dialogUtils.showDialog();

                if (millisUntilFinished / 1000 % 2 == 0) {
                    dialogUtils.dismissDialog();
                }

            }

            @Override
            public void onFinish() {
                dialogUtils.dismissDialog();
                Log.d("strdkko", "onFinish -- 倒计时结束");
            }
        };
        timer.start();// 开始计时
        //timer.cancel(); // 取消
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        GlideImgUtils.glideLoader(MainPhotographActivity.this, result.getImages().get(0).getCompressPath(), imgview);
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }


}
