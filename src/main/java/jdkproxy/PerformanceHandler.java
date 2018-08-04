package jdkproxy;

import forum.ForumService;
import forum.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** jdk 动态代理的执行类 InvocationHandler */
public class PerformanceHandler implements InvocationHandler {

  private ForumService target;

  public PerformanceHandler(ForumService forumService) {
    this.target = forumService;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
    Object obj = method.invoke(target, args);
    PerformanceMonitor.end();
    return obj;
  }
}
