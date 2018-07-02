package br.com.snmp.repository;

import br.com.snmp.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Long> {
  /**
   * Método para buscar setor por nome.
   * 
   * @param name do setor.
   * @return sector buscado.
   */
  public Sector findByName(String name);
}
