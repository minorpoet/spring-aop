package cglibproxy;

import forum.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** cglib 动态代理，利用字节码技术动态创建目标类的子类，然后在子类中拦截父类方法 */
public class CglibProxy implements MethodInterceptor {
  private Enhancer enhancer = new Enhancer();

  public Object getProxy(Class clazz) {
    // 设置需要创建子类的类
    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);
    // 通过字节码技术动态创建子类实例
    return enhancer.create();
  }

  /**
   * @param o 代理类
   * @param method 目标方法
   * @param objects 参数列表
   * @param methodProxy 代理方法
   * @return
   * @throws Throwable
   */
  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());
    // 调用父类方法
    Object result = methodProxy.invokeSuper(o, objects);
    PerformanceMonitor.end();
    return result;
  }
}