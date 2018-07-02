package br.imd.pds.tests;

import br.com.snmp.model.Sector;
import br.com.snmp.repository.SectorRepository;
import org.junit.Test;

/**
 * Classe responsável por realizar teste do Setor.
 */
public class SectorRepositoryTest {

  SectorRepository repository;

  @Test
  public void testRepository() {

    Sector s1 = new Sector(23, "suporte");
    Sector s2 = new Sector(55, "financeiro");
    Sector s3 = new Sector(10, "administrativo");

    repository.save(s1);
    repository.save(s2);
    repository.save(s3);
  }
}

