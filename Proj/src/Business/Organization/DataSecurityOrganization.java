/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DataSecurityRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author anike
 */
public class DataSecurityOrganization extends Organization {
    
    public DataSecurityOrganization() {
        super(Organization.Type.DataSecurity.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DataSecurityRole());
        return roles;
    }
    
}
