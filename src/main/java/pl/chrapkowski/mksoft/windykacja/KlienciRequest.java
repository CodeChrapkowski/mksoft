package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;


@Data
public class KlienciRequest {

    private String imie;
    private String nazwisko;
    private Long pesel;

}
