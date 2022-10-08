package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WplatyResponse {

    private Long id;
    private LocalDate data_wplaty;
    private Double kowta;
    private Double odsetki;
    private Short nr_sprawy;
    private String nazwisko;
    private LocalDateTime utworzono;

}
