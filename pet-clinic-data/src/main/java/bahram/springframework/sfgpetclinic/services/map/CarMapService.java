package bahram.springframework.sfgpetclinic.services.map;

import bahram.springframework.sfgpetclinic.model.Car;
import bahram.springframework.sfgpetclinic.services.CarService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class CarMapService extends AbstractMapService<Car,Long> implements CarService {
    @Override
    public Set<Car> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Car object) {
        super.delete(object);
    }

    @Override
    public Car save(Car object) {
        return super.save(object);
    }

    @Override
    public Car findById(Long id) {
        return super.findById(id);
    }
}
