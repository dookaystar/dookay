package dookay.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import dookay.dklibrary.base.BaseActivity;

/**
 * @author：Qaufue
 * @date：2017/11/27
 * @time：17:46
 * @describe:
 */
public class TestActivity extends BaseActivity {

    TextView txtinfo, txtinfo2;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        txtinfo = (TextView) findViewById(R.id.txtinfo);
        txtinfo2 = (TextView) findViewById(R.id.txtinfo2);
        txtinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  dialogUtils.showDialog();*/
                dialogUtils.showDialog();
                setIntentClass(TestTwoActivity.class);
            }
        });
        txtinfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogUtils.dismissDialog();
            }
        });

    }

    @Override
    protected void initData() {

    }
}
