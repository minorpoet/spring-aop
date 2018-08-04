package advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * 后置增强
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(
            @Nullable Object returnValue, Method method, Object[] args, @Nullable Object target)
            throws Throwable {
        System.out.println("[after advice] Please enjoy yourself!");
    }
}
