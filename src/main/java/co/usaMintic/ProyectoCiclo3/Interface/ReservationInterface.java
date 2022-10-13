package co.usaMintic.ProyectoCiclo3.Interface;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.usaMintic.ProyectoCiclo3.Modelo.Reservation;

public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
    
    
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dataOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);

    @Query("Select c.client, COUNT(c.client) FROM Reservation AS c Group BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

}
