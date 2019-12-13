package main.itsfine.com.finewriter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.itsfine.com.finewriter.dto.FineDto;
import main.itsfine.com.finewriter.entity.Fine;
import main.itsfine.com.finewriter.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.io.IOException;

@EnableBinding(Sink.class)
public class ReceiverService {
    ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();


    @Autowired
    FineRepository fineRepository;

    @StreamListener(Sink.INPUT)
    public void takeParkingObj(String strParkingObj) throws IOException {

        writerToDB(strParkingObj);
    }
    public boolean writerToDB(String strParkingObj) throws JsonProcessingException {
        FineDto fineDto = mapper.readValue(strParkingObj, FineDto.class);
            fineRepository.save(new Fine(fineDto));
            return true;
    }
}
