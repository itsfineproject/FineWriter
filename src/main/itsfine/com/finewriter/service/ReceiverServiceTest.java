package main.itsfine.com.finewriter.service;

import main.itsfine.com.finewriter.dto.FineDto;
import main.itsfine.com.finewriter.repository.FineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootApplication(scanBasePackages = {"main.itsfine.com.finewriter"})
@EnableJpaRepositories(basePackages = "main.itsfine.com.finewriter.repository")
@EntityScan(basePackages = "main.itsfine.com.finewriter.entity")
class ReceiverServiceTest {

    ConfigurableApplicationContext configurableApplicationContext;
    ReceiverService service;


    FineRepository fineRepository;

    private static final int PARKINGID = 1;
    private static final String CARNUMBER="AAA-777";
    private static final LocalDateTime TIME = LocalDateTime.parse("2019-01-01T12:12:12");
    FineDto fineDto = new FineDto(PARKINGID,CARNUMBER,TIME);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        configurableApplicationContext = SpringApplication.run(ReceiverServiceTest.class);
        service = configurableApplicationContext.getBean(ReceiverService.class);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        configurableApplicationContext.close();
    }


    @org.junit.jupiter.api.Test
    void writewriterToDB(){
        assertEquals(true,service.writerToDB(fineDto));

    }
}