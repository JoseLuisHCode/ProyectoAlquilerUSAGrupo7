package co.usaMintic.ProyectoCiclo3.Interface;

import org.springframework.data.repository.CrudRepository;

import co.usaMintic.ProyectoCiclo3.Modelo.Reservation;

public interface ReservationInterface extends CrudRepository <Reservation, Integer> {
    
}
