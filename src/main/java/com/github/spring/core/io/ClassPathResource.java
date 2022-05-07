package com.github.spring.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 类路径资源
 * @author wang xiao
 * @date 2022/5/7
 */
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path,null);

    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        assert path!= null;
        this.path = path;
        this.classLoader = (classLoader!= null?classLoader:Thread.currentThread().getContextClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream in = classLoader.getResourceAsStream(path);
        if (in == null){
            throw new FileNotFoundException(this.path+" cannot be opened because it does not exist");
        }
        return in;
    }
}
