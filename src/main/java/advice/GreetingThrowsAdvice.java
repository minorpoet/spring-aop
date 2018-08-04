package advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class GreetingThrowsAdvice implements ThrowsAdvice {

  public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
    System.out.println("--------");
    System.out.println("method: " + method.getName());
    System.out.println("抛出异常: " + ex.getMessage());
    System.out.println("事务成功回滚");
  }
}
