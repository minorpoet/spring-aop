package advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * 静态方法匹配切面
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor{

    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> Waitor.class.isAssignableFrom(clazz);
    }
}
