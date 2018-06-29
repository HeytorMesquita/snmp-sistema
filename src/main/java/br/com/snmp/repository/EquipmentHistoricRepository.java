package br.com.snmp.repository;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.snmp.model.EquipmentHistoric;

@Repository
public interface EquipmentHistoricRepository extends JpaRepository<EquipmentHistoric,Long>{

	public EquipmentHistoric findByDate(Date date);
}
