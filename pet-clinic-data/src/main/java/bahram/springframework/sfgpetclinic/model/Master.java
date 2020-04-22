package bahram.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="master")
public class Master extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "master_specialties",
            joinColumns = @JoinTable(name = "master_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities =  new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }


}
