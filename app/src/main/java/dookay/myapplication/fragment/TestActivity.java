package dookay.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.ArrayList;
import java.util.List;

import dookay.dklibrary.utils.OkhttpUtils;
import dookay.myapplication.R;


/* ****************************************
 *                                       *
 *  @dookay.com Internet make it happen *
 *  ----------- -----------------------  *
 *  dddd  ddddd Internet make it happen  *
 *  o    o    o Internet make it happen  *
 *  k    k    k Internet make it happen  *
 *  a    a    a Internet make it happen  *
 *  yyyy  yyyyy Internet make it happen  *
 *  ----------- -----------------------  *
 *  @dookay.com Internet make it happen *
 *                                       *
 *************************************** */
/*
 * @author：Qaufue
 * @date：2017/12/18  17:20
 * @describe:
 */
public class TestActivity extends FragmentActivity {
    ViewPagerAdapter viewPagerAdapter;

    List<String> stringList = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    ViewPager viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        viewpager = findViewById(R.id.viewpager);

        for (int i = 0; i < 5; i++) {
            stringList.add("show" + i);
        }
        fragments.add(new FragemtOne());
        fragments.add(new FragemtTeo());
        fragments.add(new FragemtThree());
        fragments.add(new FragemtFor());
        fragments.add(new FragemtFive());
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), stringList, fragments);
        viewpager.setAdapter(viewPagerAdapter);
        viewpager.setOffscreenPageLimit(5);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    viewpager.setCurrentItem(0);*/
             /*   Intent intent = new Intent(TestActivity.this, MainTwoActivity.class);
                startActivity(intent);*/
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager.setCurrentItem(1);
            }
        });


        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager.setCurrentItem(2);
            }
        });


        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager.setCurrentItem(3);
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpager.setCurrentItem(4);
            }
        });

    }


    OkhttpUtils okhttpUtils = new OkhttpUtils() {
        @Override
        protected void ShowResponse(String response, int okitem) {


        }

        @Override
        protected void ShowError(String response, int erritem) {

        }
    };



/*
    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
    public void ViewOnclik(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                viewpager.setCurrentItem(0);
                break;
            case R.id.btn2:
                viewpager.setCurrentItem(1);
                break;
            case R.id.btn3:
                viewpager.setCurrentItem(2);
                break;
            case R.id.btn4:
                viewpager.setCurrentItem(3);
                break;
            case R.id.btn5:
                viewpager.setCurrentItem(4);
                break;
        }
    }*/
}
