package main.itsfine.com.finewriter.service;

import main.itsfine.com.finewriter.dto.FineDto;
import main.itsfine.com.finewriter.entity.Fine;

import java.util.List;

public interface IFineService {

    public boolean writeToDB(FineDto newFine);
    public List<Fine> readDB();
}
