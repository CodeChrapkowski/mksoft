package pl.chrapkowski.mksoft.windykacja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface KlienciRepository extends JpaRepository<KlienciEntity, Long> {


    Optional<KlienciEntity> findById(long id);

    KlienciEntity findByimie(String imie);


    /*@Query(
            value = "SELECT* from klienci  where imie= :imie or nazwisko=:imie or pesel=:imie order by nazwisko", nativeQuery = true
    )
    List<KlienciEntity> podajImie(@Param("imie") String imie);
    */

    @Query(value = "SELECT* from klienci  where imie LIKE %:p1% or nazwisko LIKE %:p1% or pesel LIKE %:p1%  order by nazwisko", nativeQuery = true)
    List<KlienciEntity> findKlient(@Param("p1") String p1);




}
