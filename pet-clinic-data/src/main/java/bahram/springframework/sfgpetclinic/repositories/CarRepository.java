package bahram.springframework.sfgpetclinic.repositories;

import bahram.springframework.sfgpetclinic.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
    
}
