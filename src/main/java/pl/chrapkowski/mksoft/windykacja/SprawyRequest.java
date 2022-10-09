package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;


import java.time.LocalDate;
import java.util.List;


@Data
public class SprawyRequest {

    private KlienciEntity klient;
    private Double kwota_zadluzenia;
    private LocalDate termin_zaplaty;
    private Short nr_sprawy;
    private Short rok;
    private String opis;


}

