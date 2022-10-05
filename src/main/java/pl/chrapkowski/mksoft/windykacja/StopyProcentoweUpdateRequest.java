package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StopyProcentoweUpdateRequest {

    private LocalDate data;
    private Double stopa;
    private String opis;

}
