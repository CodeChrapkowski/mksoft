package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StopyProcentoweResponse {

    private LocalDate data;
    private Double stopa;
    private String opis;
    private LocalDateTime utworzono;

}
