package team.cms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import team.cms.interceptor.*;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new VisitorInterceptor())
                .addPathPatterns("/api/user/**")
                .addPathPatterns("/api/conference/**")
                .addPathPatterns("/api/admin/**")
                .addPathPatterns("/api/fleet/**")
                .addPathPatterns("/api/hotel/**")
                .addPathPatterns("/api/message/**")
                .addPathPatterns("/api/driver/**");

        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/api/user/**")
                .addPathPatterns("/api/conference/**")
                .addPathPatterns("/api/hotel/getAll")
                .addPathPatterns("/api/hotel/get")
                .addPathPatterns("/api/fleet/getAll")
                .addPathPatterns("/api/fleet/get")
                .addPathPatterns("/api/driver/getByFleetId")
                .addPathPatterns("/api/driver/getById");

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/api/admin/**")
                .excludePathPatterns("/api/admin/getAll");

        registry.addInterceptor(new HotelInterceptor())
                .addPathPatterns("/api/hotel/profile/**")
                .addPathPatterns("/api/hotel/password/**")
                .addPathPatterns("/api/hotel/reservation/**");

        registry.addInterceptor(new DriverInterceptor())
                .addPathPatterns("/api/driver/profile/**")
                .addPathPatterns("/api/driver/password/**")
                .addPathPatterns("/api/driver/reservation/**");
    }
}
