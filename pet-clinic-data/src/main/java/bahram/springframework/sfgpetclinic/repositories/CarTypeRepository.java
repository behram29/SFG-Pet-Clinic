package bahram.springframework.sfgpetclinic.repositories;

import bahram.springframework.sfgpetclinic.model.CarType;
import org.springframework.data.repository.CrudRepository;


public interface CarTypeRepository extends CrudRepository<CarType, Long> {
}
