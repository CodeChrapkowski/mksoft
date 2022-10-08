package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SprawyResponse {

    private Long id;
    private KlienciEntity klient;
    private String nazwisko_klient;
    private Double kwota_zadluzenia;
    private LocalDate termin_zaplaty;
    private Short nr_sprawy;
    private Short rok;
    private String opis;
    private LocalDateTime utworzono;

}
