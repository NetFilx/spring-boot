package cn.limbo.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by limbo on 2017/4/10.
 */

@Configuration
@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {

	static final String PACKAGE = "cn.limbo.dao.cluster";
	static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";

	@Value("${cluster.datasource.url}")
	private String url;

	@Value("${cluster.datasource.username}")
	private String user;

	@Value("${cluster.datasource.password}")
	private String password;

	@Value("${cluster.datasource.driverClassName}")
	private String driverClass;

	@Bean(name = "clusterDataSource")
	public DataSource clusterDataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean(name="clusterTransactionManager")
	public DataSourceTransactionManager clusterTransactionManager(){
		return new DataSourceTransactionManager(clusterDataSource());
	}

	@Bean(name = "clusterSqlSessionFactory")
	public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
		throws Exception{
		final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(clusterDataSource);
		sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
		.getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
		return sessionFactoryBean.getObject();
	}

}
