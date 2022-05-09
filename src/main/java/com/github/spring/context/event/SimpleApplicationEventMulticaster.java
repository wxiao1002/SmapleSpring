package com.github.spring.context.event;

import java.util.Collection;

/**
 * 事件广播器
 * @author wang xiao
 * @date 2022/5/9
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    @Override
    public void multicastEvent(ApplicationEvent event) {
        final Collection<ApplicationListener<ApplicationEvent>> applicationListeners = getApplicationListeners(event);
        for (ApplicationListener<ApplicationEvent> applicationListener : applicationListeners) {
            applicationListener.onApplicationEvent(event);
        }
    }
}
