/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author anike
 */
public class VitalSignHistory {
    
     private ArrayList<VitalSign> vitalHistory;

    public ArrayList<VitalSign> getVitalHistory() {
        return vitalHistory;
    }

    public void setVitalHistory(ArrayList<VitalSign> vitalHistory) {
        this.vitalHistory = vitalHistory;
    }
    
    public VitalSignHistory(){
        vitalHistory = new ArrayList<>();
    }
    
    public void deleteVitalSign(VitalSign vs){
        vitalHistory.remove(vs);
    }
     
     public void addVitalSign(VitalSign vs){
         vitalHistory.add(vs);
     }
    
}
