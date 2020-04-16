package bahram.springframework.sfgpetclinic.services.map;

import bahram.springframework.sfgpetclinic.model.Master;
import bahram.springframework.sfgpetclinic.services.MasterService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MasterServiceMap extends AbstractMapService<Master, Long> implements MasterService {
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
        return super.save(object);
    }

    @Override
    public Master findById(Long id) {
        return super.findById(id);
    }
}
