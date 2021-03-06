package team.cms.interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import team.cms.result.JWTParseResult;
import team.cms.util.JsonWebTokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Configuration
public class VisitorInterceptor implements HandlerInterceptor {

    final static String jwtName = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String jwt = request.getHeader(jwtName);
        JWTParseResult jwtParseResult = JsonWebTokenUtil.parseJWT(jwt);
        if(jwtParseResult.isSuccess()) {
            request.setAttribute("accountId", jwtParseResult.getAccountId());
            request.setAttribute("username", jwtParseResult.getUsername());
            request.setAttribute("role", jwtParseResult.getRole());
            return true;
        } else {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(JSON.toJSONString(jwtParseResult));
            return false;
        }
    }
}
