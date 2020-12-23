package team.cms.interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import team.cms.entity.enums.Role;
import team.cms.result.AccessResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Configuration
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Role role = (Role)request.getAttribute("role");
        if (role == Role.USER) {
            return true;
        } else {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(JSON.toJSONString(new AccessResult(false, "无权限访问", Role.USER, role)));
            return false;
        }
    }
}
