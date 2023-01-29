import java.util.ArrayList;
import java.util.List;

public class Patient {

    public static int count = 0;
    String type;
    int clinicNumberId;
    String name;
    String breed;
    Owner owner;
    String vaccinesAtDay;

    public Patient (String type, String name, String breed, Owner owner, String vaccinesAtDay) {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.vaccinesAtDay = vaccinesAtDay;
        clinicNumberId = ++count;
    }

    public String getType() {
        return type;
    }

    public int getClinicNumberId() {
        return clinicNumberId;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getVaccinesAtDay() {
        return vaccinesAtDay;
    }
}
