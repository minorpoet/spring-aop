package jwt;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.util.StringUtils;

import java.io.IOException;

/** 模拟浏览器发送请求， 将 jwt 塞到 header 中 */
public class JwtClient {

  public Response call(Request request) throws IOException {
    OkHttpClient client = new OkHttpClient();
    Request.Builder requestBuilder = request.newBuilder()
            // 附带通用服务 jwt
            .addHeader("commonJwt", "local-jwt");

    // 附带用户验证 jwt
    String userJwt = "server-jwt";
    if (!StringUtils.isEmpty(userJwt)) {
      requestBuilder.addHeader("userJwt", userJwt);
    }
    request = requestBuilder.build();

    return client.newCall(request).execute();
  }
}
