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
public class VitalSign {
    
    private int respiratoryRate;
    private int	heartRate;
    private int systolicBloodpressure; 
    private int weight;
    private String timeStmp;
    private String vitalSign;
    private String examinationResult;
    private String prescribedMedicine;

    public String getVitalSign() {
        return vitalSign;
    }

    public String getExaminationResult() {
        return examinationResult;
    }

    public void setExaminationResult(String examinationResult) {
        this.examinationResult = examinationResult;
    }

    public void setVitalSign(String vitalSign) {
        this.vitalSign = vitalSign;
    }
    
    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public String getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(String prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getSystolicBloodpressure() {
        return systolicBloodpressure;
    }

    public void setSystolicBloodpressure(int systolicBloodpressure) {
        this.systolicBloodpressure = systolicBloodpressure;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTimeStmp() {
        return timeStmp;
    }

    public void setTimeStmp(String timeStmp) {
        this.timeStmp = timeStmp;
    }

    @Override
    public String toString() {
        return timeStmp;
    }
    
    
    
}
