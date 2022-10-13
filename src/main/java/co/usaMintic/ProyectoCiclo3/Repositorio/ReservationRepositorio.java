package co.usaMintic.ProyectoCiclo3.Repositorio;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usaMintic.ProyectoCiclo3.Interface.ReservationInterface;
import co.usaMintic.ProyectoCiclo3.Modelo.Client;
import co.usaMintic.ProyectoCiclo3.Modelo.CountClient;
import co.usaMintic.ProyectoCiclo3.Modelo.Reservation;

@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationInterface reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    //Reto5

    public List<Reservation> getReservationInPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.countTotalReservationsByClient();

        for (int i=0; i<reporte.size(); i++){
            respuesta.add(new CountClient( (Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }
}
