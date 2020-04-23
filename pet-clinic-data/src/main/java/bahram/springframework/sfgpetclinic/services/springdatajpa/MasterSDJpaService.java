package bahram.springframework.sfgpetclinic.services.springdatajpa;

import bahram.springframework.sfgpetclinic.model.Master;
import bahram.springframework.sfgpetclinic.repositories.MasterRepository;
import bahram.springframework.sfgpetclinic.services.MasterService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MasterSDJpaService implements MasterService {

    private final MasterRepository masterRepository;

    public MasterSDJpaService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    @Override
    public Set<Master> findAll() {

        Set<Master> masters = new HashSet<>();
        masterRepository.findAll().forEach(masters::add);

        return masters;
    }

    @Override
    public Master findById(Long aLong) {
        return masterRepository.findById(aLong).orElse(null);
    }

    @Override
    public Master save(Master object) {
        return masterRepository.save(object);
    }

    @Override
    public void delete(Master object) {
        masterRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        masterRepository.deleteById(aLong);
    }
}
