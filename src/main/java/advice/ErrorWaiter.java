package advice;

/** 模拟异常的目标类 */
public class ErrorWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        throw new RuntimeException(" ex when greeting to: " + name);
    }

    @Override
    public void serveTo(String name) {
        throw new RuntimeException(" ex when serve to: " + name);
    }
}
