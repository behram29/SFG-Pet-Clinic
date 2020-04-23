package bahram.springframework.sfgpetclinic.services.map;

import bahram.springframework.sfgpetclinic.model.Master;
import bahram.springframework.sfgpetclinic.model.Speciality;
import bahram.springframework.sfgpetclinic.services.MasterService;
import bahram.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MasterMapService extends AbstractMapService<Master, Long> implements MasterService {

    private final SpecialityService specialityService;

    public MasterMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Master> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Master object) {
        super.delete(object);
    }

    @Override
    public Master save(Master object) {

        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Master findById(Long id) {
        return super.findById(id);
    }
}
