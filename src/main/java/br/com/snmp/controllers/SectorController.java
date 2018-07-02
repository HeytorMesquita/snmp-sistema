package br.com.snmp.controllers;

import br.com.snmp.helpers.ExistentObjectException;
import br.com.snmp.model.Sector;
import br.com.snmp.service.ManagementSectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sectors")
public class SectorController {

  @Autowired
  private ManagementSectorService managementSector;

  /**
  * Método que retorna um usuário com um dado id.
  * 
  * @param id do setor a ser buscado.
  * @return String com o caminho da página de listagem de setores.
  */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public String getSector(@PathVariable Long id) {
    return "sectors/view";
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String listSector(Model model) {
    model.addAttribute("sectors", managementSector.listSector());
    return "sectors/list";
  }

  @RequestMapping(value = "/form", method = RequestMethod.GET)
  public String sectorForm(Model model) {
    model.addAttribute("sectors", new Sector());
    return "sectors/newSetor";
  }

  /**
  * Método para cadastrar um novo setor.
  * 
  * @param sector com os dados do obj.
  * @return String com o caminho da página de listagem do setor.
  */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String newSector(@ModelAttribute Sector sector) {
    try {
      managementSector.insertSector(sector);
    } catch (ExistentObjectException e) {
      e.printStackTrace();
    }
    return "sectors/list";
  }

  public ManagementSectorService getManagementSector() {
    return managementSector;
  }

  public void setManagementSector(ManagementSectorService managementSector) {
    this.managementSector = managementSector;
  }

}