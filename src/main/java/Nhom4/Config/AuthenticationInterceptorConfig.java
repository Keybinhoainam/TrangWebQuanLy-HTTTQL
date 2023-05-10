package Nhom4.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import Nhom4.Interceptor.NhanVienAuthenticationInterceptor;
import Nhom4.Interceptor.QuanLyAuthenticationInterceptor;



@Configuration
public class AuthenticationInterceptorConfig implements WebMvcConfigurer{
	@Autowired
	QuanLyAuthenticationInterceptor quanLyAuthenticationInterceptor;
	@Autowired
	NhanVienAuthenticationInterceptor nhanVienAuthenticationInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(quanLyAuthenticationInterceptor)
			.addPathPatterns("/admin/**");
		registry.addInterceptor(nhanVienAuthenticationInterceptor).addPathPatterns("/report/**");
	}

}
