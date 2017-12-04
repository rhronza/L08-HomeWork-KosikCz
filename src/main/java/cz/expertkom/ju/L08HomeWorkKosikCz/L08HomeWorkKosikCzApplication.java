package cz.expertkom.ju.L08HomeWorkKosikCz;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cz.expertkom.ju.L08HomeWorkKosikCz.Api.ApplicationApi;
import cz.expertkom.ju.L08HomeWorkKosikCz.Api.Impl.ApplicationApiImpl;

@SpringBootApplication
@ComponentScan(basePackages = "cz.expertkom.ju") 
@EnableJpaRepositories(basePackages = "cz.expertkom.ju")
@EnableTransactionManagement
@EntityScan(basePackages = "cz.expertkom.ju")
public class L08HomeWorkKosikCzApplication {

	@Autowired
	Bus bus;
	
	public static void main(String[] args) {
		SpringApplication.run(L08HomeWorkKosikCzApplication.class, args);
	}
	
	
	@Bean
	public ApplicationApi appApi() {
		return new ApplicationApiImpl();
	}
	
	@Bean
	public JSONProvider<?> jsonProvider() {
		JSONProvider<?> jsonProvider = new JSONProvider<>();
		jsonProvider.setDropRootElement(true);
		jsonProvider.setSupportUnwrapped(true);
	return jsonProvider;
	}
	@Bean
	public Server rsServer() {
		final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		//endpoint.setProvider(jsonProvider());
		endpoint.setBus(bus);
		endpoint.setAddress("/HomeWork/L08");
		endpoint.setServiceBeans(Arrays.<Object>asList(appApi()));
	return endpoint.create();
	}

}
	
