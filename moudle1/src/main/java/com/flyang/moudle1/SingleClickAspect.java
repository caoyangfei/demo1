package com.flyang.moudle1;

import android.view.View;

import com.flyang.util.log.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Calendar;

/**
 * Created by baixiaokang on 16/12/9.
 * 防止View被连续点击,间隔时间600ms
 */
@Aspect
public class SingleClickAspect {
    static int TIME_TAG = 0x01;
    public static final int MIN_CLICK_DELAY_TIME = 600;

    @Pointcut("execution(@com.flyang.annotation.aop.SingleClick * *(..))")//方法切入点
    public void methodAnnotated() {
    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    public void aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        View view = null;
        for (Object arg : joinPoint.getArgs())
            if (arg instanceof View) view = (View) arg;
        if (view != null) {
            Object tag = view.getTag(TIME_TAG);
            long lastClickTime = ((tag != null) ? (long) tag : 0);
            LogUtils.tag("SingleClickAspect").d("lastClickTime:" + lastClickTime);
            long currentTime = Calendar.getInstance().getTimeInMillis();
            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {//过滤掉600毫秒内的连续点击
                view.setTag(TIME_TAG, currentTime);
                LogUtils.tag("SingleClickAspect").d("currentTime:" + currentTime);
                joinPoint.proceed();//执行原方法
            }
        }
    }
}
