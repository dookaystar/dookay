package dookay.dklibrary.utils;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.library.BaseRecyclerAdapter;
import com.github.library.animation.AnimationType;
import com.github.library.view.LoadType;

/**
 * Created by 李双 on 2017/2/9.
 */

public class RecylerAdapterUtils {

    /**
     * 用于设置 adpter   ,
     *
     * @param context         上下文
     * @param recyclerView    RecyclerView
     * @param recyclerAdapter BaseRecyclerAdapter
     */
    public static void SetAdapter(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter) {
        recyclerAdapter.openLoadAnimation(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public static void OrLadMore(BaseRecyclerAdapter recyclerAdapter, int size) {
        if (size != ConstantIntUtils.FIFTEEN) {
            recyclerAdapter.addNoMoreView();
        }
    }

    public static void YesOrLadMore(BaseRecyclerAdapter recyclerAdapter, int morensize, int size) {
        if (size != morensize) {
            recyclerAdapter.addNoMoreView();
        } else {
            recyclerAdapter.notifyDataChangeAfterLoadMore(true);
        }
    }

    /**
     * 禁止 下拉
     *
     * @param recyclerAdapter
     */
    public static void OnLadMore(BaseRecyclerAdapter recyclerAdapter) {

        recyclerAdapter.addNoMoreView();
    }

    /**
     * 用于设置 adpter   ,  判断 数据有没有 等于10 若没有 则启动 下拉刷新  ，设置间隔距离
     *
     * @param context         上下文
     * @param recyclerView    RecyclerView
     * @param recyclerAdapter BaseRecyclerAdapter
     * @param linSpace        距离空间
     */
    public static void SetAdapterNew(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter, int linSpace) {
        recyclerAdapter.openLoadAnimation(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        //用于adapter  的上拉刷新
        recyclerAdapter.openLoadingMore(true);
        recyclerAdapter.openLoadAnimation(AnimationType.CUSTOM);//ALPHA
        recyclerAdapter.setLoadMoreType(LoadType.CUBES);
    }

    /**
     * 用于设置 adpter   ,  判断 数据有没有 等于10 若没有 则启动 下拉刷新  ，设置间隔距离
     *
     * @param context         上下文
     * @param recyclerView    RecyclerView
     * @param recyclerAdapter BaseRecyclerAdapter
     * @param linSpace        距离空间
     * @param contitem        首次请求的数据数量 ，用于判断是否启动上拉加载
     * @param color           颜色
     */
    public static void SetAdapterNewColor(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter, int linSpace, int showitem, int contitem, int color) {
        recyclerAdapter.openLoadAnimation(false);
        //recyclerView.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.VERTICAL, linSpace, R.color.white));  // IntConstant.Twenty 间隔的距离 ；R.color.colornull  间隔的颜色
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        //用于adapter  的上拉刷新
        recyclerAdapter.openLoadingMore(true);
        recyclerAdapter.openLoadAnimation(AnimationType.CUSTOM);//ALPHA
        recyclerAdapter.setLoadMoreType(LoadType.CUBES);
        if (contitem != showitem) {
            recyclerAdapter.addNoMoreView();
        }
    }

    public static void listuitl(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter, int i) {
        recyclerAdapter.openLoadAnimation(false);
        recyclerAdapter.openLoadingMore(true);
        recyclerAdapter.openLoadAnimation(AnimationType.CUSTOM);//ALPHA
        recyclerAdapter.setLoadMoreType(LoadType.CUBES);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public static void listuitlAddColor(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter, int i, int color) {
        recyclerAdapter.openLoadAnimation(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public static void listuitlHorizontal(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter, int i) {
        recyclerAdapter.openLoadAnimation(false);
        // recyclerView.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.VERTICAL, i * ConstantIntUtils.TWO, ContextCompat.getColor(context, R.color.listline)));  // IntConstant.Twenty 间隔的距离 ；R.color.colornull  间隔的颜色
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public static void listuitlGridLayoutManager(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter, int i) {
        recyclerAdapter.openLoadAnimation(false);
        GridLayoutManager mgr2 = new GridLayoutManager(context, ConstantIntUtils.TWO);
        recyclerView.setLayoutManager(mgr2);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public static void listuitlGridLayoutManager3(Context context, RecyclerView recyclerView, BaseRecyclerAdapter recyclerAdapter, int i, int griditem) {

   /*     //防止滑动卡顿
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context, griditem){
            @Override
            public boolean canScrollVertically()
            {
                return false;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);

*/
        //recyclerView.addItemDecoration(new RecycleViewDivider(context, LinearLayoutManager.VERTICAL, i * ConstantIntUtils.TWO, ContextCompat.getColor(context, R.color.listline)));  // IntConstant.Twenty 间隔的距离 ；R.color.colornull  间隔的颜色
        GridLayoutManager mgr2 = new GridLayoutManager(context, griditem);
        recyclerView.setLayoutManager(mgr2);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.openLoadAnimation(false);

    }

    /**
     * 设置下拉
     *
     * @param recyclerAdapter
     */
    public static void SetingLoadingMore(BaseRecyclerAdapter recyclerAdapter) {
        //用于adapter  的上拉刷新
        recyclerAdapter.openLoadingMore(true);
        recyclerAdapter.openLoadAnimation(AnimationType.CUSTOM);//ALPHA
        recyclerAdapter.setLoadMoreType(LoadType.CUBES);

    }


    public static void ReFreshLayoutSetColor(SwipeRefreshLayout refreshLayout) {

        //设置卷内的颜色
        refreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
    }


}