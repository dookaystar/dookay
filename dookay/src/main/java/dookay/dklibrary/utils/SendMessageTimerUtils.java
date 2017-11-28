package dookay.dklibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import dookay.dklibrary.R;

/**
 * 倒计时
 *
 * @author：Qaufue
 * @date：2017/11/27
 * @time：14:50
 * @describe:
 */
public class SendMessageTimerUtils extends CountDownTimer {
    private TextView mTextView;
    private Context context;
    private int[] timecolor = {R.color.color_36, R.color.crop__button_text, R.color.crop__button_text, R.color.color_36, R.color.color_36};

    private boolean isPosition;
    private String txtstrinfo;

    /**
     * 设置 发送短信倒计时的方法
     *
     * @param context
     * @param textView
     * @param millisInFuture 只需要输入具体的秒数 比如 60
     * @param timecolor      int[3] 0:倒计时数字颜色 color，1 字体默认的颜色 ，2 字体 不能点击的颜色 3 倒计时 默认背景drawable，4倒计时不能点击的背景 drawable
     * @param isPosition     用于判定倒计时数字的位置  true  (  59  秒后可重新发送)  flase (重新发送:59)
     */
    public SendMessageTimerUtils(Context context, TextView textView, long millisInFuture, int[] timecolor, boolean isPosition, String txtstrinfo) {
        //这里的构造方法需要加入一个参数，传入一个TextView对象参数是为了对这个TextView对象进行点击事件的处理。
        // millisInFuture是传给onTick()的参数，countDownInterval是表示多长时间调用一次onTick()。即倒计时每隔多长时间
        //调用onTick()方法，即倒计时时间每次显示间隔多少秒。
        super(millisInFuture * 1000, 1000);
        this.timecolor = timecolor;
        this.context = context;
        this.isPosition = isPosition;
        this.txtstrinfo = txtstrinfo;
        mTextView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {//该方法在倒计时时调用
        mTextView.setClickable(false); //设置不可点击
        int timeSecond = (int) (millisUntilFinished / ConstantIntUtils.ONE_THOUSAND);


        mTextView.setBackgroundResource(timecolor[ConstantIntUtils.FOUR]); //设置按钮为灰色，这时是不能点击的
        mTextView.setTextColor(ContextCompat.getColor(context, timecolor[ConstantIntUtils.TWO]));


        if (isPosition) {
            mTextView.setText(timeSecond + txtstrinfo);  //设置倒计时时间
            //如果想给按钮上的字设置颜色可以进行以下操作：
            SpannableString spannableString = new SpannableString(mTextView.getText().toString());  //获取按钮上的文字
            ForegroundColorSpan span = new ForegroundColorSpan(ContextCompat.getColor(context, timecolor[ConstantIntUtils.ZERO]));//设置文本颜色

            if (timeSecond >= 100) {
                spannableString.setSpan(span, 0, 3, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            } else if (timeSecond >= 10) {
                spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            } else {
                spannableString.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            }
            mTextView.setText(spannableString);
        } else {
            mTextView.setText(txtstrinfo + timeSecond + "S");  //设置倒计时时间
            //如果想给按钮上的字设置颜色可以进行以下操作：
            SpannableString spannableString = new SpannableString(mTextView.getText().toString());  //获取按钮上的文字
            ForegroundColorSpan span = new ForegroundColorSpan(ContextCompat.getColor(context, timecolor[ConstantIntUtils.ZERO]));//设置文本颜色

            if (timeSecond >= 100) {
                spannableString.setSpan(span, mTextView.length() - ConstantIntUtils.FOUR, mTextView.length() - ConstantIntUtils.ONE, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            } else if (timeSecond >= 10) {
                spannableString.setSpan(span, mTextView.length() - ConstantIntUtils.THREE, mTextView.length() - ConstantIntUtils.ONE, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            } else {
                spannableString.setSpan(span, mTextView.length() - ConstantIntUtils.TWO, mTextView.length() - ConstantIntUtils.ONE, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            }
            mTextView.setText(spannableString);
        }

    }

    @Override
    public void onFinish() {//计时结束之后实现这个方法
        super.cancel();
        mTextView.setText("重新获取验证码");
        mTextView.setTextColor(ContextCompat.getColor(context, timecolor[ConstantIntUtils.ONE]));
        mTextView.setClickable(true);//重新获得点击
        mTextView.setBackgroundResource(timecolor[ConstantIntUtils.THREE]);//还原背景色  R.drawable.bg_identify_code_normal
        //R.drawable.bg_identify_code_press
    }
}
