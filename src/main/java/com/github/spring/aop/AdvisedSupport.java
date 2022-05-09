package com.github.spring.aop;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author wang xiao
 * @date 2022/5/9
 */
public class AdvisedSupport {

    private boolean proxyTargetClass = false;

    private TargetSource targetSource;


    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }
}
