package br.imd.pds.tests;

import static org.junit.Assert.assertEquals;

import br.com.snmp.model.Equipment;
import br.com.snmp.repository.EquipmentRepository;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;

/**
 * Classe responsável por realizar teste do Equipamento.
 */
public class EquipmentRepositoryTest {

  EquipmentRepository repository;

  @Test
  public void testRepository() {

    repository.save(new Equipment("BRT852RFTQ", "2012005412", 
        Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
    repository.save(new Equipment("BRT852RFTF", "2012005415", 
        Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));
    repository.save(new Equipment("BRT852RFTB", "2012005413", 
        Calendar.getInstance().getTime(), Calendar.getInstance().getTime()));

    final List<Equipment> equipments = repository.findAll();
    System.out.println(equipments);
    assertEquals(3, equipments.size());
  }
}
