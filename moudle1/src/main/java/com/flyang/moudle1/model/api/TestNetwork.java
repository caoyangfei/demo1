package com.flyang.moudle1.model.api;

import com.flyang.annotation.apt.ContractFactory;
import com.flyang.moudle1.model.entity.TestEntity;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/7/14
 * ------------- Description -------------
 */

@ContractFactory(entites = {TestEntity.class})
public interface TestNetwork extends Test2Network {
    void getOffice();
}
