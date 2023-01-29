import java.util.Date;

public class Appointments {

    String type;

    Patient patient;

    Owner owner;

    Employee employee;

    String status = "Not Started";
    String date;
    public Appointments(String type, Patient patient, Owner owner, Employee employee, String date) {
        this.type = type;
        this.patient = patient;
        this.owner = owner;
        this.employee = employee;
        this.date = date;
    }
    public Employee getEmployee() {
        return employee;
    }
    public String getType() {
        return type;
    }

    public Patient getPatient() {
        return patient;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }


    public void setStatus(String status) {
        this.status = status;
    }


}
