package dookay.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import dookay.dklibrary.base.BaseActivity;
import dookay.dklibrary.utils.OkhttpUtils;

/**
 * @author：Qaufue
 * @date：2017/11/27
 * @time：17:46
 * @describe:
 */
public class TestTwoActivity extends BaseActivity {
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
                String infos = "http://app-api.myphomule.com/api/common/dateList";
                // Map<String, String> stringMap = new HashMap<String, String>();
                dialogUtils.showDialog();
                
                okhttpUtils.getJson(infos, new HashMap<String, String>(), 0);

            }
        });
        txtinfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    protected void initData() {

    }


    OkhttpUtils okhttpUtils = new OkhttpUtils() {
        @Override
        protected void ShowResponse(String response, int okitem) {
            dialogUtils.dismissDialog();
            txtinfo.setText(response);
        }

        @Override
        protected void ShowError(String response, int erritem) {

        }
    };

}
