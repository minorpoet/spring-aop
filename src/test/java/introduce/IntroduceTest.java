package introduce;

import forum.ForumService;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroduceTest {

    @Test
    public void introduce() {
        String configPath = "introduce/introduce-bean.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        ForumService forumService = (ForumService) ctx.getBean("forumService");

        forumService.removeForum(1);
        forumService.removeTopic(11);

        System.out.println();
        System.out.println("-----------------------调用引入的方法， 开启监控");
        System.out.println();

        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(2);
        forumService.removeTopic(22);

    }
}
