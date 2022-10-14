package com.Reto3.AlquilerBarcos.Repository;

import com.Reto3.AlquilerBarcos.Crud.AdminCrudRepository;
import com.Reto3.AlquilerBarcos.modelo.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    public Admin save (Admin admin){
        return adminCrudRepository.save(admin);
    }
    
    public void delete (Admin admin){
        adminCrudRepository.delete(admin);
    }

    public Optional<Admin> getCategory(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Optional<Admin> getAdmin(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Optional<Admin> getAdmin(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
