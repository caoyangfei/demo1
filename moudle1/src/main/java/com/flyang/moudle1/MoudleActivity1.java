package com.flyang.moudle1;

import android.Manifest;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.flyang.annotation.Controller;
import com.flyang.annotation.Presenter;
import com.flyang.annotation.aop.NeedPermission;
import com.flyang.annotation.aop.PermissionCanceled;
import com.flyang.annotation.aop.PermissionDenied;
import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.OnClick;
import com.flyang.annotation.apt.Router;
import com.flyang.aop.modle.bean.DenyBean;
import com.flyang.api.router.IntentRouter;
import com.flyang.base.activity.BasePresenterActivity;
import com.flyang.factory.Moudle1InstanceFactory;
import com.flyang.moudle1.model.contract.TestNetworkContract;
import com.flyang.moudle1.model.entity.Test2Entity;
import com.flyang.moudle1.model.entity.Test3Entity;
import com.flyang.moudle1.model.entity.TestEntity;
import com.flyang.moudle1.presenter.ModulePresenter;
import com.flyang.util.log.LogUtils;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/6/7
 * ------------- Description -------------
 */
@Router("moudle1")
public class MoudleActivity1 extends BasePresenterActivity implements TestNetworkContract.View {

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
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment1, fragment).commit();
        }
    }

    @Override
    protected void initData() {
        super.initData();
        LogUtils.e("moudle");
        modulePresenter.getOffice();
    }

    @NeedPermission(value = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    @OnClick(value = {"btn1", "btn2"})
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn1) {
            moduleController.setString();
        }
    }

    @PermissionCanceled
    public void cancle() {
        LogUtils.e("cancle");
    }

    @PermissionDenied
    public void deine(DenyBean denyBean) {
        LogUtils.e("deine" + denyBean.getDenyList());
    }

    @Override
    protected <T> T getInstance(Class clazz) {
        return (T) Moudle1InstanceFactory.create(clazz);
    }

    @Override
    public void getOffice3Success(Test3Entity entity) {

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

    }

    @Override
    public void getOfficeFailed(String errorMsg) {

    }
}
