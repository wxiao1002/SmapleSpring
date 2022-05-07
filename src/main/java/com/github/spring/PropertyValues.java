package com.github.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        propertyValues.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValues.toArray(new PropertyValue[propertyValues.size()]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValues) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
