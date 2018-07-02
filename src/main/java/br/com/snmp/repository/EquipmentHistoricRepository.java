package br.com.snmp.repository;

import br.com.snmp.model.EquipmentHistoric;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentHistoricRepository extends 
        JpaRepository<EquipmentHistoric,Long> {
  /**
   * Método para buscar um historico de equipamento pelo data.
   * 
   * @param date do historico do equipamento.
   * @return EquipmentCharacteristic buscado.
   */
  public EquipmentHistoric findByDate(Date date);
}
