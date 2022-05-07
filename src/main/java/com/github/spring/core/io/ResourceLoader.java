package com.github.spring.core.io;

/**
 * 资源加载
 * @author wang xiao
 * @date 2022/5/7
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 加载资源
     * @param path 地址
     * @return 资源
     */
    Resource getResource(String path);
}
