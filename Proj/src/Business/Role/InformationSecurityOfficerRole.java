/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.InformationSecurityOraganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.InfoSecOfficerRole.InfoSecOfficerWorkAreaJPanel;

/**
 *
 * @author anike
 */
public class InformationSecurityOfficerRole  extends Role{
    
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new InfoSecOfficerWorkAreaJPanel(userProcessContainer, account, (InformationSecurityOraganization)organization, enterprise);
    }
    
}
