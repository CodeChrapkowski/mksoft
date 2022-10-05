package pl.chrapkowski.mksoft.windykacja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface KlienciRepository extends JpaRepository<KlienciEntity, Long> {


    Optional<KlienciEntity> findById(long id);

    //TODO zapytanie natyvne
    @Query(
            value = "SELECT* from klienci  where imie='ewa'", nativeQuery = true
    )
    List<KlienciEntity> findByAllImie();




    @Query(
            value = "SELECT* from klienci  where imie= :imie or nazwisko=:imie or pesel=:imie", nativeQuery = true
    )
    List<KlienciEntity> podajImie(@Param("imie") String imie);



KlienciEntity findByimie(String imie);


}
