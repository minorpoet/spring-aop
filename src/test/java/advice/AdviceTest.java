package advice;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {

    @Test
    public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // spring 提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        // 设置代理目标
        pf.setTarget(target);
        // 为目标设置增强
        pf.addAdvice(advice);
        // 生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

    /** 通过 xml 定义的bean进行增强 ProxyFactoryBean */
    @Test
    public void adviceXmlBean() {
        String configPath = "advice/advice-bean.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("scott");
    }

    @Test
    public void after() {
        Advice after = new GreetingAfterAdvice();
        ProxyFactory factory = new ProxyFactory();
        Waiter waiter = new NaiveWaiter();
        factory.setTarget(waiter);
        factory.addAdvice(after);
        Waiter advisedWaiter = (Waiter) factory.getProxy();
        advisedWaiter.greetTo("scott");
        System.out.println();
        advisedWaiter.serveTo("nick");
    }

    // 环绕增强 org.aopalliance.intercept.MethodInterceptor
    @Test
    public void around() {
        Advice around = new GreetingAroudAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new NaiveWaiter());
        factory.addAdvice(around);
        Waiter advisedWaiter = (Waiter) factory.getProxy();
        advisedWaiter.serveTo("scott");
    }
}
