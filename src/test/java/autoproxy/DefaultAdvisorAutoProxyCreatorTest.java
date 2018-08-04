package autoproxy;

import advisor.Sellor;
import advisor.Waitor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultAdvisorAutoProxyCreatorTest {

    @Test
    public void autoProxy(){
        String configPath = "autoproxy/advisor-beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waitor waiter = (Waitor) ctx.getBean("waiter");
        Sellor seller = (Sellor) ctx.getBean("seller");
        waiter.serveTo("John");
        waiter.greetTo("John");
    }
}
