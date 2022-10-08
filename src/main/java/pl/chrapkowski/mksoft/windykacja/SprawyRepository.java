package pl.chrapkowski.mksoft.windykacja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprawyRepository extends JpaRepository<SprawyEntity, Long> {


}
