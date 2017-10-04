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
public class DataAnalysisWorkRequest extends WorkRequest{
    
     private String testResult;
     private String incidentWriteups;

    public String getIncidentWriteups() {
        return incidentWriteups;
    }

    public void setIncidentWriteups(String incidentWriteups) {
        this.incidentWriteups = incidentWriteups;
    }
     
     
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
}
