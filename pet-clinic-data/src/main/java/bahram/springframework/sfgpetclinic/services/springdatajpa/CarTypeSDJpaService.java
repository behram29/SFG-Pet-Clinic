package bahram.springframework.sfgpetclinic.services.springdatajpa;

import bahram.springframework.sfgpetclinic.model.CarType;
import bahram.springframework.sfgpetclinic.repositories.CarTypeRepository;
import bahram.springframework.sfgpetclinic.services.CarTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class CarTypeSDJpaService implements CarTypeService {

    private final CarTypeRepository carTypeRepository;

    public CarTypeSDJpaService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }


    @Override
    public Set<CarType> findAll() {
        Set<CarType> carTypes =  new HashSet<>();
        carTypeRepository.findAll().forEach(carTypes::add);
        return carTypes;
    }

    @Override
    public CarType findById(Long aLong) {
        return carTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public CarType save(CarType object) {
        return carTypeRepository.save(object);
    }

    @Override
    public void delete(CarType object) {
        carTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        carTypeRepository.deleteById(aLong);
    }
}
