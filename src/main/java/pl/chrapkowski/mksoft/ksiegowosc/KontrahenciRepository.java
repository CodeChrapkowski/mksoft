package pl.chrapkowski.mksoft.ksiegowosc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KontrahenciRepository extends JpaRepository<KontrahenciEntity,Long> {

   Optional<KontrahenciEntity> findById(long id);

}
