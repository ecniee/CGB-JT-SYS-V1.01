package com.jt.config;
import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
@PropertySource("classpath:configs.properties")
public class AppRootConfig {
	public AppRootConfig() {
		System.out.println("AppRootConfig");
	}
	/**配置DRUID*/
	@Bean(value="dataSource",initMethod="init",destroyMethod="close")
	public DruidDataSource newDataSource(
			@Value("${jdbcDriver}")String driverClass,
			@Value("${jdbcUrl}")String jdbcUrl,
			@Value("${jdbcUser}")String username,
			@Value("${jdbcPassword}")String password){
		DruidDataSource ds=
		new DruidDataSource();
		ds.setDriverClassName(driverClass);
		ds.setUrl(jdbcUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}
	/**配置SqlSessionFactoryBean
	 * @throws IOException */
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean 
	    newSqlSessionFactoryBean(
	    @Autowired DataSource dataSource) throws IOException{
		SqlSessionFactoryBean bean=
	    new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		Resource[] mapperLocations=
		new PathMatchingResourcePatternResolver()
		.getResources("classpath:mapper/sys/*.xml");
		bean.setMapperLocations(mapperLocations);
		return bean;
	}
	/**配置MapperScanner*/
	@Bean
	public MapperScannerConfigurer 
	    newMapperScannerConfigurer(){
		MapperScannerConfigurer msc=
		new MapperScannerConfigurer();
		msc.setBasePackage("com.jt.**.dao");
		return msc;
	}
	
	
}






