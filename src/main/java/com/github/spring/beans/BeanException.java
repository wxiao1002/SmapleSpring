package com.github.spring.beans;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class BeanException extends RuntimeException{

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
