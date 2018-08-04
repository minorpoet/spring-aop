package advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/** 环绕增强， aop联盟 */
public class GreetingAroudAdvice implements MethodInterceptor {
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    System.out.println("[around - before] hello: " + invocation.getArguments()[0]);
    Object result = invocation.proceed();
    System.out.println("[around - after]  Please enjoy yourself! ");
    return result;
  }
}
