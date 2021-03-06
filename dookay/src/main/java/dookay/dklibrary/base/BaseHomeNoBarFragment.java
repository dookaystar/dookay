package dookay.dklibrary.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import butterknife.ButterKnife;
import dookay.dklibrary.view.LoadingDialogUtils;
import dookay.dklibrary.view.ToastView;

public abstract class BaseHomeNoBarFragment extends Fragment {
    protected Activity mActivity;
    public Gson gson;
    public LoadingDialogUtils dialogUtils;
    public ToastView toastView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        
        //当前手机版本为Android 5.0及以上
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getActivity().getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        dialogUtils = new LoadingDialogUtils(getActivity());
        toastView = new ToastView(getActivity());
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    /**
     * 页面跳转
     *
     * @param cla
     */
    public void setIntentClass(Class<?> cla) {
        Intent intent = new Intent();
        intent.setClass(mActivity, cla);
        startActivity(intent);
    }


    /**
     * 该抽象方法就是 onCreateView中需要的layoutID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 该抽象方法就是 初始化view
     *
     * @param view
     * @param savedInstanceState
     */
    protected abstract void initView(View view, Bundle savedInstanceState);
}

