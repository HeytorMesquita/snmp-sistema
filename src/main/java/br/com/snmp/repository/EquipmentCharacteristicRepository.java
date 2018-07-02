package br.com.snmp.repository;

import br.com.snmp.model.EquipmentCharacteristic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentCharacteristicRepository extends 
    JpaRepository<EquipmentCharacteristic,Long> {
  /**
   * Método para buscar uma caracteristica de equipamento pelo nome.
   * 
   * @param name da caracteristica do equipamento.
   * @return EquipmentCharacteristic buscado.
   */ 
  public EquipmentCharacteristic findByName(String name);
}
