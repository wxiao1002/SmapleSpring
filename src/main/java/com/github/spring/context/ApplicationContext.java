package com.github.spring.context;

import com.github.spring.beans.factory.ListableBeanFactory;
import com.github.spring.context.event.ApplicationEventPublisher;
import com.github.spring.core.io.ResourceLoader;

/**
 * 上下文
 * @author wang xiao
 * @date 2022/5/7
 */
public interface ApplicationContext extends ListableBeanFactory, ApplicationEventPublisher, ResourceLoader {
}
