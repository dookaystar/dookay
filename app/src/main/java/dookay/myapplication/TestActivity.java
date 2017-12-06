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


    }

}
