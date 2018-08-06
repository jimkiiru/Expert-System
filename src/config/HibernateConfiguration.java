package config;
//http://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-with-named-queries/?utm_source=petri-kainulainen&utm_medium=email&utm_campaign=spring-data-jpa-tutorial
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
@Configuration
@EnableTransactionManagement
//@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {//  implements TransactionManagementConfigurer

	private Properties hibernateProperties() { 
		 Properties properties = new Properties(); 
		 properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		 properties.put("hibernate.generate_statistics",true);
		 //validate | update | create | create-drop 
		 /*
    		validate: validate the schema, makes no changes to the database.
    		update: update the schema/database with changes to your model
    		create: creates the schema, destroying previous data.
    		create-drop: drop the schema at the end of the session.
		  */
		 properties.put("hibernate.hbm2ddl.auto","update");
		 properties.put("hibernate.jdbc.batch_size",50);
		 properties.put("hibernate.show_sql",true);
		 properties.put("hibernate.format_sql",true);
		 properties.put("hibernate.id.new_generator_mappings",true);
		 properties.put("hibernate.cache.use_query_cache",false);
		 properties.put("hibernate.cache.use_second_level_cache",false);
		 //properties.put("org.hibernate.envers.audit_table_suffix","_AUDIT");
		 properties.put("hibernate.hibernate.cache.provider_class","org.hibernate.cache.EhCacheProvider");
		 return properties; 
	}
	
	 @Bean public LocalSessionFactoryBean sessionFactory() {
	  LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	  sessionFactory.setDataSource(dataSource());
	  sessionFactory.setPackagesToScan(new String[] { "com.expertsystem.model" });
	  sessionFactory.setHibernateProperties(hibernateProperties()); return
	  sessionFactory; 
	}
	@Autowired
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/cropdiagnosis");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100000000);
		multipartResolver.setMaxInMemorySize(1048576);
		return multipartResolver;
	}
	
	@Bean
	@Autowired public org.springframework.orm.hibernate5.HibernateTransactionManager transactionManager(SessionFactory s) { 
		org.springframework.orm.hibernate5.HibernateTransactionManager txManager = new org.springframework.orm.hibernate5.HibernateTransactionManager();
	 	txManager.setSessionFactory(s); 
	 	return txManager; 
	}
}


//http://websystique.com/springmvc/springmvc-hibernate-many-to-many-example-annotation-using-join-table/