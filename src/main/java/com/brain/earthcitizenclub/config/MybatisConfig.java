package com.brain.earthcitizenclub.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
//@MapperScan({ "com.brain.earthcitizenclub.mapper", "com.brain.jjan.mapper" })
public class MybatisConfig {

	@Bean
	public SimpleDriverDataSource datasource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(net.sourceforge.jtds.jdbc.Driver.class);
		dataSource.setUsername("sa");
		dataSource.setPassword("webdev");
		dataSource.setUrl("jdbc:jtds:sqlserver://121.134.35.189:1433;DatabaseName=Earthcitizenclub");
		return dataSource;
	}

	@Bean
	public SimpleDriverDataSource jjanDatasource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(net.sourceforge.jtds.jdbc.Driver.class);
		dataSource.setUsername("jjanuser");
		dataSource.setPassword("1111");
		dataSource.setUrl("jdbc:jtds:sqlserver://192.168.3.26:1434;useLOBs=false;DatabaseName=JJan20");
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(this.datasource());
	}

	@Bean
	public DataSourceTransactionManager jjanTransactionManager() {
		return new DataSourceTransactionManager(this.jjanDatasource());
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(this.datasource());
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/sql/*_sql.xml"));
		sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mapper/config/mybatis_config.xml"));
		return sessionFactory;
	}

	@Bean
	public SqlSessionFactoryBean jjanSqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(this.jjanDatasource());
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/jjanSql/*_sql.xml"));
		sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mapper/config/mybatis_config.xml"));
		return sessionFactory;
	}
	

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.brain.earthcitizenclub.mapper");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
		return mapperScannerConfigurer;
	}
	
	@Bean
	public MapperScannerConfigurer jjanMapperScannerConfigurer(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.brain.jjan.mapper");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("jjanSqlSessionFactoryBean");
		return mapperScannerConfigurer;
	}


}
