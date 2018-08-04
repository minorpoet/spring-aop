package autoproxy;

import advisor.Sellor;
import advisor.Waitor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanNameAutoProxyCreator 自动代理
 */
public class BeanNameAutoProxyCreatorTest {
    @Test
    public void autoProxy() {
        String configPath = "autoproxy/beanname-beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waitor waiter = (Waitor) ctx.getBean("waiter");
        Sellor seller = (Sellor) ctx.getBean("seller");
        waiter.serveTo("John");
        waiter.greetTo("John");
        //seller.greetTo("Tom");
    }
}
