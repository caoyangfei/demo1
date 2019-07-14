package com.flyang.moudle1.model.api;

import com.flyang.annotation.apt.ContractFactory;
import com.flyang.moudle1.model.entity.Test2Entity;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/7/14
 * ------------- Description -------------
 */
@ContractFactory(entites = {Test2Entity.class})
public interface Test2Network extends Test3Network{
    void getOffice2();

    @Override
    void getOffice3();
}
