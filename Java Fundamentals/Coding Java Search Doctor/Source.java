import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

class Doctor implements Comparable<Doctor> {

   private String name;
   private String speciality;
   private int experience;

   Doctor(String name, String speciality, int experience) {
      this.name = name;
      this.speciality = speciality;
      this.experience = experience;
   }

   public void setExperience(int experience) {
      this.experience = experience;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setSpeciality(String speciality) {
      this.speciality = speciality;
   }

   public int getExperience() {
      return experience;
   }

   public String getName() {
      return name;
   }

   public String getSpeciality() {
      return speciality;
   }


   @Override
   public boolean equals(Object obj) {
      Doctor guest = (Doctor) obj;
      return (guest.name.equals(this.name) && guest.speciality.equals(this.speciality)
            && guest.experience == this.experience);

   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + (this.name == null ? 0 : this.name.hashCode());
      result += prime * result + (this.speciality == null ? 0 : this.speciality.hashCode());
      result += prime * result + this.experience;
      return result;
   }

   @Override
   public int compareTo(Doctor o) {
      return this.name.compareTo(o.name);
   }

   @Override
   public String toString() {
      return "\t" + this.name + "\t" + this.speciality + "\t" + this.experience;
   }
}

class doctorSorter implements Comparator<Doctor> {
   @Override
   public int compare(Doctor o1, Doctor o2) {
      int value = o1.getSpeciality().compareTo(o2.getSpeciality());
      if (value != 0) {
         return value;
      }
      return o2.getExperience() - o1.getExperience();
   }
}

class DoctorService {

   private List<Doctor> doctorsRepository;

   public DoctorService(List<Doctor> doctorsRepository) {
      this.doctorsRepository = (List<Doctor>) doctorsRepository;
   }
 
   List<Doctor> getExperiencedDoctors(int exp) {
      List<Doctor> filteredDoctorsRepository = new ArrayList<Doctor>();
      for (Doctor d : this.doctorsRepository) {
         if (d.getExperience() >= exp) {
            filteredDoctorsRepository.add(d);
         }
      }

      Collections.sort(filteredDoctorsRepository, new doctorSorter());
      return filteredDoctorsRepository;
   }

  

   TreeSet<Doctor> getSpecialityDoctor(String spec) {
      TreeSet<Doctor> filteredDoctorsRepository = new TreeSet<Doctor>();
      for (Doctor d : this.doctorsRepository) {
         if (d.getSpeciality().equals(spec)) {
            filteredDoctorsRepository.add(d);
         }
      }
      return filteredDoctorsRepository;
   }

}

public class Source {

   private static String doctorsData;

   static {
      StringBuilder doctors = new StringBuilder();
      doctors.append("Amy-Pediatrics-16;");
      doctors.append("John-Dermatology-10;");
      doctors.append("David-Dermatology-15;");
      doctors.append("Bob-Pediatrics-6;");
      doctors.append("Cathy-Dermatology-5;");
      doctors.append("Mavis-Pediatrics-11;");
      doctors.append("Robin-Pediatrics-7;");
      doctors.append("Minty-Dermatology-9;");
      doctors.append("Jim-Cardiology-25;");
      doctorsData = doctors.toString();
   }

   public static void main(String[] args) {
      Scanner scannner = new Scanner(System.in);
      String listOfDoctors[] = doctorsData.split(";");
      List<Doctor> dArrayList = new ArrayList<Doctor>();
      for (String doct : listOfDoctors) {
         String details[] = doct.split("-");
         dArrayList.add(new Doctor(details[0], details[1], Integer.parseInt(details[2])));
      }
      DoctorService doctorService = new DoctorService(dArrayList);
      List<Doctor> resultArrayList = new ArrayList<Doctor>();
      TreeSet<Doctor> resultSet = new TreeSet<Doctor>();
      int method = scannner.nextInt();
      if (method == 1 || method == 2) {
         if (method == 1) {
            resultArrayList = doctorService.getExperiencedDoctors(scannner.nextInt());
            if (resultArrayList.size() == 0) {
               System.out.println("No Doctors Found");
               return;

            }
            for (Doctor doctor : resultArrayList) {
               System.out.println(doctor);
            }
            return;
         } else {
            resultSet = doctorService.getSpecialityDoctor(scannner.nextLine());
            if (resultSet.size() == 0) {
               System.out.println("No Doctors Found");
               return;
            }
            for (Doctor doctor : resultSet) {
               System.out.println(doctor);
            }
            return;
         }
      } else {
         System.out.println("Invalid Choice");
      }
   }
}
