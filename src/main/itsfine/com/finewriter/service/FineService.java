package main.itsfine.com.finewriter.service;

import main.itsfine.com.finewriter.dto.FineDto;
import main.itsfine.com.finewriter.entity.Fine;
import main.itsfine.com.finewriter.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//@Service
public class FineService implements IFineService {

//    @Autowired
    FineRepository fineRepository;

    @Override
    public boolean writeToDB(FineDto newFine) {
        fineRepository.save(new Fine(newFine));
        return true;
    }

    @Override
    public List<Fine> readDB() {
        HashSet<Fine> result = new HashSet<>();
        for(Fine fine:fineRepository.findAll())
                result.add(fine);
        System.out.println(result);
        return new ArrayList<>(result);
    }
}
