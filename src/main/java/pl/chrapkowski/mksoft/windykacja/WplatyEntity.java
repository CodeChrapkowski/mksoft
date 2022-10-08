package pl.chrapkowski.mksoft.windykacja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "wplaty")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WplatyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data_wplaty;
    private Double kowta;
    private Double odsetki;
    private LocalDateTime utworzono;

    @ManyToOne
    private SprawyEntity sprawa;
}
