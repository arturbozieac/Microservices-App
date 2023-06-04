package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Configuration
public class JsonConfiguration {
  @Bean
  public Module hibernateModule() {
    return new Hibernate5Module();
  }
}