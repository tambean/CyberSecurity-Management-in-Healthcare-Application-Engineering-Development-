/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author anike
 */
public class Person {
    private String personName;
    private int age;
    private String EmailAddress;
    private String AddressLine1;
    private String AddressLine2;
    private String contactNumber;
    private static int count = 1000;
    private int patientID;
    private VitalSignHistory vsignHist;
    //private VitalSignHistory vitalhist;

    
    public Person(){
        vsignHist = new VitalSignHistory();
        count++;
        patientID = count;
      //  this.vitalhist = new VitalSignHistory();
    }

    
     public VitalSignHistory getVsignHist() {
        return vsignHist;
    }
    

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    
    public String getEmailAddress() {
        return EmailAddress;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    
    
    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }
    
    

    /*public VitalSignHistory getVitalhist() {
        return vitalhist;
    }*/

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
   /* @Override
    public String toString() {
        return personName; 
    }
    */

    @Override
    public String toString() {
       return Integer.toString(patientID);
    }
}
