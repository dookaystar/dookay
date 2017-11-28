package dookay.dklibrary.utils;

import android.app.Activity;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.Map;

import okhttp3.Call;

/**
 * 用于数据请求
 * Created by  on 2017/1/3.
 */
public abstract class OkhttpUtils {

    public void getJson(String url, final Map<String, String> map, final int i) {
        OkHttpUtils
                .get()
                .addHeader("Accept", "application/json")
                .url(url).params(map)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }
                    @Override
                    public void onResponse(String response, int id) {
                        ShowResponse(response, i);
                    }
                });
    }

    public void postJson(final String url, Map<String, String> map, final int i) {

        OkHttpUtils
                .post()
                .addHeader("Accept", "application/json")
                .url(url).params(map)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ShowError(e.getMessage(), i);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ShowResponse(response, i);
                    }
                });
    }

    /**
     * 上传文件
     *
     * @param url
     * @param file
     * @param i
     */
    public void postFile(String url, File file, final int i) {
        OkHttpUtils.post()
                .addHeader("Accept", "application/json")
                .addFile("file", file.getName(), file)
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ShowError(e.getMessage(), i);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ShowResponse(response, i);
                    }
                });
    }
    
    public void getJsonResutFive(final String url, final Map<String, String> map, final int i) {
        OkHttpUtils
                .get()
                .addHeader("Accept", "application/json")
                .url(url).params(map)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ShowError(e.getMessage(), i);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ShowResponse(response, i);
                    }
                });
    }

    protected abstract void ShowResponse(String response, int okitem);

    protected abstract void ShowError(String response, int erritem);
}
