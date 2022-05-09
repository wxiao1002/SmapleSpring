package com.github.spring.context.event;

import java.util.EventListener;

/**
 * 事件监听类
 * @author wang xiao
 * @date 2022/5/9
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 事件发生方法调用
     * @param event event
     */
    void onApplicationEvent(E event);

}
