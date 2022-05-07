package com.github.spring.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 地址资源
 * @author wang xiao
 * @date 2022/5/7
 */
public class UrlResource implements Resource{

    private final URL url;

    public UrlResource(URL path) {
        this.url = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {

        URLConnection urlConnection = url.openConnection();
        try {
            return urlConnection.getInputStream();
        }catch (IOException e){
            if (urlConnection instanceof HttpURLConnection){
                ((HttpURLConnection) urlConnection).disconnect();
            }
            throw e;
        }
    }
}
