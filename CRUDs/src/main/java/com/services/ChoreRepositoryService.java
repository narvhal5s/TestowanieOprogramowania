package com.services;

import com.entity.Chore;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Log
@Service
public class ChoreRepositoryService {
    @Autowired
    private final ChoreRepository choreRepository;

    public long saveChore(Chore chore){
        choreRepository.save(chore);
        return 1;
    }

    public long countObject(){
        return choreRepository.count();
    }

}
