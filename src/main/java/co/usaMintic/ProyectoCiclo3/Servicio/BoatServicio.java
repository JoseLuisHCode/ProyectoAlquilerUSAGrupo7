package co.usaMintic.ProyectoCiclo3.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaMintic.ProyectoCiclo3.Modelo.Boat;
import co.usaMintic.ProyectoCiclo3.Repositorio.BoatRepositorio;

@Service
public class BoatServicio {
    
    @Autowired
    private BoatRepositorio boatRepository;

    public List<Boat> getAll(){
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int boatId) {
        return boatRepository.getBoat(boatId);
    }

    public Boat save(Boat boat){
        if(boat.getId()==null){
            return boatRepository.save(boat);
        }else{
            Optional<Boat> aux = boatRepository.getBoat(boat.getId());
            if(aux.isEmpty()){
                return boatRepository.save(boat);
            }else{
                return boat;
            }
        }
    }
    
       public Boat update(Boat boat){
        if(boat.getId()!=null){
            Optional<Boat> aux= boatRepository.getBoat(boat.getId());
            if(!aux.isEmpty()){
                if(boat.getName()!=null){
                    aux.get().setName(boat.getName());
                }
                if(boat.getBrand()!=null){
                    aux.get().setBrand(boat.getBrand());
                }
                if(boat.getYear()!=null){
                    aux.get().setYear(boat.getYear());
                }
                if(boat.getDescription()!=null){
                    aux.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory()!=null){
                    aux.get().setCategory(boat.getCategory());
                }
                boatRepository.save(aux.get());
                return aux.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }

    
    
      public boolean deleteBoat (int id){
        Boolean aux1 = getBoat(id).map(boat -> {
            boatRepository.delete(boat);
            return true;
        }).orElse(false);
        return aux1;
    }
}
