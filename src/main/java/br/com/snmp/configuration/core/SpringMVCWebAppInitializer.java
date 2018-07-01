package br.com.snmp.configuration.core;

import br.com.snmp.configuration.LoginApplicationConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * .
 */
public class SpringMVCWebAppInitializer extends 
    AbstractAnnotationConfigDispatcherServletInitializer {
  /**
   * Método para mapear servlet.
   * 
   * @return Class[] com o .class da configuração do login.
   */
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {LoginApplicationConfig.class};
  }

  /**
   * Método para configurar servlet.
   * 
   * @return null.
   */  
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return null;
  }
  
  /**
   * Método para mapear servlet.
   * 
   * @return String[] com o caminho do mapeamento.
   */  
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }
}
