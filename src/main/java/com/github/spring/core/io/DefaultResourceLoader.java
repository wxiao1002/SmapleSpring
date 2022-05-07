package com.github.spring.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认的资源加载
 * @author wang xiao
 * @date 2022/5/7
 */
public class DefaultResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String path) {
        assert path != null;
        if (path.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(path.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                URL url = new URL(path);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(path);
            }
        }
    }
}
