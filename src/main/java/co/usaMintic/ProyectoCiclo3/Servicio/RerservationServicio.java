package co.usaMintic.ProyectoCiclo3.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaMintic.ProyectoCiclo3.Modelo.Reservation;
import co.usaMintic.ProyectoCiclo3.Repositorio.ReservationRepositorio;

@Service
public class RerservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> aux= reservationRepository.getReservation(reservation.getIdReservation());
            if(aux.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
        public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> aux= reservationRepository.getReservation(reservation.getIdReservation());
            if(!aux.isEmpty()){

                if(reservation.getStartDate()!=null){
                    aux.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    aux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                   aux.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(aux.get());
                return aux.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    
      public boolean deleteReservation (int id){
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
