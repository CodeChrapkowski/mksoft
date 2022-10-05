package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KlienciResponse {

    private String imie;
    private String nazwisko;
    private Long pesel;
    private LocalDateTime utworzono;

}
