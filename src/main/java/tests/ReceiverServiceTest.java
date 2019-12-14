package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import itsfine.com.finewriter.entity.Fine;
import itsfine.com.finewriter.repository.FineRepository;
import itsfine.com.finewriter.service.ReceiverService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.time.LocalDateTime;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootApplication(scanBasePackages = {"itsfine.com.finewriter"})
@EnableJpaRepositories(basePackages = "itsfine.com.finewriter.repository")
@EntityScan(basePackages = "itsfine.com.finewriter.entity")
class ReceiverServiceTest {

    private ConfigurableApplicationContext configurableApplicationContext;
    private ReceiverService service;
    private FineRepository fineRepository;
    private static final String CAR_NUMBER="AAA";
    private static final LocalDateTime TIME = LocalDateTime.now();
    private static final String STR_PARKING_OBJ = "{\"parking_id\":777,\"car_number\":\"AAA\",\"date_time\":[2019,12,12,12,13,47,673000000]}";

    @BeforeEach
    void setUp() {
        configurableApplicationContext = SpringApplication.run(ReceiverServiceTest.class);
        service = configurableApplicationContext.getBean(ReceiverService.class);
        fineRepository = configurableApplicationContext.getBean(FineRepository.class);
    }

    @AfterEach
    void tearDown() {
        List<Fine> fines = fineRepository.findAll();
        for(Fine fine:fines)
            if((fine.getCar_number().equals(CAR_NUMBER))&&(fine.getDate_time().equals(TIME)))
                fineRepository.deleteById(fine.getId());
        configurableApplicationContext.close();
    }

    @Test
    void writerToDB() throws JsonProcessingException {
        assertTrue(service.writerToDB(STR_PARKING_OBJ));
    }
}