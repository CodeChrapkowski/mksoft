package pl.chrapkowski.mksoft.windykacja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name ="sprawy")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SprawyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private KlienciEntity klient;
    private Double kwota_zadluzenia;
    private LocalDate termin_zaplaty;
    private Short nr_sprawy;
    private Short rok;
    private String opis;
    private LocalDateTime utworzono;

    @OneToMany(mappedBy = "sprawa")
    private List<WplatyEntity> wplatyEntityList;

}
