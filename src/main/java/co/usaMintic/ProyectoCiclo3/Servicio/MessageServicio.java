package co.usaMintic.ProyectoCiclo3.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usaMintic.ProyectoCiclo3.Modelo.Message;
import co.usaMintic.ProyectoCiclo3.Repositorio.MessageRepositorio;

@Service
public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> aux= messageRepository.getMessage(message.getIdMessage());
            if(aux.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }
     public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> aux= messageRepository.getMessage(message.getIdMessage());
            if(!aux.isEmpty()){
                if(message.getMessageText()!=null){
                    aux.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(aux.get());
                return aux.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    public boolean deleteMessage (int id){
        Boolean d = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}
