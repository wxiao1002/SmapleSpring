package com.github.spring.beans;

import com.github.spring.beans.PropertyValues;

/**
 * 定义 bean 的是实例化信息
 * @author wang xiao
 * @date 2022/5/7
 */
public class BeanDefinition<T> {

   private final Class<T>  beanClass;

   private final PropertyValues propertyValues;

   private String initMethod;

   private String destroyMethod;

   public BeanDefinition(Class<T> beanClass) {
      this.beanClass = beanClass;
      this.propertyValues = new PropertyValues();
   }

   public BeanDefinition(Class<T> beanClass, PropertyValues propertyValues) {
      this.beanClass = beanClass;
      this.propertyValues = propertyValues;
   }

   public Class<T> getBeanClass() {
      return beanClass;
   }

   public PropertyValues getPropertyValues() {
      return propertyValues;
   }

   public String getInitMethod() {
      return initMethod;
   }

   public void setInitMethod(String initMethod) {
      this.initMethod = initMethod;
   }

   public String getDestroyMethod() {
      return destroyMethod;
   }

   public void setDestroyMethod(String destroyMethod) {
      this.destroyMethod = destroyMethod;
   }
}
