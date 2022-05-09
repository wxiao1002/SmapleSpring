package com.github.spring.context.event;

import java.util.EventObject;

/**
 * application event
 * @author wang xiao
 * @date 2022/5/9
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}
