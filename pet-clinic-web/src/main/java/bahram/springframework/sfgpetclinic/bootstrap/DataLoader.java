package bahram.springframework.sfgpetclinic.bootstrap;

import bahram.springframework.sfgpetclinic.model.*;
import bahram.springframework.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerservice;
    private final MasterService masterService;
    private final CarTypeService carTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerservice, MasterService masterService, CarTypeService carTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerservice = ownerservice;
        this.masterService = masterService;
        this.carTypeService = carTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = carTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {

        //Cartypes...

        CarType sedan = new CarType();
        sedan.setName("Sedan");
        CarType savedSedanCarType = carTypeService.save(sedan);

        CarType suv = new CarType();
        sedan.setName("SUV");
        CarType savedSUVCarType = carTypeService.save(suv);

        System.out.println("CarTypes added");
        System.out.println("CarTypes Loaded...");

        //Specialities...

        Speciality electrician = new Speciality();
        electrician.setDescription("Electrician");
        Speciality savedElectrician = specialityService.save(electrician);

        Speciality motorist = new Speciality();
        motorist.setDescription("Motorist");
        Speciality savedMotorist = specialityService.save(motorist);

        Speciality painter = new Speciality();
        painter.setDescription("Painter");
        Speciality savedPainter = specialityService.save(painter);

        //Owner...

        Owner owner1 = new Owner();
        owner1.setFirstName("Mike");
        owner1.setLastName("Johnson");
        owner1.setAddress("Bileceri qesebesi");
        owner1.setCity("Baki");
        owner1.setTelephone("0777777777");

        //Owner.builder().address("ASDF").;

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

        owner2.getCars().add(sindasCar);
        ownerservice.save(owner2);

        Visit carVisit = new Visit();
        carVisit.setCar(mikesCar);
        carVisit.setDate(LocalDate.now());
        carVisit.setDescription("Oil Change");

        visitService.save(carVisit);

        System.out.println("Loaded Owners...");

        Master master1 = new Master();
        master1.setFirstName("Adil");
        master1.setLastName("Filankesov");
        master1.getSpecialities().add(savedElectrician);
        masterService.save(master1);

        Master master2 = new Master();
        master2.setFirstName("Rehman");
        master2.setLastName("Quliyev");
        master2.getSpecialities().add(savedPainter);
        masterService.save(master2);

        System.out.println("Loaded Masters...");




        //Masters...


    }
}
