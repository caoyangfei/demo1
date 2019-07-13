package com.flyang.moudle2;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;

import com.flyang.annotation.Presenter;
import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.OnClick;
import com.flyang.annotation.apt.Router;
import com.flyang.api.router.IntentRouter;
import com.flyang.base.activity.BasePresenterActivity;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/6/7
 * ------------- Description -------------
 */
@Router("test://filter/module2")
public class MoudleActivity2 extends BasePresenterActivity {

    @BindView("btn1")
    Button btn1;
    @BindView("btn2")
    Button btn2;

    @Presenter
    Module2Presenter modulePresenter;

    @Override
    protected int getLayoutID() {
        return R.layout.ac_moudle2;
    }

    @Override
    protected void onInit() {
        super.onInit();
        Fragment fragment = (Fragment) IntentRouter.build("fragment2").with("test1", 111).getFragment(this);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment2, fragment).commit();
        }
    }

    @OnClick(value = {"btn1", "btn2"})
    public void onClick(View view) {
        modulePresenter.setString();
    }
}
