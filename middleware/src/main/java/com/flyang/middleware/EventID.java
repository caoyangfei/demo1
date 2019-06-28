package com.flyang.middleware;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/6/8
 * ------------- Description -------------
 */
public interface EventID {

    int ware = 0X001;//仓库
    int cgrkOrde = 0X002;//采购入库订单
    int xsckEnsure = 0X003;//销售出库单确认
    int placeset = 0X004;//货位
    int qtrkOrde = 0X005;//其它入库订单
    int qtckOrde = 0X006;//其它出库订单
    int scckOrde = 0X007;//生产出库出库订单
    int scrkOrde = 0X007;//生产入库出库订单
    int good = 0X008;//物品
    int llckEnsure = 0X009;//生产出库
    int pkOrde = 0X010;//盘库
    int product = 0X011;//现存物料

}
