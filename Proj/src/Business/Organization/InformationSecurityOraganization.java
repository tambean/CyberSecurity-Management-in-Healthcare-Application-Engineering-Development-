/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InformationSecurityOfficerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author anike
 */
public class InformationSecurityOraganization extends Organization {
    
  
    
     public InformationSecurityOraganization() {
        super(Organization.Type.InformationSecurity.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InformationSecurityOfficerRole());
        return roles;
    }
      
}
