import com.github.spring.beans.PropertyValue;
import com.github.spring.beans.PropertyValues;
import com.github.spring.beans.BeanDefinition;
import com.github.spring.beans.BeanReference;
import com.github.spring.beans.factory.DefaultListableBeanFactory;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class TestSpringProperty {

    public static void main(String[] args) {

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("myId","123"));
        propertyValues.addPropertyValue(new PropertyValue("myDao",new BeanReference("myDao")));
        BeanDefinition<MyService> beanDefinition = new BeanDefinition<>(MyService.class,propertyValues);
        BeanDefinition<MyDao> beanDefinition1 = new BeanDefinition<>(MyDao.class);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("myService",beanDefinition);
        beanFactory.registerBeanDefinition("myDao",beanDefinition1);
        Object myService = beanFactory.getBean("myService","王潇p");
        System.out.println(myService);
    }
}
