package bahram.springframework.sfgpetclinic.services;

import bahram.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
