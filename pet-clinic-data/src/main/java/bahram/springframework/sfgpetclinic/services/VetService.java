package bahram.springframework.sfgpetclinic.services;

import bahram.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long Id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
