package pl.chrapkowski.mksoft.windykacja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "stopy")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StopyProcentoweEntiti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double stopa;
    private String opis;
    private Timestamp utworzone;
}

