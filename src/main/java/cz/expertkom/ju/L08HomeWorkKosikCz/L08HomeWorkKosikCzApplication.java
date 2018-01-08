package cz.expertkom.ju.L08HomeWorkKosikCz;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

//import com.fasterxml.jackson.;

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
		//System.out.println("\nStart aplikace\n");
		SpringApplication.run(L08HomeWorkKosikCzApplication.class, args);
		//System.out.println("\nUkončení startu aplikace");
	}
	
	
	@Bean
	public ApplicationApi appApi() {
		return new ApplicationApiImpl();
	}
	
	/*
	@Bean
	public JSONProvider<?> jsonProvider() {
		JSONProvider<?> jsonProvider = new JSONProvider<>();
		jsonProvider.setDropRootElement(true);
		jsonProvider.setSupportUnwrapped(true);
	return jsonProvider;
	}
	*/
	
	@Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        return mapper;
    }

	@Bean
	public JacksonJaxbJsonProvider jsonProvider() {
		final JacksonJaxbJsonProvider jsonProvider = new JacksonJaxbJsonProvider();
		jsonProvider.setMapper(objectMapper());
		return jsonProvider;
	}

	
	@Bean
	public Server rsServer() {
		final JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setProvider(jsonProvider());
		endpoint.setBus(bus);
		endpoint.setAddress("/HomeWork/L08");
		endpoint.setServiceBeans(Arrays.<Object>asList(appApi()));
	return endpoint.create();
	}

}
	
