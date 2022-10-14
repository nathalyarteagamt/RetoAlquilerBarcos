package com.Reto3.AlquilerBarcos.Services;

import com.Reto3.AlquilerBarcos.Repository.BoatRepository;
import com.Reto3.AlquilerBarcos.modelo.Boat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoatService {
    
    @Autowired
    private BoatRepository boatRepository;
    
    public List <Boat> getAll(){
        return boatRepository.getAll();
    }
    
    public Optional <Boat> getBoat(int id){
        return boatRepository.getBoat(id);
    }
    
    public Boat save (Boat boat){
        if(boat.getId() == null){
            return boatRepository.save(boat);
        }else{
            Optional <Boat> aux = boatRepository.getBoat(boat.getId());
            if(aux.isPresent()){
                return boat;
            }else{
                return boatRepository.save(boat);
            }
        }
    }
    
    public Boat update (Boat boat){
        if(boat.getId() != null){
            Optional <Boat> bo = boatRepository.getBoat(boat.getId());
            if (bo.isPresent()){
                if(boat.getName() != null){
                    bo.get().setName(boat.getName());
                }
                if(boat.getBrand() != null){
                    bo.get().setBrand(boat.getBrand());
                }
                if(boat.getYear() != null){
                    bo.get().setYear(boat.getYear());
                }
                if(boat.getDescription() != null){
                    bo.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory() != null){
                    bo.get().setCategory(boat.getCategory());
                }
                if(boat.getMessage() != null){
                    bo.get().setMessage(boat.getMessage());
                }
                if(boat.getReservations() != null){
                    bo.get().setReservations(boat.getReservations());
                }
                boatRepository.save(bo.get());
                return bo.get();
            }else{
                return boat;
            }
        }else{
            return boat;
        }
    }
    
    public boolean delete (int id){
        boolean flag = false;
        Optional <Boat> bo = boatRepository.getBoat(id);
        if(bo.isPresent()){
            boatRepository.delete(bo.get());
        }
        return flag;
    }
    
}
