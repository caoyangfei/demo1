package com.flyang.moudle1;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.flyang.base.controller.BasePresenterController;
import com.flyang.util.log.LogUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * @author yangfei.cao
 * @ClassName aptlib_demo
 * @date 2019/7/9
 * ------------- Description -------------
 */
public class ModuleController extends BasePresenterController {

    public ModuleController(FragmentActivity activity, View rootView) {
        super(activity, rootView);
    }

    @SuppressLint("CheckResult")
    public void setString() {
        LogUtils.e("这是我的ModuleController");
        LogUtils.getLog2FileConfig().flushAsync();
        showLoading("这是我的ModuleController");
        Flowable.just(1)
                .delay(10, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        hideLoading();
                        launchActivity("moudle2", null);
                    }
                });

    }
}
