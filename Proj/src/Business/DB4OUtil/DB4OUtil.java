package Business.DB4OUtil;

import Business.ConfigureEcoSystem;
import Business.EcoSystem;
import Business.Employee.Employee;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.sql.Array;
import java.util.ArrayList;

/**
 *
 * @author CUTIE
 */
public class DB4OUtil {

    private static final String filePathForSystem = "E:\\AED\\Project\\My_Proj\\Proj\\DataBankForSystem.db4o"; // path to the data store
    private static final String filePathForUserNameList = "E:\\AED\\Project\\My_Proj\\Proj\\DataBankForUserName.db4o"; // path to the data store
    private static final String filePathForEmployeeID = "E:\\AED\\Project\\My_Proj\\Proj\\DataBankForEmployeeID.db4o";
    
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private static ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, filePathForSystem);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
    
    private static ObjectContainer createConnectionForUserNameList() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(ArrayList.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, filePathForUserNameList);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

        private static ObjectContainer createConnectionForEmpID() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, filePathForEmployeeID);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
        
    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
    public EcoSystem retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class); // Change to the object you want to save
        EcoSystem system;
        if (systems.size() == 0){
            system = ConfigureEcoSystem.configure();  // If there's no System in the record, create a new one
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        return system;
    }
    
      public static synchronized void storeUserNameList(ArrayList<String> List) {
        ObjectContainer conn = createConnectionForUserNameList();
        conn.store((Object)List);
        System.out.println("arraylist of username stored");
        conn.commit();
        conn.close();
    }
        public static ArrayList retrieveUserNameList(){
        ObjectContainer conn = createConnectionForUserNameList();
        ObjectSet<ArrayList> usernameLists = conn.query(ArrayList.class);
        ArrayList<String> usernameList;
        if (usernameLists.size() == 0){
            usernameList = new ArrayList<String>();// If there's no System in the record, create a new one
        }
        else{
            usernameList = usernameLists.get(usernameLists.size() - 1);
            System.out.println("arraylist of username retrived");
        }        
        conn.close();
        return usernameList;
    }
        
    public static synchronized void storeEMPID(ArrayList<Integer>  empID) {
        ObjectContainer conn = createConnectionForEmpID();
        conn.store((Object)empID);
        System.out.println("arraylist of empID stored");
        conn.commit();
        conn.close();
    }
    public static ArrayList retrieveEMPID(){
        ObjectContainer conn = createConnectionForEmpID();
        ObjectSet<ArrayList> empLists = conn.query(ArrayList.class);
        ArrayList<Integer> empList;
        if (empLists.size() == 0){
            empList = new ArrayList<Integer>();// If there's no System in the record, create a new one
        }
        else{
            empList = empLists.get(empLists.size() - 1);
            System.out.println("arraylist of empID retrived");
        }        
        conn.close();
        return empList;
    }
    
}
