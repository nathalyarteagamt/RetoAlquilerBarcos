package com.Reto3.AlquilerBarcos.Services;

import com.Reto3.AlquilerBarcos.Conteos.ReportConteoClienteStatus;
import com.Reto3.AlquilerBarcos.Conteos.ReportConteoStatus;
import com.Reto3.AlquilerBarcos.Repository.ReservationRepository;
import com.Reto3.AlquilerBarcos.modelo.Reservation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save (Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> aux = reservationRepository.getReservation(reservation.getIdReservation());
            if(aux.isPresent()){
                return reservation;
            }else{
                return reservationRepository.save(reservation);
            }
        }
    }
    
    public Reservation update (Reservation reservation){
        if(reservation.getIdReservation() != null){
            Optional<Reservation> rs= reservationRepository.getReservation(reservation.getIdReservation());
            if(rs.isPresent()){
                if(reservation.getStartDate() != null){
                    rs.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate() != null){
                    rs.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus() != null){
                    rs.get().setStatus(reservation.getStatus());
                }
                if(reservation.getBoat() != null){
                    rs.get().setBoat(reservation.getBoat());
                }
                if(reservation.getClient() != null){
                    rs.get().setClient(reservation.getClient());
                }
                if(reservation.getScore() != null){
                    rs.get().setScore(reservation.getScore());
                }
                reservationRepository.save(rs.get());
                return rs.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional <Reservation> rs = reservationRepository.getReservation(id);
        if(rs.isPresent()){
            reservationRepository.delete(rs.get());
        }
        return flag;   
    }
    
    public ReportConteoStatus getReportStatus(){
        return reservationRepository.getReportStatus();
    }
    
    public List<Reservation> getReservationPeriod(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd"); // 2022-01-21
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (ParseException exception){
            exception.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a, b);
        }else{
            return new ArrayList<>();
        }
    }
     
    public List<ReportConteoClienteStatus> getTotalClients(){
        return reservationRepository.getTopClients();
    } 
    
}
