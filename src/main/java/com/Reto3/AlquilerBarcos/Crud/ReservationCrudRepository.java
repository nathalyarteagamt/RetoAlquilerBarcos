package com.Reto3.AlquilerBarcos.Crud;


import com.Reto3.AlquilerBarcos.modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    @Query(value="Select count(idReservation) from reservation where status = ?", nativeQuery=true)
    public Integer countbystatus(String status); 
    
    public  List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);
    
    @Query("SELECT r.client, COUNT(r.client) FROM Reservation AS r GROUP BY r.client ORDER BY COUNT(r.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
}
