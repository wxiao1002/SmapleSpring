package com.github.spring.context.event;

import com.github.spring.context.ApplicationContext;

/**
 * 应用上下文 时间
 * @author wang xiao
 * @date 2022/5/9
 */
public class ApplicationContextEvent extends ApplicationEvent{

    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) source;
    }
}
