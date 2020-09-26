import java.util.*;

class Employee {
   String name;
   double salary;
   Integer id;
   String designation;
   String InsuranceScheme;

   public Employee() {
   }

   public Employee(String name, double salary, Integer id, String designation) {
      this.name = name;
      this.salary = salary;
      this.id = id;
      this.designation = designation;
      this.InsuranceScheme = getInsuranceScheme(this.salary);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getDesignation() {
      return designation;
   }

   public void setDesignation(String designation) {
      this.designation = designation;
   }

   public String getInsuranceScheme() {
      return InsuranceScheme;
   }

   public void setInsuranceScheme(String insuranceScheme) {
      InsuranceScheme = insuranceScheme;
   }

   public String getInsuranceScheme(double salary) {
      if (salary > 5000 && salary < 20000) {
         String result = "scheme c";
         this.setInsuranceScheme(result);
         return result;
      }
      if (salary >= 20000 && salary < 40000) {
         String result = "scheme b";
         this.setInsuranceScheme(result);
         return result;
      }
      if (salary >= 40000) {
         String result = "scheme a";
         this.setInsuranceScheme(result);
         return result;
      }
      if (salary < 5000) {
         String result = "no scheme";
         this.setInsuranceScheme(result);
         return result;
      }
      return null;
   }
}

class EmployeeServiceImpl {

   public static HashMap<Integer, Employee> empMap = new HashMap<Integer, Employee>();
   public static int c = 0;

   public static void addEmployee(Employee emp) {
      empMap.put(emp.id, emp);
   }

   public static boolean deleteEmployee(int id) {
      if (empMap.containsKey(id)) {
         empMap.remove(id);
         return true;
      }
      return false;
   }

   public static String showEmpDetails(String InsuranceScheme) {
      for (Map.Entry<Integer, Employee> mapEntry : empMap.entrySet()) {
         Employee obj = ((Employee) mapEntry.getValue());
         if (InsuranceScheme.equals(obj.getInsuranceScheme(obj.salary))) {
            return "Name: " + obj.name + " Id: " + obj.id + " Salary: " + obj.salary + " Designation: "
                  + obj.designation + " InsuranceScheme: " + InsuranceScheme;
         }
      }
      return null;
   }
}