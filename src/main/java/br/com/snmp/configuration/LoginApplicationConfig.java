package br.com.snmp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"br.com.snmp.controllers"})
@Import(value = {LoginSecurityConfig.class})
public class LoginApplicationConfig {

  /**
  * Método usado para visualizar resolvedor de prefixo e sufixo.
  * 
  * @return viewResolver 
  **/
  @Bean
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/templates/");
    viewResolver.setSuffix(".html");
    return viewResolver;
  }
}
