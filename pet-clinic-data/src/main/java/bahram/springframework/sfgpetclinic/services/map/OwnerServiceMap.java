package bahram.springframework.sfgpetclinic.services.map;

import bahram.springframework.sfgpetclinic.model.Car;
import bahram.springframework.sfgpetclinic.model.CarType;
import bahram.springframework.sfgpetclinic.model.Owner;
import bahram.springframework.sfgpetclinic.services.CarService;
import bahram.springframework.sfgpetclinic.services.CarTypeService;
import bahram.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final CarTypeService carTypeService;
    private final CarService carService;

    public OwnerServiceMap(CarTypeService carTypeService, CarService carService) {
        this.carTypeService = carTypeService;
        this.carService = carService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null) {
            if(object.getCars() != null){
                object.getCars().forEach(car -> {
                    if(car.getCarType() != null){
                        if(car.getCarType().getId() == null){
                            car.setCarType(carTypeService.save(car.getCarType()));
                        }
                    }else{
                        throw new RuntimeException("Car Type is Required");
                    }

                    if(car.getId() == null){
                        Car savedCar = carService.save(car);
                        car.setId(savedCar.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
