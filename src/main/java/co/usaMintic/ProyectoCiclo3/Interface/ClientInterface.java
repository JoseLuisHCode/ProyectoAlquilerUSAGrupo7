package co.usaMintic.ProyectoCiclo3.Interface;

import org.springframework.data.repository.CrudRepository;

import co.usaMintic.ProyectoCiclo3.Modelo.Client;

public interface ClientInterface extends CrudRepository <Client, Integer> {
    
}
