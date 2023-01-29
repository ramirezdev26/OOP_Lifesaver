import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static List<Owner> ownerList = new ArrayList<Owner>();
    static List<Patient> patientList = new ArrayList<Patient>();
    static List<Appointments> appointmentList = new ArrayList<Appointments>();
    public static void main(String[] args) {
        init();
        }


        public static void invoiceOwnerInfo (Owner owner) {
            System.out.println("DNI: " + owner.getDni());
            System.out.println("Name: " + owner.getName());
            System.out.println("Cellphone: " + owner.getCellPhone());
        }

    public static List<Appointments> findingAppointmentByEmployeeType(
            String type, List<Appointments> appointments) {

        List<Appointments> typeAppointments = new ArrayList<Appointments>();

        for (Appointments appointment : appointments) {
            if (appointment.getEmployee().getType().equals(type)) {
                typeAppointments.add(appointment);
            }
        }
        return typeAppointments;
    }

    public static Appointments findingAppointmentByID(
            int id, List<Appointments> appointments) {

        for (Appointments appointment : appointments) {
            if (appointment.getPatient().getClinicNumberId() == id) {
                return appointment;
            }
        }
        return null;
    }
    public static Appointments findingAppointmentByDNI(
            String dni, List<Appointments> appointments) {

        for (Appointments appointment : appointments) {
            if (appointment.getOwner().getDni().equals(dni)) {
                return appointment;
            }
        }
        return null;
    }
    public static Owner findingOwnerByDni(
            String dni, List<Owner> owners) {

        for (Owner owner : owners) {
            if (owner.getDni().equals(dni)) {
                return owner;
            }
        }
        return null;
    }

    public static Patient findingPatientByID(
            int id, List<Patient> patients) {

        for (Patient patient : patients) {
            if (patient.getClinicNumberId() == id) {
                return patient;
            }
        }
        return null;
    }
        public static void init(){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Welcome to lifesaver pet, please choose the number of the option you prefer!");
            System.out.println("1. Register Patient");
            System.out.println("2. Set appointments");
            System.out.println("3. Consulting Appointments by DNI or Pet ID");
            System.out.println("4. Consulting by type of employee");
            String userName = myObj.nextLine();

            switch (userName) {
                case "1":
                    Scanner name = new Scanner(System.in);
                    System.out.println("Pet's name: ");
                    String patientName = name.nextLine();
                    Scanner type = new Scanner(System.in);
                    System.out.println("Pet's type: ");
                    String patientType = type.nextLine();
                    Scanner breed = new Scanner(System.in);
                    System.out.println("Pet's breed: ");
                    String patientBreed = breed.nextLine();
                    Scanner vaccinates = new Scanner(System.in);
                    System.out.println("Pet's vaccinates: ");
                    String patientVaccinates = vaccinates.nextLine();
                    Scanner owner = new Scanner(System.in);
                    System.out.println("Owner's DNI: ");
                    String patientOwner = owner.nextLine();
                    if (!ownerList.contains(patientOwner)) {
                        Scanner dni = new Scanner(System.in);
                        System.out.println("Owner's DNI: ");
                        String ownerDni = dni.nextLine();
                        Scanner nameOw = new Scanner(System.in);
                        System.out.println("Owner's Name: ");
                        String ownerName = nameOw.nextLine();
                        Scanner cellphone = new Scanner(System.in);
                        System.out.println("Owner's Cellphone: ");
                        String ownerCellphone = cellphone.nextLine();
                        Scanner age = new Scanner(System.in);
                        System.out.println("Owner's Age: ");
                        int ownerAge = Integer.parseInt(age.nextLine());
                        if (ownerAge < 18) {
                            Scanner age2 = new Scanner(System.in);
                            System.out.println("Owner's age should be 18 or more: ");
                            ownerAge = Integer.parseInt(age2.nextLine());
                            Owner inputOwner = new Owner(ownerDni, ownerName, ownerCellphone, ownerAge);
                            Patient inputPatient = new Patient(patientType, patientName, patientBreed, inputOwner, patientVaccinates);
                            inputOwner.setPets(inputPatient);
                            ownerList.add(inputOwner);
                            System.out.println("The patient: " + inputPatient + "Ha sido registrado");
                            init();
                        } else {
                            Owner inputOwner = new Owner(ownerDni, ownerName, ownerCellphone, ownerAge);
                            Patient inputPatient = new Patient(patientType, patientName, patientBreed, inputOwner, patientVaccinates);
                            inputOwner.setPets(inputPatient);
                            ownerList.add(inputOwner);
                            patientList.add(inputPatient);
                            System.out.println("The patient: " + inputPatient.getName() + " Ha sido registrado");
                            init();
                        }
                    } else {
                        Owner inputOwner = findingOwnerByDni(patientOwner, ownerList);
                        Patient inputPatient = new Patient(patientType, patientName, patientBreed, inputOwner, patientVaccinates);
                        assert inputOwner != null;
                        inputOwner.setPets(inputPatient);
                        patientList.add(inputPatient);
                        System.out.println("The patient: " + inputPatient.getName() + " Ha sido registrado");
                        init();
                    }
                case "2":
                    Scanner typeAp = new Scanner(System.in);
                    System.out.println("Please write the type of appointment you prefer");
                    System.out.println("1. Medical");
                    System.out.println("2. Surgery");
                    System.out.println("3. Aesthetic");
                    String appointmentType = typeAp.nextLine();
                    Scanner dniOw = new Scanner(System.in);
                    System.out.println("DNI of the owner ");
                    String ownerAp = dniOw.nextLine();
                    Owner appointmentOwner = findingOwnerByDni(ownerAp, ownerList);
                    Scanner patientAp = new Scanner(System.in);
                    System.out.println("Pet's ID: ");
                    String appointmentPa = patientAp.nextLine();
                    Patient appointmentPatient = findingPatientByID(Integer.parseInt(appointmentPa), patientList);
                    Scanner date = new Scanner(System.in);
                    System.out.println("Date: ");
                    String appointmentDate = date.nextLine();
                    Scanner employee = new Scanner(System.in);
                    System.out.println("Write the type of employee");
                    System.out.println("Doctor");
                    System.out.println("Stylist");
                    String employeeType = employee.nextLine();
                    Employee appointmentEmployee = new Employee(employeeType);
                    Appointments inputAppointment = new Appointments(appointmentType, appointmentPatient, appointmentOwner, appointmentEmployee, appointmentDate);
                    appointmentList.add(inputAppointment);
                    System.out.println("Your appointment was successfully added with the next info:");
                    assert appointmentOwner != null;
                    System.out.println("Owner:" + appointmentOwner.getName());
                    assert appointmentPatient != null;
                    System.out.println("Patient:" + appointmentPatient.getName());
                    System.out.println("Type and date: " + inputAppointment.getType() + " " + inputAppointment.getDate());
                    if (Objects.equals(inputAppointment.getType(), "Medical")){
                        invoiceOwnerInfo(appointmentOwner);
                        System.out.println("TOTAL: $10");
                        init();
                    } else if (Objects.equals(inputAppointment.getType(), "Surgery")) {
                        invoiceOwnerInfo(appointmentOwner);
                        System.out.println("TOTAL: $50");
                        init();
                    } else if (Objects.equals(inputAppointment.getType(), "Aesthetic")) {
                        invoiceOwnerInfo(appointmentOwner);
                        System.out.println("TOTAL: $20");
                        init();
                    } else {
                        init();
                    }
                case "3":
                    Scanner criteria = new Scanner(System.in);
                    System.out.println("Select the criteria you would like to do the research:");
                    System.out.println("1. Owner's DNI");
                    System.out.println("2. Patient's ID");
                    String criteriaSelected = criteria.nextLine();
                    if (Objects.equals(criteriaSelected, "1")) {
                        Scanner dni = new Scanner(System.in);
                        System.out.println("Enter the owner's DNI");
                        String dniSearch = dni.nextLine();
                        Appointments appointmentsSelected = findingAppointmentByDNI(dniSearch, appointmentList);
                        assert appointmentsSelected != null;
                        System.out.println("The owner " + appointmentsSelected.getOwner().getName() + " has a pet called " + appointmentsSelected.getPatient().getName() + " which has an appointment at " + appointmentsSelected.getDate());
                        init();
                    } else if (Objects.equals(criteriaSelected, "2")) {
                        Scanner id = new Scanner(System.in);
                        System.out.println("Enter the patient's ID");
                        String idSearch = id.nextLine();
                        Appointments appointmentsSelected = findingAppointmentByDNI(idSearch, appointmentList);
                        assert appointmentsSelected != null;
                        System.out.println("The owner " + appointmentsSelected.getOwner().getName() + " has a pet called " + appointmentsSelected.getPatient().getName() + " which has an appointment at " + appointmentsSelected.getDate());
                        init();
                    } else {
                        System.out.println("Enter a valid DNI or ID");
                        init();
                    }

                case "4":
                    Scanner empType = new Scanner(System.in);
                    System.out.println("Select which type of employee you would like to know the appointment");
                    System.out.println("1. Doctor");
                    System.out.println("2. Stylist");
                    String typeEmployee = empType.nextLine();
                    if (Objects.equals(typeEmployee, "1")){
                        List<Appointments> doctorListed = findingAppointmentByEmployeeType("Doctor", appointmentList);
                        for (Appointments appointment : doctorListed) {
                            System.out.println("Employee:" + appointment.getEmployee().getType());
                            System.out.println("Owner:" + appointment.getOwner().getName());
                            System.out.println("Patient:" + appointment.getPatient().getName());
                            System.out.println("Type and date: " + appointment.getType() + " " + appointment.getDate());
                        }
                        init();
                    } else if (Objects.equals(typeEmployee, "2")) {
                        List<Appointments> stylistListed = findingAppointmentByEmployeeType("Stylist", appointmentList);
                        for (Appointments appointment : stylistListed) {
                            System.out.println("Employee:" + appointment.getEmployee().getType());
                            System.out.println("Owner:" + appointment.getOwner().getName());
                            System.out.println("Patient:" + appointment.getPatient().getName());
                            System.out.println("Type and date: " + appointment.getType() + " " + appointment.getDate());
                        }
                        init();
                    } else {
                        System.out.println("Choose a valid option");
                        init();
                    }
            }
        }
    }
