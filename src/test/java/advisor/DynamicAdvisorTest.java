package advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 动态切面
 */
public class DynamicAdvisorTest {

    @Test
    public void dynamicAdvisor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("advisor/beans.xml");
        Waitor waitor = (Waitor)context.getBean("waiter2");
        waitor.greetTo("hh");
        System.out.println();
        waitor.serveTo("yy");
        System.out.println();

        // 动态切
        waitor.greetTo("nick");
        waitor.greetTo("scott");
    }
}
