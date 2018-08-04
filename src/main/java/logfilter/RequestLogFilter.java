package logfilter;

import org.springframework.lang.Nullable;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class RequestLogFilter extends AbstractRequestLoggingFilter {
  @Override
  protected void beforeRequest(HttpServletRequest request, String message) {
    System.out.println(message);
  }

  @Override
  protected void afterRequest(HttpServletRequest request, String message) {
    System.out.println(message);
  }

  @Nullable
  @Override
  protected String getMessagePayload(HttpServletRequest request) {
    return super.getMessagePayload(request);
  }
}
