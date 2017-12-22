package dookay.myapplication.fragment;


import android.support.v4.app.Fragment;

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
 * @date：2017/12/18  17:18
 * @describe:
 */
public abstract class LazyFragment extends Fragment {
    protected boolean isVisible;

    /**
     * 在这里实现Fragment数据的缓加载.
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected void onInvisible() {
    }
}