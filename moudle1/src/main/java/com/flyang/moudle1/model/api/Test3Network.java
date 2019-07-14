package com.flyang.moudle1.model.api;

import com.flyang.annotation.apt.ContractFactory;
import com.flyang.moudle1.model.entity.Test3Entity;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/7/14
 * ------------- Description -------------
 */

@ContractFactory(entites = {Test3Entity.class})
public interface Test3Network {
    void getOffice3();
}
