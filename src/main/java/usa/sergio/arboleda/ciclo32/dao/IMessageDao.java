package usa.sergio.arboleda.ciclo32.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo32.entity.Message;

public interface IMessageDao extends JpaRepository<Message, Integer>{

}
