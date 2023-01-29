import java.util.ArrayList;
import java.util.List;

public class Owner {

    String dni;

    String name;
    String cellPhone;
    int age;
    private List<Patient> pets = new ArrayList<Patient>();

    public Owner ( String dni, String name, String cellPhone, int age) {
        this.dni = dni;
        this.name = name;
        this.cellPhone = cellPhone;
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public int getAge() {
        return age;
    }

    public List<Patient> getPets() {
        return pets;
    }

    public void setPets(Patient pet) {
        pets.add(pet);
    }
}