package main.itsfine.com.finewriter.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter


public class FineDto {
    //    @Column(name = "parking_id")
    private int parking_id;
//    @Column(name = "car_number")
    private String car_number;

//    @JsonFormat(pattern = "yyyy-MM-dd")

//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Column(name = "date_time")
    private LocalDateTime date_time;

    @Override
    public String toString() {
        return "FineDto{" +
                "parking_id=" + parking_id +
                ", car_number='" + car_number + '\'' +
                ", date_time=" + date_time +
                '}';
    }
}
