
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

interface AdminService{
    void displayToys();
    void addToys(Toy toy);
}

class AdminServiceImpl implements AdminService{
    static HashSet<Toy> toysSet=new HashSet<Toy>();
    public void displayToys(){
        Iterator i=toysSet.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
    public void addToys(Toy toy){
        boolean added=toysSet.add(toy);
        if(added){
            System.out.println("Toy added successfully");
        }
    }
}
class TestCustomer{
    TreeMap<Customer,Toy> customerMap =new TreeMap<Customer,Toy>();
    public void displayCustomers(){
        for(Map.Entry m:customerMap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
    public void addCustomer(Customer customer,Toy toy){
        customerMap.put(customer,toy);
        System.out.println("Customer added successfully");
    }
}
public class Source{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        AdminService as=new AdminServiceImpl();
        as.addToys(new Toy(sc.nextInt(),sc.nextLine(),sc.nextLine(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
    }
}

class Toy 
{
  private int toyId,minAge,maxAge,price,quantity,refundableDeposit,rentalAmount;
  private String toyName,toyType;
  
  public Toy() {
  }
  
   public Toy(int toyId, String toyName, String toyType, int minAge, int maxAge, int price, int quantity,int rentalAmount, int refundableDeposit)
   {
        
    this.toyId=toyId;
     this.toyName = toyName;
     this.toyType = toyType;
    this.minAge = minAge;
    this.maxAge = maxAge;
   
    this.price = price;
     this.quantity = quantity;
    
   this.rentalAmount = rentalAmount;
    this.refundableDeposit = refundableDeposit;
   
  }
  
  public int getToyId() {
    return toyId;
  }
  public void setToyId(int toyId) {
    this.toyId = toyId;
  }
  public String getToyType() {
    return toyType;
  }
  public void setToyType(String toyType) {
    this.toyType = toyType;
  }
  public int getMinAge() {
    return minAge;
  }
  public void setMinAge(int minAge) {
    this.minAge = minAge;
  }
  public int getMaxAge() {
    return maxAge;
  }
  public void setMaxAge(int maxAge) {
    this.maxAge = maxAge;
  }
  public String getToyName() {
    return toyName;
  }
  public void setToyName(String toyName) {
    this.toyName = toyName;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public int getRefundableDeposit() {
    return refundableDeposit;
  }
  public void setRefundableDeposit(int refundableDeposit) {
    this.refundableDeposit = refundableDeposit;
  }
  public int getRentalAmount() {
    return rentalAmount;
  }
  public void setRentalAmount(int rentalAmount) {
    this.rentalAmount = rentalAmount;
  }
  
  @Override public String toString(){
      return "Toy Name: "+toyName+"\tRent: "+rentalAmount;
  }
 
 @Override
 public boolean equals(Object t){
     if(((Toy) t).getToyName().equals(this.toyName)){
         return true;
     }
     return false;
 }
  @Override
  public int hashCode(){
      int hash=3;
      hash=hash+(toyName.hashCode());
      return hash;
  }
}
class Customer implements Comparable<Customer>
{
  private int customerId;
  private String customerName;
  private String email;
  private String password;
  private Address address;
   public Customer(){
         }
  public Customer(int customerId, String customerName, String email, String password, Address address) {
//     super();
    this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.address = address;
        this.email = email;
  }
  public int getCustomerId(){
      return customerId;
  }
  public void setCustomerId(int customerId){
      this.customerId=customerId;
  }
  public String getCustomerName(){
      return customerName;
  }
  public void setCustomerName(String customerName){
      this.customerName=customerName;
  }
  public String getEmail(){
      return email;
  }
  public void setEmail(String email){
      this.email=email;
  }
  public Address getAddress(){
      return address;
  }
  public void setAddress(Address address){
      this.address=address;
  }
  public String getPassword(){
        return password;
    }
    public void setPassword(String password){
      this.password=password;
  }
  @Override
  public String toString(){
      return "Name: "+customerName+"\tCity: "+address.getCity();
  }
  @Override
  public int compareTo(Customer c){
      return this.customerId-c.getCustomerId();
  }

}

class Address{
    String city, state, country;
    int zip;
    public Address(String state, String city, int zip, String country){
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setZip(int zip){
        this.zip = zip;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public int getZip(){
        return zip;
    }
    public String getCountry(){
        return country;
    }
    @Override
    public String toString(){
        return getCity()+" "+getState()+" "+getZip()+" "+getCountry()+"";
    }
}
