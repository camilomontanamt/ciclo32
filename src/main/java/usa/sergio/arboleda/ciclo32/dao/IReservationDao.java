package usa.sergio.arboleda.ciclo32.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo32.entity.Reservation;

public interface IReservationDao extends JpaRepository<Reservation, Integer>{

}
