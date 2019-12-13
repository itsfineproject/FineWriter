package main.itsfine.com.finewriter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.itsfine.com.finewriter.dto.FineDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="fines")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "car_number")
    private String car_number;
    @Column(name = "parking_id")
    private int parking_id;
    @Column(name = "date_time")
    private LocalDateTime date_time;

    public Fine(String car_number, int parking_id, LocalDateTime date_time) {
        this.car_number = car_number;
        this.parking_id = parking_id;
        this.date_time = date_time;
    }

    public Fine(FineDto fineDto){
        this.parking_id=fineDto.getParking_id();
        this.car_number=fineDto.getCar_number();
        this.date_time=fineDto.getDate_time();

    }
}
