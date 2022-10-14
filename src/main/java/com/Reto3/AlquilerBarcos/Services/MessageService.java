package com.Reto3.AlquilerBarcos.Services;

import com.Reto3.AlquilerBarcos.Repository.MessageRepository;
import com.Reto3.AlquilerBarcos.modelo.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save (Message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        } else {
            Optional<Message> aux =messageRepository.getMessage(message.getIdMessage());
            if(aux.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
    
    public Message update (Message message){
        if(message.getIdMessage() != null){
            Optional<Message> ms = messageRepository.getMessage(message.getIdMessage());
            if(ms.isPresent()){
                if(message.getMessageText() != null){
                    ms.get().setMessageText(message.getMessageText());
                }
                if(message.getBoat() != null){
                    ms.get().setBoat(message.getBoat());
                }
                if(message.getClient() != null){
                    ms.get().setClient(message.getClient());
                }
                messageRepository.save(ms.get());
                return ms.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional <Message> ms = messageRepository.getMessage(id);
        if(ms.isPresent()){
            messageRepository.delete(ms.get());
        }
        return flag;   
    }
    
}
