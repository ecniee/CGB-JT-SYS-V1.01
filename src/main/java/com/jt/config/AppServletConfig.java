package com.jt.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration //描述此类是一个配置类
@ComponentScan("com.jt")//配置对指定包下类的扫描
@EnableWebMvc  //启用mvc默认配置
public class AppServletConfig 
       extends WebMvcConfigurerAdapter{
	public AppServletConfig() {
		System.out.println("AppServletConfig");
	}
    /**配置视图解析*/  
	@Override
	public void configureViewResolvers(
		ViewResolverRegistry registry) {
	  registry.jsp("/WEB-INF/pages/",".html");
	}
}



