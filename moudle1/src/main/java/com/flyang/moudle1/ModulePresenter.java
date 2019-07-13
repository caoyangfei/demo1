package com.flyang.moudle1;

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
public class ModulePresenter extends BasePresenter<MyView> implements MyAPI {

    @Override
    public void setString() {
        LogUtils.e("打印测试");
    }
}
