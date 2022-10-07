package pl.chrapkowski.mksoft.windykacja;

import lombok.Data;

@Data
public class KlienciUpdateRequest {

    private Long id;
    private String imie;
    private String nazwisko;
  //  private Long pesel;

}
