package br.com.snmp.controllers;

import br.com.snmp.helpers.ExistentObjectException;
import br.com.snmp.model.User;
import br.com.snmp.service.ManagementUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Classe para gerenciar as páginas referentes ao usuário. 
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private ManagementUserService managementUser;

  /**
  * Método que retorna um usuário com um dado id.
  * 
  * @param id do usuário a ser buscado.
  * @return String com o caminho da página de listagem do usuário.
  */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String getUser(@PathVariable Long id) {
    return "users/view";
  }

  /**
  * Método que lista todos os usuários.
  * 
  * @param model com os dados do objeto User.
  * @return String com o caminho da página de listagem ds todos os usuários.
  */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public String listUser(Model model) {
    model.addAttribute("users", managementUser.listUser());
    return "users/list";
  }

  /**
   * Método para direcionar para página de cadastro de usuários.
   * 
   * @param model com os dados do objeto user.
   * @return String, com o caminho com o formulário para cadastrar um novo usuário.
   */
  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String userForm(Model model) {
    model.addAttribute("users", new User());
    return "users/newUser";
  }

  /**
   * Creates a user.
   * @param user objeto com os dados do usuário.
   * @return String, com o caminho para listar um novo usuário.
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String newUser(@ModelAttribute User user) {
    try {
      managementUser.insertUser(user);
    } catch (ExistentObjectException e) {
      e.printStackTrace();
    }
    return "users/list";
  }

  public ManagementUserService getManagementUser() {
    return managementUser;
  }

  public void setManagementUser(ManagementUserService managementUser) {
    this.managementUser = managementUser;
  }

}
