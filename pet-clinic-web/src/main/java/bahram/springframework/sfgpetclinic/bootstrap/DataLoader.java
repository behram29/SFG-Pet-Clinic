package bahram.springframework.sfgpetclinic.bootstrap;

import bahram.springframework.sfgpetclinic.model.Car;
import bahram.springframework.sfgpetclinic.model.CarType;
import bahram.springframework.sfgpetclinic.model.Owner;
import bahram.springframework.sfgpetclinic.model.Master;
import bahram.springframework.sfgpetclinic.services.CarTypeService;
import bahram.springframework.sfgpetclinic.services.OwnerService;
import bahram.springframework.sfgpetclinic.services.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final MasterService masterService;
    private final CarTypeService carTypeService;

    @Autowired
    public DataLoader(OwnerService ownerservice, MasterService masterService, CarTypeService carTypeService) {
        this.ownerservice = ownerservice;
        this.masterService = masterService;
        this.carTypeService = carTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        CarType sedan = new CarType();
        sedan.setName("Sedan");
        CarType savedSedanCarType = carTypeService.save(sedan);

        CarType suv = new CarType();
        sedan.setName("SUV");
        CarType savedSUVCarType = carTypeService.save(suv);

        System.out.println("CarTypes added");
        System.out.println("CarTypes Loaded...");

        Owner  owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Johnson");
        owner1.setAddress("Bileceri qesebesi");
        owner1.setCity("Baki");
        owner1.setTelephone("0777777777");

        Car mikesCar = new Car();
        mikesCar.setCarType(savedSedanCarType);
        mikesCar.setOwner(owner1);
        mikesCar.setBirthDate(LocalDate.now());
        mikesCar.setName("Toyota Corolla");

        owner1.getCars().add(mikesCar);
        ownerservice.save(owner1);

        Owner  owner2 = new Owner();
        owner2.setFirstName("Sinda");
        owner2.setLastName("Thompson");
        owner2.setAddress("H.Aliyev");
        owner2.setCity("Xirdalan");
        owner2.setTelephone("0555555555");

        Car sindasCar = new Car();
        sindasCar.setCarType(savedSUVCarType);
        sindasCar.setOwner(owner2);
        sindasCar.setBirthDate(LocalDate.now());
        sindasCar.setName("BMW X5");

        owner1.getCars().add(mikesCar);
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
