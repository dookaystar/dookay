package dookay.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import dookay.dklibrary.utils.SendMessageTimerUtils;


/**
 * @author：Qaufue
 * @date：2017/11/24
 * @time：13:01
 * @describe:
 */
public class MainPhotographActivity extends Activity {
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



}
