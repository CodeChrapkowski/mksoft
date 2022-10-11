package pl.chrapkowski.mksoft.windykacja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SprawyRepository extends JpaRepository<SprawyEntity, Long> {

    Optional<SprawyEntity> findById(Long id);

}
