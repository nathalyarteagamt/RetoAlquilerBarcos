package com.Reto3.AlquilerBarcos.Crud;

import com.Reto3.AlquilerBarcos.modelo.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    @Query(value="Select count(idReservation) from reservation where status = ?", nativeQuery=true)
    public Integer countbystatus(String status); 
    
}
