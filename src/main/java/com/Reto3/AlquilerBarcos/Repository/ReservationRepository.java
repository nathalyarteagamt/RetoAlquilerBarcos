package com.Reto3.AlquilerBarcos.Repository;

import com.Reto3.AlquilerBarcos.Conteos.ReportConteoClienteStatus;
import com.Reto3.AlquilerBarcos.Conteos.ReportConteoStatus;
import com.Reto3.AlquilerBarcos.Crud.ReservationCrudRepository;
import com.Reto3.AlquilerBarcos.modelo.Client;
import com.Reto3.AlquilerBarcos.modelo.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save (Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete (Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    public ReportConteoStatus getReportStatus(){
        ReportConteoStatus reportConteoStatus = new ReportConteoStatus();
        reportConteoStatus.setCancelled(reservationCrudRepository.countbystatus("cancelled"));
        reportConteoStatus.setCompleted(reservationCrudRepository.countbystatus("completed"));
        return reportConteoStatus;
    }
     
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }
       
    public List<ReportConteoClienteStatus> getTopClients() {
        List<ReportConteoClienteStatus> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i = 0; i <  report.size(); i++) {
            Client cli = (Client) report.get(i)[0];
            Integer cantidad = Integer.parseInt(report.get(i)[1].toString());
            ReportConteoClienteStatus cc = new ReportConteoClienteStatus(cantidad, cli);
            res.add(cc);
        }
        return res;
    }

    
}
