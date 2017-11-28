package com.jph.takephoto;

import android.app.Activity;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.LubanOptions;
import com.jph.takephoto.model.TakePhotoOptions;

import java.io.File;
/**
 * 用于拍照
 * B 代表 Bytes
 *
 * @author：Qaufue
 * @date：2017/11/24
 * @time：13:34
 * @describe:
 */
public class PhotoUtil {
    private Activity activity;
    public TakePhoto takePhoto;
    /**
     * isShear =是否剪切
     * isCuttingTool= 剪切工具   true默认使用 TakePhoto自带的剪切工具
     * widthShear== 裁剪的宽
     * highShear ==裁剪的高
     * isCompressionTool= 压缩工具  false 使用自带压缩工具
     * isCompress  ==是否压缩
     * isShowProgressBar== 是否显示进度条 默认不显示
     * pictureSize==图片大小 单位Byte
     * isBringAlbum == 是否使用TakePhoto自带相册
     * selectPhotoCount==  相片的张数
     * isCorrectionAngle== 是否纠正相片角度  默认true 不纠正角度
     * isSavePictures == 是否保存图片 默认不保存
     * isSelectAddress== 选择图片的地址， 相册和文件中 默认相册
     */
    private boolean isShear, isCuttingTool = true, isCompressionTool = true, isCompress, isShowProgressBar, isBringAlbum = true, isSelectAddress = false, isCorrectionAngle = true, isSavePictures;
    private int widthShear = 800, highShear = 800, pictureSize, selectPhotoCount;

    /**
     * @param activity
     * @param takePhoto
     * @param isShear          是否剪切
     * @param isCompress       是否压缩
     * @param pictureSize      图片大小
     * @param selectPhotoCount 相片的张数
     */
    public PhotoUtil(Activity activity, TakePhoto takePhoto, boolean isShear, boolean isCompress, int pictureSize, int selectPhotoCount) {
        this.activity = activity;
        this.takePhoto = takePhoto;
        this.isShear = isShear;
        this.isCompress = isCompress;
        this.pictureSize = pictureSize;
        this.selectPhotoCount = selectPhotoCount;
        isCorrectionAngle = true;
    }

    // 开始拍照
    public void takePhotograph() {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        if (isShear) {
            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
        } else {
            takePhoto.onPickFromCapture(imageUri);
        }
    }


    // 开始选择图片
    public void choosePicture() {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);

        if (selectPhotoCount > 1) {
            if (isShear) {
                takePhoto.onPickMultipleWithCrop(selectPhotoCount, getCropOptions());
            } else {
                takePhoto.onPickMultiple(selectPhotoCount);
            }
            return;
        }

        if (isSelectAddress) {
            if (isShear) {
                takePhoto.onPickFromDocumentsWithCrop(imageUri, getCropOptions());
            } else {
                takePhoto.onPickFromDocuments();
            }
            return;
        } else {
            if (isShear) {
                takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
            } else {
                takePhoto.onPickFromGallery();
            }
        }
    }

    private void configCompress(TakePhoto takePhoto) {
        if (!isCompress) {
            takePhoto.onEnableCompress(null, false);
            return;
        }
        CompressConfig config;
        if (isCompressionTool) {
            config = new CompressConfig.Builder()
                    .setMaxSize(pictureSize)
                /*    .setMaxPixel(width >= height ? width : height)*/
                    .enableReserveRaw(isSavePictures)
                    .create();
        } else {
            LubanOptions option = new LubanOptions.Builder()
              /*      .setMaxHeight(height)
                    .setMaxWidth(width)*/
                    .setMaxSize(pictureSize)
                    .create();
            config = CompressConfig.ofLuban(option);
            config.enableReserveRaw(isSavePictures);
        }
        takePhoto.onEnableCompress(config, isShowProgressBar);

    }

    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        if (isBringAlbum) {
            builder.setWithOwnGallery(true);
        }
        if (isCorrectionAngle) {
            builder.setCorrectImage(true);
        }
        takePhoto.setTakePhotoOptions(builder.create());
    }

    private CropOptions getCropOptions() {
        if (!isShear) return null;
        CropOptions.Builder builder = new CropOptions.Builder();
        if (true) { // 宽* 高
            builder.setAspectX(widthShear).setAspectY(highShear);
        } else {
            builder.setOutputX(widthShear).setOutputY(highShear);
        }
        builder.setWithOwnCrop(isCompressionTool);
        return builder.create();
    }

}
