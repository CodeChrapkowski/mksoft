package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WplatyRequest {

    private Long id;
    private LocalDate data_wplaty;
    private Double kowta;
    private Double odsetki;

}
