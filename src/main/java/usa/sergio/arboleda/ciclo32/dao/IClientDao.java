package usa.sergio.arboleda.ciclo32.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo32.entity.Client;

public interface IClientDao extends JpaRepository<Client, Integer>{

}
