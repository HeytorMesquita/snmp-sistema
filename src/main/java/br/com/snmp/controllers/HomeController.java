package br.com.snmp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  /**
   * Método que direciona para o index após o login.
   * 
   * @param model com os dados do obj. 
   * @return String com o nome da página a ser direcionada.
   */
  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("name", "Anônimo");
    return "login";
  }
}
