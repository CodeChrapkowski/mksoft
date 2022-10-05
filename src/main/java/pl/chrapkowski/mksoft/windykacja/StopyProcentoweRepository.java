package pl.chrapkowski.mksoft.windykacja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StopyProcentoweRepository extends JpaRepository<StopyProcentoweEntiti, Long> {

    Optional<StopyProcentoweEntiti> findById(long id);

}
