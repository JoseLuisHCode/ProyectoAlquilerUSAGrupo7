package co.usaMintic.ProyectoCiclo3.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usaMintic.ProyectoCiclo3.Interface.BoatInterface;
import co.usaMintic.ProyectoCiclo3.Modelo.Boat;

@Repository
public class BoatRepositorio {
    @Autowired
    private BoatInterface boatCrudRepository;
    
      public List<Boat> getAll(){
        return (List<Boat>) boatCrudRepository.findAll();
    }
    
    public Optional<Boat> getBoat(int id){
        return boatCrudRepository.findById(id);
    }

    public Boat save(Boat boat){
        return boatCrudRepository.save(boat);
    }
    
     public void delete(Boat boat){
        boatCrudRepository.delete(boat);
    }
}
