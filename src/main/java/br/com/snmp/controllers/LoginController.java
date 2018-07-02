package br.com.snmp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Classe para gerenciar as páginas de Login. 
 */
@Controller
public class LoginController {

  /**
   * Método para direcionar para a página do admin.
   * 
   * @return model com o nome da página a ser derecinada.
   */
  @RequestMapping(value = {"/welcomePageAdmin"}, method = RequestMethod.GET)
  public ModelAndView welcomePageAdmin() {
    ModelAndView model = new ModelAndView();
    model.setViewName("welcomePageAdmin");
    return model;
  }
  
  /**
   * Método para direcionar para a página do usuário.
   * 
   * @return model com o nome da página a ser derecinada.
   */
  @RequestMapping(value = {"/welcomePageUser"}, method = RequestMethod.GET)
  public ModelAndView welcomePageUser() {
    ModelAndView model = new ModelAndView();
    model.setViewName("welcomePageUser");
    return model;
  }

  /**
   * Método para direcionar para a página do admin.
   * 
   * @return model com o nome da página a ser direcinada.
   */
  @RequestMapping(value = {"/admin/homePageAdmin"}, method = RequestMethod.GET)
  public ModelAndView homePageAdmin() {
    ModelAndView model = new ModelAndView();
    model.setViewName("homePageAdmin");
    return model;
  }

  /**
   * Método para direcionar para a página do usuário.
   * 
   * @return model com o nome da página a ser derecinada.
   */
  @RequestMapping(value = {"/users/homePageUser"}, method = RequestMethod.GET)
  public ModelAndView homePageUser() {
    ModelAndView model = new ModelAndView();
    model.setViewName("homePageUser");
    return model;
  }

  /**
   * Método para direcionar para a página do usuário.
   * 
   * @param error string.
   * @param logout string.
   * @return model com o nome da página a ser derecionada.
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
      @RequestParam(value = "logout", required = false) String logout) {

    ModelAndView model = new ModelAndView();
    if (error != null) {
      model.addObject("error", "forneceu credenciais inválidas.");
    }

    if (logout != null) {
      model.addObject("message", "Desconectado com sucesso.");
    }
    model.setViewName("login");
    return model;
  }
}
