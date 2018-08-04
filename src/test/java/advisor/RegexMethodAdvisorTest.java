package advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 正则表达式切面
 */
public class RegexMethodAdvisorTest {

    @Test
    public void regexAdvisor(){
        ApplicationContext context = new ClassPathXmlApplicationContext("advisor/beans.xml");
        Waitor waitor = (Waitor)context.getBean("waiter1");
        waitor.greetTo("scott");
        System.out.println();
        waitor.serveTo("nick");
    }
}
