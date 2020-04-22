package bahram.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="cars")
public class Car extends BaseEntity{

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="type_id")
    private CarType carType;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
