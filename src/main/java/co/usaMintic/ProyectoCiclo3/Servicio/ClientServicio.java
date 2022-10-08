package co.usaMintic.ProyectoCiclo3.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaMintic.ProyectoCiclo3.Modelo.Client;
import co.usaMintic.ProyectoCiclo3.Repositorio.ClientRepositorio;

@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> aux= clientRepository.getClient(client.getIdClient());
            if(aux.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    } 
     public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> aux= clientRepository.getClient(client.getIdClient());
            if(!aux.isEmpty()){
                if(client.getName()!=null){
                    aux.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    aux.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    aux.get().setPassword(client.getPassword());
                }
                clientRepository.save(aux.get());
                return aux.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    
     public boolean deleteClient (int id){
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}
