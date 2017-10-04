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
public class PersonDirectory {
    
    private ArrayList<Person> personDir;
    
    public PersonDirectory(){
        personDir = new ArrayList();
    }

    public ArrayList<Person> getPersonDir() {
        return personDir;
    }

    public void setPersonDir(ArrayList<Person> personDir) {
        this.personDir = personDir;
    }
    
    public void addPersonToDir(Person p){
        personDir.add(p);
    }
    
      public void deletePerson(Person p) {
        personDir.remove(p);
    }
    
     public Person searchPerson(String name) {
        for (Person p : personDir) {
            if ((p.getPersonName().equals(name))) {
                return p;
            }
        }
        return null;
    }
    
}
