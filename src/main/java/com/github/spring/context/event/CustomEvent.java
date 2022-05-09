package com.github.spring.context.event;

/**
 * @author wang xiao
 * @date 2022/5/9
 */
public class CustomEvent extends ApplicationContextEvent{
    private final String message;



    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
