package dookay.dklibrary.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;

import java.io.Serializable;

import butterknife.ButterKnife;
import dookay.dklibrary.view.LoadingDialogUtils;
import dookay.dklibrary.view.ToastView;

public abstract class BaseNoBarActivity extends AppCompatActivity {

    public Gson gson;
    public LoadingDialogUtils dialogUtils;
    public ToastView toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        //当前手机版本为Android 5.0及以上
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        gson = new Gson();
        toastView = new ToastView(BaseNoBarActivity.this);
        dialogUtils = new LoadingDialogUtils(BaseNoBarActivity.this);
        getIntentData(savedInstanceState);
        initView();
        initData();
    }

    /**
     * Activity的跳转
     *
     * @param cla
     */
    public void setIntentClass(Class<?> cla) {
        Intent intent = new Intent();
        intent.setClass(this, cla);
        startActivity(intent);
    }

    /**
     * Activity的跳转-带参数
     *
     * @param cla
     * @param obj
     */
    public void setIntentClass(Class<?> cla, Object obj) {
        Intent intent = new Intent();
        intent.setClass(this, cla);
        intent.putExtra("Intent", (Serializable) obj);
        startActivity(intent);
    }

    /**
     * Activity的跳转带参数
     *
     * @param cla
     * @param bundle
     */
    public void setIntentClass(Class<?> cla, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cla);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转页面使用请求码并携带参数
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void setIntentClassForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 跳转页面使用请求码并携带参数
     *
     * @param clazz
     * @param requestCode
     */
    protected void setIntentClassForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 加载布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 得到上一个Activity传来的Intent数据
     *
     * @param savedInstanceState
     */
    protected abstract void getIntentData(Bundle savedInstanceState);

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

}
