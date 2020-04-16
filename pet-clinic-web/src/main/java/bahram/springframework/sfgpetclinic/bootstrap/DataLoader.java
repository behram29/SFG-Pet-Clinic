package bahram.springframework.sfgpetclinic.bootstrap;

import bahram.springframework.sfgpetclinic.model.Owner;
import bahram.springframework.sfgpetclinic.model.Master;
import bahram.springframework.sfgpetclinic.services.OwnerService;
import bahram.springframework.sfgpetclinic.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final MasterService masterService;

    @Autowired
    public DataLoader(OwnerService ownerservice, MasterService masterService) {
        this.ownerservice = ownerservice;
        this.masterService = masterService;
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

        Master master1 = new Master();
        master1.setFirstName("Adil");
        master1.setLastName("Filankesov");

        masterService.save(master1);

        Master master2 = new Master();
        master2.setFirstName("Rehman");
        master2.setLastName("Quliyev");

        masterService.save(master2);

        System.out.println("Loaded Vets...");
    }
}
