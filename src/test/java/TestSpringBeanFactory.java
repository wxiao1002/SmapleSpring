import com.github.spring.core.BeanDefinition;
import com.github.spring.factory.DefaultListableBeanFactory;

/**
 * @author wang xiao
 * @date 2022/5/7
 */
public class TestSpringBeanFactory {

    public static void main(String[] args) {
        BeanDefinition<MyService> beanDefinition = new BeanDefinition<>(MyService.class);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("myService",beanDefinition);
        Object myService = beanFactory.getBean("myService","王潇p");
        System.out.println(myService);
    }
}
