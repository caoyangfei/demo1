package com.flyang.demo1;

import android.net.Uri;
import android.view.View;
import android.widget.Button;

import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.OnClick;
import com.flyang.api.router.IntentRouter;
import com.flyang.base.activity.BasePresenterActivity;
import com.flyang.base.controller.loader.CircleLoaderController;
import com.flyang.util.cache.CacheDiskStaticUtils;
import com.flyang.view.inter.Loader;

public class MainActivity extends BasePresenterActivity {

    @BindView("btn1")
    Button btn1;
    @BindView("btn2")
    Button btn2;


    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInit() {
        super.onInit();
        String moduleName = getString(R.string.moduleName);
        CacheDiskStaticUtils.put("test", "123455", 1000);
//        SmartRefreshLayout
    }

    @OnClick(value = {"btn1", "btn2", "btn3"})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                String test = CacheDiskStaticUtils.getString("test");
                IntentRouter.build("moudle1").go(this);
                break;
            case R.id.btn2:
                IntentRouter.build(Uri.parse("test://filter/module2")).go(this);
                break;
            case R.id.btn3:
                loaderController.showLoader("加载中。。。");
                break;
        }
    }

    @Override
    protected Loader getLoaderController() {
        CircleLoaderController circleLoaderController = new CircleLoaderController(this, rootView);
        registerController(CircleLoaderController.class.getSimpleName(), circleLoaderController);
        return circleLoaderController;
    }
}
