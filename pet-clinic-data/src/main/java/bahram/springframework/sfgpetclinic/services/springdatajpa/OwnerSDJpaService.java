package bahram.springframework.sfgpetclinic.services.springdatajpa;

import bahram.springframework.sfgpetclinic.model.Owner;
import bahram.springframework.sfgpetclinic.repositories.CarRepository;
import bahram.springframework.sfgpetclinic.repositories.OwnerRepository;
import bahram.springframework.sfgpetclinic.services.CarTypeService;
import bahram.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final CarRepository carRepository;
    private final CarTypeService carTypeService;

    public OwnerSDJpaService(OwnerRepository ownerRepository, CarRepository carRepository,
                             CarTypeService carTypeService) {
        this.ownerRepository = ownerRepository;
        this.carRepository = carRepository;
        this.carTypeService = carTypeService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
