package br.com.snmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.snmp.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
	
	public Equipment findBySerialNumber(String serialNumber);
	
	public Equipment findByTumberNumber(String tumberNumber);

}