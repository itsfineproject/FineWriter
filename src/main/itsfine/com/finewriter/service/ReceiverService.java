package main.itsfine.com.finewriter.service;

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
    public void takeSensorData(String strSensor) throws IOException {
        FineDto fineDto = mapper.readValue(strSensor, FineDto.class);
        fineRepository.save(new Fine(fineDto));

    }
}
