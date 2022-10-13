package co.usaMintic.ProyectoCiclo3.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usaMintic.ProyectoCiclo3.Modelo.CountClient;
import co.usaMintic.ProyectoCiclo3.Modelo.CountStatus;
import co.usaMintic.ProyectoCiclo3.Modelo.Reservation;
import co.usaMintic.ProyectoCiclo3.Servicio.RerservationServicio;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationControlador {
    @Autowired
    private RerservationServicio reservationService;
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return reservationService.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReservationsInPeriodReport(@PathVariable("fecha1") String fecha1,@PathVariable("fecha2") String fecha2){
        return reservationService.getReservationsInPeriod(fecha1, fecha2);
    }

    @GetMapping("/report-status")
    public CountStatus getReservationSatatusReport(){
        return reservationService.getReservationStatusReport();

    }
    @GetMapping("/report-clients")
    public List<CountClient> getTopClientsReport(){
        return reservationService.getTopClientsReport();
    }

}
