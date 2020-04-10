package bahram.springframework.sfgpetclinic.bootstrap;

import bahram.springframework.sfgpetclinic.model.Owner;
import bahram.springframework.sfgpetclinic.model.Vet;
import bahram.springframework.sfgpetclinic.services.OwnerService;
import bahram.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerservice, VetService vetService) {
        this.ownerservice = ownerservice;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner  owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Johnson");

        ownerservice.save(owner1);

        Owner  owner2 = new Owner();
        owner2.setFirstName("Sinda");
        owner2.setLastName("Thompson");

        ownerservice.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Adil");
        vet1.setLastName("Filankesov");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Rehman");
        vet2.setLastName("Quliyev");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
