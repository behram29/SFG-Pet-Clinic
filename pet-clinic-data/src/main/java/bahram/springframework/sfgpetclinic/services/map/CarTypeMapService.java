package bahram.springframework.sfgpetclinic.services.map;

import bahram.springframework.sfgpetclinic.model.CarType;
import bahram.springframework.sfgpetclinic.services.CarTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class CarTypeMapService extends AbstractMapService<CarType, Long> implements CarTypeService {
    @Override
    public Set<CarType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(CarType object) {
        super.delete(object);
    }

    @Override
    public CarType save(CarType object) {
        return super.save(object);
    }

    @Override
    public CarType findById(Long id) {
        return super.findById(id);
    }
}
