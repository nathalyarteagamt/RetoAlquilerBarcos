package com.Reto3.AlquilerBarcos.Services;

import com.Reto3.AlquilerBarcos.Repository.AdminRepository;
import com.Reto3.AlquilerBarcos.modelo.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save (Admin admin){
        if(admin.getIdAdmin() == null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> aux = adminRepository.getAdmin(admin.getIdAdmin());
            if(aux.isPresent()){
                return admin;
            }else{
                return adminRepository.save(admin);
            }
        }
    }
    
    public Admin update (Admin admin){
        if(admin.getIdAdmin() != null){
            Optional<Admin> ad = adminRepository.getAdmin(admin.getIdAdmin());
            if(ad.isPresent()){
                if(admin.getEmail() != null){
                    ad.get().setEmail(admin.getEmail());
                }
                if(admin.getName() != null){
                    ad.get().setName(admin.getName());
                }
                if(admin.getPassword() != null){
                    ad.get().setPassword(admin.getPassword());
                }
                adminRepository.save(ad.get());
                return ad.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
    
    public boolean delete (int id){
        boolean flag = false;
        Optional <Admin> ad= adminRepository.getAdmin(id);
        if(ad.isPresent()){
            adminRepository.delete(ad.get());
        }
        return flag;
    }
    
}
