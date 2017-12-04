package dookay.myapplication;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

import dookay.dklibrary.base.BaseActivity;
import dookay.dklibrary.utils.ConstantIntUtils;
import dookay.dklibrary.view.overlap_img.PileLayout;

/**
 * @author：Qaufue
 * @date：2017/11/27
 * @time：17:46
 * @describe:
 */
public class TestActivity extends BaseActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void getIntentData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {

    }

    PileLayout pileLayout;

    String[] urls = {"http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
            "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg"
    };


    @Override
    protected void initData() {


   /*     OkhttpInfoUtil  okhttpInfoUtil= new OkhttpInfoUtil(TestActivity.this) {
            @Override
            public void ShowResponse(String response, int okitem) {

            }

            @Override
            public void ShowError(String response, int erritem) {

            }
        };*/
        okhttpInfoUtil.getJson("http://ip-27-joyway-app.coralcodes.com/u/info?token=802db37eb25f40cd9db6dba6b2972cf17pM84c&client=android",
                new HashMap<String, String>(), ConstantIntUtils.ZERO
        );
    }

    OkhttpInfoUtil okhttpInfoUtil = new OkhttpInfoUtil(TestActivity.this) {
        @Override
        protected void ShowInfoResponse(String response, int okitem) {

            Log.e("info", "东方不败" + response);
        }

        @Override
        protected void ShowInfoError(String response, int erritem) {
            Log.e("info", "东方不败" + response);
        }
    };

}
