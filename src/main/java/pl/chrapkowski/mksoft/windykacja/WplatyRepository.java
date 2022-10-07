package pl.chrapkowski.mksoft.windykacja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WplatyRepository extends JpaRepository<WplatyEntity, Long> {

Optional<WplatyEntity> findById(long id);


}
