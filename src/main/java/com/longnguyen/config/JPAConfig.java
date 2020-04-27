package com.longnguyen.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.longnguyen.repository"}) // Khai báo để sử dung JPArepository
@EnableTransactionManagement // định nghĩa Entity transaction 
public class JPAConfig {

	// Tạo entity Manager factory
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource()); // Hàm getConnection() bên jdbc
		em.setPersistenceUnitName("persistence-data"); // Giao tiep giua Entity va table database
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties()); // thực thi câu lệnh cơ sở dữ liệu tạo table
		return em;
	}

	// Tính năng quản lý transaction entity
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	// đi cùng với transaction
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	// Nơi load database && để open connection
	private DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/SpringMVC");
		dataSource.setUsername("root");
		dataSource.setPassword("long250599");
		return dataSource;
	}
	
	// dùng để tạo table trong database
	 Properties additionalProperties(){
		 Properties properties = new Properties();
			//properties.setProperty("hibernate.hbm2ddl.auto", "update"); // dung updata table
		 	//properties.setProperty("hibernate.hbm2ddl.auto", "create"); // mới đầu tạo table thì dùng create
			properties.setProperty("hibernate.hbm2ddl.auto", "none"); // tạo table sau thì dùng none
			properties.setProperty("hibernate.enable_lazy_load_no_trans", "true"); // Bật tính năng lazy bên manytomany()
			return properties;
	 }
}
