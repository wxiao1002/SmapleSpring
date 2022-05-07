package com.github.spring.core;

/**
 * 定义 bean 的是实例化信息
 * @author wang xiao
 * @date 2022/5/7
 */
public class BeanDefinition<T> {

   private final Class<T>  beanClass;

   public BeanDefinition(Class<T> beanClass) {
      this.beanClass = beanClass;
   }

   public Class<T> getBeanClass() {
      return beanClass;
   }


}
