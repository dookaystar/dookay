package dookay.myapplication;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.io.File;
import java.util.List;

import dookay.dklibrary.settings.AppUpdateUtils;


public class MainActivity extends AppCompatActivity {


    TextView txtinfo;
    AppUpdateUtils updateUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtinfo = (TextView) findViewById(R.id.txtinfo);
        updateUtils = new AppUpdateUtils(MainActivity.this);
        txtinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Acp.getInstance(MainActivity.this).request(new AcpOptions.Builder()
                                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                .build(),
                        new AcpListener() {
                            @Override
                            public void onGranted() {
                                updateUtils.downloadAPK("http://imtt.dd.qq.com/16891/B5AD1A30EFA226AC9900D76AF4A8BB1C.apk?fsname=com.netease.newsreader.activity_29.1_747.apk&csr=1bbd", "wangyi.apk", "网易应用");
                            }
                            @Override
                            public void onDenied(List<String> permissions) {
                            }
                        });
            }
        });

    }


    private File uri2File(Uri uri) {
        String img_path;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor actualimagecursor = managedQuery(uri, proj, null,
                null, null);
        if (actualimagecursor == null) {
            img_path = uri.getPath();
        } else {
            int actual_image_column_index = actualimagecursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            img_path = actualimagecursor
                    .getString(actual_image_column_index);
        }
        File file = new File(img_path);
        return file;
    }


}
