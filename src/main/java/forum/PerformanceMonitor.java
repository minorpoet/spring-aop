package forum;

/** 性能监控器 */
public class PerformanceMonitor {
  private static final ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<>();

  public static void begin(String method) {
    System.out.println("begin monitor...");
    MethodPerformance mp = new MethodPerformance(method);
    performanceRecord.set(mp);
  }

  public static void end() {
    System.out.println("end monitor...");
    MethodPerformance mp = performanceRecord.get();

    mp.printPerformance();
  }
}
