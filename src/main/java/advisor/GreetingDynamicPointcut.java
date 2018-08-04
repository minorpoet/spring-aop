package advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态切点
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<>();
    static {
        specialClientList.add("nick");
        specialClientList.add("scott");
    }

    /**
     * 动态检查
     * @param method
     * @param targetClass
     * @param args
     * @return
     */
    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass, Object... args) {
        System.out.println("调用 matches(method,targetClass,args) 对"
                +targetClass.getName()+"."+method.getName()+"做动态检查");
        String clientName = (String)args[0];
        return specialClientList.contains(clientName);
    }

    /**
     * 动态检查
     * @param method
     * @param targetClass
     * @return
     */
    @Override
    public boolean matches(Method method, @Nullable Class<?> targetClass) {
        System.out.println("调用 matches(method,targetClass) 对"
                +targetClass.getName()+"."+method.getName()+"做动态检查");
        return "greetTo".equals(method.getName());
    }

    /**
     * 类型静态检查
     * @return
     */
    @Override
    public ClassFilter getClassFilter() {
        return  new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                System.out.println("调用 getClassFilter 对"+clazz.getName()+"做静态检查");
                return Waitor.class.isAssignableFrom(clazz);
            }
        };
    }
}
