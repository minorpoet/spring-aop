package advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/** 前置增强 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

  /**
   * @param method 目标类的方法
   * @param args 参数
   * @param target 目标类实例
   * @throws Throwable
   */
  @Override
  public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
    String clientName = (String) args[0];
    System.out.println("[before advice] How are you! Mr." + clientName);
  }
}
