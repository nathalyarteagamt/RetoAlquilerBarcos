package com.Reto3.AlquilerBarcos.Crud;

import com.Reto3.AlquilerBarcos.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}
