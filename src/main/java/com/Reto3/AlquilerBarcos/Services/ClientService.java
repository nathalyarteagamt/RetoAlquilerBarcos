package com.Reto3.AlquilerBarcos.Services;

import com.Reto3.AlquilerBarcos.Repository.ClientRepository;
import com.Reto3.AlquilerBarcos.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client save (Client client){
        if(client.getIdClient() == null){
            return clientRepository.save(client);
        }else{
            Optional<Client> aux = clientRepository.getClient(client.getIdClient());
            if(aux.isPresent()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }
    
    public Client update (Client client){
        if(client.getIdClient() != null){
            Optional<Client> cl = clientRepository.getClient(client.getIdClient());
            if(cl.isPresent()){
                if(client.getEmail() != null){
                    cl.get().setEmail(client.getEmail());
                }
                if(client.getPassword() != null){
                    cl.get().setPassword(client.getPassword());
                }
                if(client.getName() != null){
                    cl.get().setName(client.getName());
                }
                if(client.getAge() != null){
                    cl.get().setAge(client.getAge());
                }
                if(client.getMessages() != null){
                    cl.get().setMessages(client.getMessages());
                }
                if(client.getReservations() != null){
                    cl.get().setReservations(client.getReservations());
                }
                clientRepository.save(cl.get());
                return cl.get();
            }else{
                return client;
            }
        }else{
            return client;
        }    
    }
    
    public boolean delete (int id){
        boolean flag = false;
        Optional <Client> cl = clientRepository.getClient(id);
        if(cl.isPresent()){
            clientRepository.delete(cl.get());
        }
        return flag;
    }
    
}
