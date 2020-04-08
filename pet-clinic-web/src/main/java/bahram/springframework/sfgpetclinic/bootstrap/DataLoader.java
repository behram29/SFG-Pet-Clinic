package bahram.springframework.sfgpetclinic.bootstrap;

import bahram.springframework.sfgpetclinic.model.Owner;
import bahram.springframework.sfgpetclinic.model.Vet;
import bahram.springframework.sfgpetclinic.services.OwnerService;
import bahram.springframework.sfgpetclinic.services.VetService;
import bahram.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import bahram.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final VetService vetService;

    public DataLoader() {
        ownerservice = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner  owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mike");
        owner1.setLastName("Johnson");

        ownerservice.save(owner1);

        Owner  owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Sinda");
        owner2.setLastName("Thompson");

        ownerservice.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Adil");
        vet1.setLastName("Filankesov");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Rehman");
        vet2.setLastName("Quliyev");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
