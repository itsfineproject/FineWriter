package main.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import main.itsfine.com.finewriter.entity.Fine;
import main.itsfine.com.finewriter.repository.FineRepository;
import main.itsfine.com.finewriter.service.ReceiverService;
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
@SpringBootApplication(scanBasePackages = {"main.itsfine.com.finewriter"})
@EnableJpaRepositories(basePackages = "main.itsfine.com.finewriter.repository")
@EntityScan(basePackages = "main.itsfine.com.finewriter.entity")
class ReceiverServiceTest {

    ConfigurableApplicationContext configurableApplicationContext;
    ReceiverService service;
    FineRepository fineRepository;
    private static final String CARNUMBER="AAA";
    private static final LocalDateTime TIME = LocalDateTime.parse("2019-12-12T12:13:48");
    private static final String STRPARKINGOBJ = "{\"parking_id\":777,\"car_number\":\"AAA\",\"date_time\":[2019,12,12,12,13,47,673000000]}";


    ReceiverServiceTest() throws JsonProcessingException {
    }

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
            if((fine.getCar_number().equals(CARNUMBER))&&(fine.getDate_time().equals(TIME)))

                fineRepository.deleteById(fine.getId());
        configurableApplicationContext.close();
    }


    @Test
    void writerToDB() throws JsonProcessingException {

        assertEquals(true,service.writerToDB(STRPARKINGOBJ));
    }
}