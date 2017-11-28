package dookay.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.model.TResult;

import dookay.dklibrary.utils.SendMessageTimerUtils;
import dookay.dklibrary.utils.GlideImgManager;

/**
 * @author：Qaufue
 * @date：2017/11/24
 * @time：13:01
 * @describe:
 */
public class MainPhotographActivity extends TakePhotoActivity {
    TextView textView, textViewtwo, txt_start;
    ImageView imgview;
    private SendMessageTimerUtils downTimerUtils;

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
        textViewtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downTimerUtils.start();
            }
        });
        txt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downTimerUtils.onFinish();
            }
        });
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        GlideImgManager.glideLoader(MainPhotographActivity.this, result.getImages().get(0).getCompressPath(), imgview);
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
