package pl.chrapkowski.mksoft.ksiegowosc;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KontrahenciResponse {

    private Long id;
    private String nazwa;
    private Integer konto;
    private LocalDateTime utworzono;

}
