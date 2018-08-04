package advisor;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * 前置增强
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "." + method.getName());
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
