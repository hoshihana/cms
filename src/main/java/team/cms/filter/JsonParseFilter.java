package team.cms.filter;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import team.cms.util.ParameterResetRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Component
@WebFilter(filterName = "JsonParseFilter", urlPatterns = "/api/**")
public class JsonParseFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(servletRequest.getInputStream()));
        String requestBody = IOUtils.read(reader);
        servletRequest = new ParameterResetRequestWrapper((HttpServletRequest) servletRequest, (Map<String, String[]>) JSON.parse(requestBody));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
