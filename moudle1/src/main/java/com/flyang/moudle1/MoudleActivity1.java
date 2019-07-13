package com.flyang.moudle1;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.flyang.annotation.Controller;
import com.flyang.annotation.Presenter;
import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.OnClick;
import com.flyang.annotation.apt.Router;
import com.flyang.api.router.IntentRouter;
import com.flyang.base.activity.BasePresenterActivity;
import com.flyang.factory.Moudle1InstanceFactory;
import com.flyang.util.log.LogUtils;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/6/7
 * ------------- Description -------------
 */
@Router("moudle1")
public class MoudleActivity1 extends BasePresenterActivity implements MyView {

    @BindView("btn1")
    Button btn1;
    @BindView("btn2")
    Button btn2;

    @Presenter
    ModulePresenter modulePresenter;
    @Controller
    ModuleController moduleController;

    @Override
    protected int getLayoutID() {
        return R.layout.ac_moudle1;
    }


    @Override
    protected void onInit() {
        super.onInit();
        Fragment fragment = (Fragment) IntentRouter.build("fragment1").with("test1", 111).getFragment(this);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment1, fragment).commit();
        }
    }

    @Override
    protected void initData() {
        super.initData();
        LogUtils.e("moudle");
        modulePresenter.setString();
    }

    @OnClick(value = {"btn1", "btn2"})
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn1) {
            moduleController.setString();
        }
    }

    @Override
    protected <T> T getInstance(Class clazz) {
        return (T) Moudle1InstanceFactory.create(clazz);
    }
}
