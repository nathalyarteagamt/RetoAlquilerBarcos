package com.Reto3.AlquilerBarcos.Services;

import com.Reto3.AlquilerBarcos.Repository.ScoreRepository;
import com.Reto3.AlquilerBarcos.modelo.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save (Score score){
        if(score.getIdScore() == null){
            return scoreRepository.save(score);
        } else {
            Optional<Score> aux =scoreRepository.getScore(score.getIdScore());
            if(aux.isPresent()){
                return score;
            }else{
                return scoreRepository.save(score);
            }
        }
    }
     
    public Score update (Score score){
        if (score.getIdScore() != null){
            Optional<Score> sc = scoreRepository.getScore(score.getIdScore());
            if(sc.isPresent()){
                if(score.getMessageText() != null){
                    sc.get().setMessageText(score.getMessageText());
                }
                if(score.getStars() != null){
                    sc.get().setStars(score.getStars());
                }
                if(score.getReservation() != null){
                    sc.get().setReservation(score.getReservation());
                }
                scoreRepository.save(sc.get());
                return sc.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    
    public boolean delete(int id){
        boolean flag = false;
        Optional <Score> sc = scoreRepository.getScore(id);
        if(sc.isPresent()){
            scoreRepository.delete(sc.get());
        }
        return flag;   
    }
    
}
