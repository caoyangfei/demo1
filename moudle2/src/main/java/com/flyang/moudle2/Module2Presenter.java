package com.flyang.moudle2;

import com.flyang.annotation.apt.InstanceFactory;
import com.flyang.base.presenter.BasePresenter;
import com.flyang.util.log.LogUtils;

/**
 * @author yangfei.cao
 * @ClassName aptlib_demo
 * @date 2019/7/9
 * ------------- Description -------------
 */
@InstanceFactory
public class Module2Presenter extends BasePresenter<MyView2> implements MyAPI2 {

    @Override
    public void setString() {
        LogUtils.e("打印测试");
    }
}
