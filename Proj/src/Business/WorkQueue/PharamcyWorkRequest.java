/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author anike
 */
public class PharamcyWorkRequest extends WorkRequest {
    
     private String testResult;
     private String medicineNames;

    public String getMedicineNames() {
        return medicineNames;
    }

    public void setMedicineNames(String medicineNames) {
        this.medicineNames = medicineNames;
    }
    
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    
}
