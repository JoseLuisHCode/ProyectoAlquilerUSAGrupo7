package co.usaMintic.ProyectoCiclo3.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usaMintic.ProyectoCiclo3.Interface.ClientInterface;
import co.usaMintic.ProyectoCiclo3.Modelo.Client;

@Repository
public class ClientRepositorio {
    @Autowired
    private ClientInterface clientCrudRepository;
    
      public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
     
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
