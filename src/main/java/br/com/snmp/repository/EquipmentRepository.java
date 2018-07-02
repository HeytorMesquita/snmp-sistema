package br.com.snmp.repository;

import br.com.snmp.model.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
  /**
   * Método para buscar um equipamento pelo número de série.
   * 
   * @param serialNumber do equipamento.
   * @return Equipment buscado.
   */
  public Equipment findBySerialNumber(String serialNumber);

  /**
   * Método para buscar equipamento pelo número de tombo.
   * 
   * @param tumberNumber do equipamento.
   * @return Equipment buscado.
   */  
  public Equipment findByTumberNumber(String tumberNumber);

}