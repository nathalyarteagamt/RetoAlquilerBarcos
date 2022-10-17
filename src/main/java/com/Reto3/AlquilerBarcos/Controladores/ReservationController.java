package com.Reto3.AlquilerBarcos.Controladores;

import com.Reto3.AlquilerBarcos.Conteos.ReportConteoClienteStatus;
import com.Reto3.AlquilerBarcos.Conteos.ReportConteoStatus;
import com.Reto3.AlquilerBarcos.Services.ReservationService;
import com.Reto3.AlquilerBarcos.modelo.Reservation;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update (@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable ("id") int id){
        return reservationService.delete(id);
    }
    
    @GetMapping("/report-status")
    public ReportConteoStatus getReportStatus() {
        return reservationService.getReportStatus();
    }   
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2) {
        return reservationService.getReservationPeriod(d1, d2);
    }
    

    @GetMapping("/report-clients")
    public List<ReportConteoClienteStatus> getCountClient() {
        return reservationService.getTotalClients();
    }
              
   
    
}
