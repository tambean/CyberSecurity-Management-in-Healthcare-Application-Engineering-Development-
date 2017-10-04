/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.util.regex.Pattern;

/**
 *
 * @author orange
 */
public class Validations {
    
    String emailPattern = "^[\\w-\\.+]*[\\w-\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    
    public boolean ValidateEmptyTextBox(String string){
        
        if(string.trim().equals("")){
            return false;
        }
        
    return true;
    
    }
    
    public boolean ValidatePhone(String phoneNumber){
        if (phoneNumber.matches("\\d{10}")){
            return true;
        }
        return false;
    }
    
    public boolean ValidateAge(String number){
        if (number.matches("^\\d{1,2}")){
            return true;
        }
        return false;
    }
    
    public boolean ValidateWeight(String number) {
        if (number.matches("^\\d{1,3}")) {
            return true;
        }
        return false;
    }
    
    public boolean ValidateEmail(String email){
    
        return email.matches(emailPattern);
    }
 
    public boolean ValidateDuplicateUserAccount(EcoSystem business, String userName){
            
       boolean usernameUnique = true;
        usernameUnique = business.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
        if(true == usernameUnique){
            //Get each network from ecosystem
            for(Network network:business.getNetworkList()){
                //checking for each enterprise
                for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                    usernameUnique =  enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
                    if(true == usernameUnique){
                        ///checking in the organization
                        for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                            usernameUnique = organization.getUserAccountDirectory().checkIfUsernameIsUnique(userName);
                            if(false == usernameUnique){
                                return false;
                            }
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        if(true == usernameUnique){
            return true;
        }
        return false;
    }
    
    
    public boolean ValidateDuplicateNetworkName(String string, EcoSystem business){
        
         for(Network network:business.getNetworkList()){
             if(network.getName().equalsIgnoreCase(string)){
                 return false;
             }
         }
         return true;
    }
    
    public boolean ValidateDuplicateEmployeeName(String string, EcoSystem business) {
       
        for(Network net: business.getNetworkList()){
            for(Enterprise enterprise: net.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
                    for(Employee e:o.getEmployeeDirectory().getEmployeeList()){
                        if (e.getName().matches(string)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}


