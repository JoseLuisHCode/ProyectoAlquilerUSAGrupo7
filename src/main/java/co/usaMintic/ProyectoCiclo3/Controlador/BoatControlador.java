package co.usaMintic.ProyectoCiclo3.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usaMintic.ProyectoCiclo3.Modelo.Boat;
import co.usaMintic.ProyectoCiclo3.Servicio.BoatServicio;

@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*")
public class BoatControlador {

    @Autowired
    private BoatServicio boatService;
    
    @GetMapping("/all")
    public List<Boat> getBoats(){
        return boatService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int boatId) {
        return boatService.getBoat(boatId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat) {
        return boatService.save(boat);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update(@RequestBody Boat boat) {
        return boatService.update(boat);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return boatService.deleteBoat(id);
    }
}
