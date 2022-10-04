package pl.chrapkowski.mksoft.windykacja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KlienciRepository extends JpaRepository<KlienciEntity, Long> {

    Optional<KlienciEntity> findById(long id);

    //TODO Nie dział zapytanie natyvne pobierające nazwisko
    @Query(
            value = "SELECT imie from klienci", nativeQuery = true
    )
    List<KlienciEntity> finfbyImie();



}
