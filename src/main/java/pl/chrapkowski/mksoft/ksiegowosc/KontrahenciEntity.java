package pl.chrapkowski.mksoft.ksiegowosc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "kontrahenci")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KontrahenciEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private Integer konto;
    private LocalDateTime utworzono;

}
