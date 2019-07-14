package com.flyang.moudle1;


import android.view.View;
import android.widget.Button;

import com.flyang.annotation.Controller;
import com.flyang.annotation.Presenter;
import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.InjectParam;
import com.flyang.annotation.apt.OnClick;
import com.flyang.annotation.apt.Router;
import com.flyang.api.router.IntentRouter;
import com.flyang.base.fragment.BasePresenterFragment;
import com.flyang.moudle1.model.contract.TestNetworkContract;
import com.flyang.moudle1.model.entity.Test2Entity;
import com.flyang.moudle1.model.entity.TestEntity;
import com.flyang.moudle1.presenter.ModulePresenter;
import com.flyang.util.log.LogUtils;


@Router("fragment1")
public class Module1Fragment extends BasePresenterFragment implements TestNetworkContract.View{
    // Test param inject, not been used.
    @InjectParam
    int test1 = 123; // test default value
    @InjectParam(key = "test22")
    char[] test2;

    @BindView("btn_go")
    Button btn_go;

    @Presenter
    ModulePresenter modulePresenter;
    @Controller
    ModuleController moduleController;

    public Module1Fragment() {
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_module1;
    }

    @Override
    protected void onInit() {
        super.onInit();
        IntentRouter.injectParams(Module1Fragment.this);
        LogUtils.d(Module1Fragment.class.getSimpleName(), "test1=" + this.test1);
    }

    @OnClick(value = {"btn_go"})
    public void onCLick(View view) {
//        moduleController.setString();
        IntentRouter.build("moudle2").go(Module1Fragment.this);
        getActivity().finish();
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
