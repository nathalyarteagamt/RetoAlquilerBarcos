package com.Reto3.AlquilerBarcos.Controladores;

import com.Reto3.AlquilerBarcos.Services.BoatService;
import com.Reto3.AlquilerBarcos.modelo.Boat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoatController {
    
    @Autowired
    private BoatService boatService;
    
    @GetMapping("/all")
    public List<Boat> getBoats(){
        return boatService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int id){
        return boatService.getBoat(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save (@RequestBody Boat boat){
        return boatService.save(boat);
    }
    
    @PutMapping("/update")
    public Boat update (@RequestBody Boat boat){
        return boatService.update(boat);
    }
    
    @DeleteMapping
    public boolean delete(@PathVariable ("id") int id){
        return boatService.delete(id);
    }
    
}
