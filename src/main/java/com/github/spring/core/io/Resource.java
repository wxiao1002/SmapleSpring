package com.github.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载 定义接口
 * @author wang xiao
 * @date 2022/5/7
 */
public interface Resource {

    /**
     * 加载资源
     * @return InputStream
     * @throws IOException IOException
     */
    InputStream getInputStream() throws IOException;
}
