package pl.chrapkowski.mksoft.windykacja;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "klienci")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class KlienciEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String imie;

    private String nazwisko;

    private Long pesel;


}
