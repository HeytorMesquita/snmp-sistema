package br.com.snmp.controllers;

import br.com.snmp.helpers.ExistentObjectException;
import br.com.snmp.model.Equipment;
import br.com.snmp.service.ManagementEquipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Classe responsável por gerenciar o controle das páginas referentes a equipamento.
 * 
 */
@Controller
@RequestMapping(value = "equipments")
public class EquipmentController {


  @Autowired
  private ManagementEquipmentService managementEquipment;

  /**
   * Método que retorna um equipamento com um dado número de série.
   * 
   * @param serial que é uma string com  o número de sério do equipamento.
   * @return
   */
  @RequestMapping(value = "/{serial_number}", method = RequestMethod.GET)
  public String getEquipement(@PathVariable String serial) {
    return "equipments/view";
  }

  /**
   * Método que retorna a lista de todos os equipamentos.
   * 
   * @return String com o caminho para a lista de equipamentos.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public String listEquipment(Model model) {
    model.addAttribute("equipments", managementEquipment.listEquipment());
    return "equipments/list";
  }

  /**
   * Método para retornar a página com o formulário para novo.
   * 
   * @param model com os atributos do obj equipment.
   * @return String com o caminho da página.
   */
  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String equipmentForm(Model model) {
    model.addAttribute("equipments", new Equipment());
    return "equipments/newEquipment";
  }

  /**
   * Método para criar equipamentos.
   * 
   * @param equipment a ser criado.
   * @return
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String newEquipment(@ModelAttribute Equipment equipment) {
    try {
      managementEquipment.insertEquipment(equipment, true);
    } catch (ExistentObjectException e) {
      e.printStackTrace();
    }
    return "equipments/list";
  }

}
