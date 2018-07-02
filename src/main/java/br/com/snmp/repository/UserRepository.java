package br.com.snmp.repository;

import br.com.snmp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
  /**
   * Método para buscar um usuário pelo CPF.
   * 
   * @param cpf do usuário.
   * @return um objeto User.
   */
  public User findByCpf(String cpf);
  
  /**
   * Método para buscar um usuário pelo username.
   * 
   * @param username do usuário.
   * @return um objeto User.
   */
  @Query("select u from User u left join fetch u.roles where lower(u.username) = lower(:username) ")
  public User findByUsername(@Param("username") String username);
}
