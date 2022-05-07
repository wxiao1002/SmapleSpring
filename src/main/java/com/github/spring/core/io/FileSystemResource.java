package com.github.spring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件系统 资源
 * @author wang xiao
 * @date 2022/5/7
 */
public class FileSystemResource implements Resource{

    private final String path;

    private final File file;


    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(String path, File file) {
        this.path = path;
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
}
