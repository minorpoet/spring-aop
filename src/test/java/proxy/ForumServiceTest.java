package proxy;

import cglibproxy.CglibProxy;
import forum.ForumService;
import forum.ForumServiceImpl;
import jdkproxy.PerformanceHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

  @Test
  public void testJdkProxy() {
    ForumService target = new ForumServiceImpl();

    PerformanceHandler handler = new PerformanceHandler(target);

    // 创建 jdk 动态代理类
    /** jdk 动态代理类 Proxy ，是根据目标类的接口创建一个代理实例，然后通过 InvocationHandler.invoke 来向目标类实例中添加功能 */
    Object proxy =
        Proxy.newProxyInstance(
            target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    ForumService proxyInterface = (ForumService) proxy;
    proxyInterface.removeForum(11);
    proxyInterface.removeTopic(22);
  }

  @Test
  public void testCglibProxy() {
    Object proxy = new CglibProxy().getProxy(ForumServiceImpl.class);

    ForumService proxyInterface = (ForumService) proxy;
    proxyInterface.removeForum(11);
    proxyInterface.removeTopic(22);
  }
}
