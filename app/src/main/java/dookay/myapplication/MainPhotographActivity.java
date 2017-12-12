package dookay.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jph.takephoto.PhotoUtil;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TResult;

import java.util.ArrayList;
import java.util.List;

import dookay.dklibrary.settings.DateDecimalUtils;
import dookay.dklibrary.utils.SendMessageTimerUtils;
import dookay.dklibrary.utils.GlideImgUtils;
import dookay.dklibrary.view.popup.ChoiceTopPopup;


public class MainPhotographActivity extends TakePhotoActivity {
    TextView textView, textViewtwo, txt_start;
    ImageView imgview;
    private SendMessageTimerUtils downTimerUtils;

    ChoiceTopPopup topPopup;

    PhotoUtil photoUtil;
    int a;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txtinfo);
        textViewtwo = findViewById(R.id.txtinfo2);
        imgview = findViewById(R.id.imgview);
        txt_start = findViewById(R.id.txt_start);
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
            /*    Log.e("str", "---东方败--" + str);*/
            }
        };

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
                topPopup.showPopupWindow(txt_start);
            }
        });
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
