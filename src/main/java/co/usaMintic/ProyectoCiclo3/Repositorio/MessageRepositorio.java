package co.usaMintic.ProyectoCiclo3.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usaMintic.ProyectoCiclo3.Interface.MessageInterface;
import co.usaMintic.ProyectoCiclo3.Modelo.Message;

@Repository
public class MessageRepositorio {
    @Autowired
    private MessageInterface messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message save(Message message) {
        return messageCrudRepository.save(message);
    }
     
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
}
