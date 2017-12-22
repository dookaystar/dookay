package dookay.myapplication.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

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
 * @date：2017/12/18  17:28
 * @describe:
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> titles;
    private List<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
