package com.flyang.moudle1.presenter;

import com.flyang.annotation.apt.InstanceFactory;
import com.flyang.moudle1.model.contract.TestNetworkContract;
import com.flyang.util.log.LogUtils;

/**
 * @author yangfei.cao
 * @ClassName aptlib_demo
 * @date 2019/7/9
 * ------------- Description -------------
 */
@InstanceFactory
public class ModulePresenter extends TestNetworkContract.Presenter {


    @Override
    public void getOffice() {
        LogUtils.e("打印测试");
        getView().getOfficeFailed("打印测试");
    }

    @Override
    public void getOffice2() {
        LogUtils.e("打印测试");
        getView().getOffice2Failed("打印测试");
    }
}
