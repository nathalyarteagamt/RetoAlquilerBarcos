package com.Reto3.AlquilerBarcos.Repository;

import com.Reto3.AlquilerBarcos.Crud.ScoreCrudRepository;
import com.Reto3.AlquilerBarcos.modelo.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    
    public Score save (Score score){
        return scoreCrudRepository.save(score);
    }
    
    public void delete (Score score){
        scoreCrudRepository.delete(score);
    }
    
}
