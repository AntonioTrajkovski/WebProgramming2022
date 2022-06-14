package mk.ukim.finki.wbaud.repository.jpa;

import mk.ukim.finki.wbaud.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

}
