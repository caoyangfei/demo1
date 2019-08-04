package com.flyang.moudle1;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.flyang.annotation.Presenter;
import com.flyang.base.controller.BasePresenterController;
import com.flyang.moudle1.model.contract.TestNetworkContract;
import com.flyang.moudle1.model.entity.Test2Entity;
import com.flyang.moudle1.model.entity.Test3Entity;
import com.flyang.moudle1.model.entity.TestEntity;
import com.flyang.moudle1.presenter.ModulePresenter;
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
public class ModuleController extends BasePresenterController implements TestNetworkContract.View {


    @Presenter
    ModulePresenter modulePresenter;

    public ModuleController(FragmentActivity activity, View rootView) {
        super(activity, rootView);
    }

    @SuppressLint("CheckResult")
    public void setString() {
        modulePresenter.getOffice();

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

    @Override
    public void getOffice3Success(Test3Entity entity) {
        mResultCallBackLisenter.resultSuccess(entity);
    }

    @Override
    public void getOffice3Failed(String errorMsg) {

    }

    @Override
    public void getOffice2Success(Test2Entity entity) {

    }

    @Override
    public void getOffice2Failed(String errorMsg) {

    }

    @Override
    public void getOfficeSuccess(TestEntity entity) {
        mResultCallBackLisenter.resultSuccess(entity);
    }

    @Override
    public void getOfficeFailed(String errorMsg) {
        mResultCallBackLisenter.resultError(errorMsg);
    }
}
