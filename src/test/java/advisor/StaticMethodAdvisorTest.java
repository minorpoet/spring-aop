package advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticMethodAdvisorTest {

    @Test
    public void staticAdvisorTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("advisor/beans.xml");
        Waitor waitor = (Waitor) ctx.getBean("waiter");
        Sellor sellor = (Sellor) ctx.getBean("seller");

        waitor.greetTo("john");
        System.out.println();
        sellor.greeTo("nick");
    }
}
