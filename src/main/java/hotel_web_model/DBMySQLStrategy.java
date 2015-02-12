package hotel_web_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
/**
 *
 * @author eennis
 */
public class DBMySQLStrategy implements DBAccess {
    
    private Connection conn;
    
    @Override
    public void openConnection(String driverName, String url, String userName, String password) {
        try{
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, userName, password);
            
        }catch(ClassNotFoundException cnfe){
            System.out.println("Class wasn't found.");
            
        }catch(SQLException sqle){
            System.out.println("Couldn't open connection.");
        }
    }
    
    @Override
    public void closeConnection() {
        try{
            conn.close();
        }catch(SQLException sqle){
            System.out.println("Connection couldn't close.");
        }
    }
    
    @Override
    public List<Map<String, Object>> findAllRecords(String tableName){
        
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        Map<String, Object> record = null;
        List<Map<String, Object>> records = new ArrayList<>();
        
        try{
            
            String sql = "Select * From " + tableName;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            
            while(rs.next()){
                record = new HashMap<>();
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    record.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                records.add(record);
            }
            
            stmt.close();
            closeConnection();
            
        }catch(SQLException sqle){
            System.out.println("SQL exception for findAllRecords.");
        }
  
        return records;
    }
    
    //UPDATE `hotel`.`hotel` SET `city`='Moors' WHERE `hotel_id`='1';
    @Override
    public int updateRecord(String tableName, String pkKey, int pk, String colName, Object value){
        
        int updates = 0;
        PreparedStatement pstmt = null;
        
        try{
            
            String sql = "UPDATE " + tableName + " SET " + colName + " = '" + value + "' WHERE " + pkKey + " = " + pk;
            pstmt = conn.prepareStatement(sql);
            updates = pstmt.executeUpdate();
            
            pstmt.close();
            closeConnection();
            
        }catch(SQLException sqle){
            System.out.println("SQL exception for updateRecord");
        }
        
        return updates;
    }
    
    //DELETE FROM `hotel`.`hotel` WHERE `hotel_id`='1';
    @Override
    public int deleteRecord(String tableName, String pkKey, int pk){
        
        int updates = 0;
        PreparedStatement pstmt = null;
        
        try{
            
            String sql = "DELETE FROM " + tableName + " WHERE " + pkKey + " = " + pk;
            pstmt = conn.prepareStatement(sql);
            updates = pstmt.executeUpdate();
            
            PreparedStatement resetIncrement = conn.prepareStatement("ALTER TABLE " + tableName + " AUTO_INCREMENT = 1");
            resetIncrement.executeUpdate();
            pstmt.close();
            closeConnection();
            
        }catch(SQLException sqle){
            System.out.println("SQL exception for deleteRecord.");
        }
        return updates;
    }
    
    @Override
//    INSERT INTO hotel ('hotel_name', 'street_address', 'city', 'state', 'postal_code', 'notes') VALUES ('TacoLand', '535 Taco Way', 'Las Vegas', 'Nevada', '57335', 'A place for tacos and taco lovers.');
//    INSERT INTO `hotel`.`hotel` (`hotel_name`, `street_address`, `city`, `state`, `postal_code`, `notes`) VALUES ('TacoLand', '534 Taco Way', 'Las Vegas', 'Nevada', '53267', 'A place for tacos and taco lovers.');
    public int insertRecord(String tableName, List<String> colNames, List values){
        
        int updates = 0;
        PreparedStatement pstmt = null;
        
        try{
            
            StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
            for(int i = 0; i < colNames.size(); i++){
                sql.append("" + colNames.get(i) + ", ");
            }
            sql = new StringBuilder(sql.toString().substring(0, sql.lastIndexOf(", ")) + ") VALUES (");
            for(int i = 0; i < values.size(); i++){
                sql.append("'" + values.get(i).toString() + "', ");
            }
            
            String finalSQL = sql.toString().substring(0, sql.lastIndexOf(", ")) + ");";
            
//            System.out.println(finalSQL);
            pstmt = conn.prepareStatement(finalSQL);
            updates = pstmt.executeUpdate();
     
            pstmt.close();
            closeConnection();
            
        }catch(SQLException sqle){
            System.out.println("SQL Exception for insertRecord.");
        }
        return updates;

    }
    
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        DBAccess db = new DBMySQLStrategy();
//        db.openConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/hotel","root","admin");
//        
//        List<String> colNames = new ArrayList<>();
//        List values = new ArrayList();
//        
//        colNames.add("hotel_name");
//        colNames.add("street_address");
//        colNames.add("city");
//        colNames.add("state");
//        colNames.add("postal_code");
//        colNames.add("notes");
//        
//        values.add("TacoLand");
//        values.add("535 Taco Way");
//        values.add("Las Vegas");
//        values.add("Nevada");
//        values.add("57335");
//        values.add("A place for tacos and taco lovers.");
//        
//        db.insertRecord("hotel", colNames, values);
//        db.openConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/hotel","root","admin");
//        
//        List<Map<String, Object>> hotels = db.findAllRecords("hotel");
//        for(Map m : hotels){
//            System.out.println(m);
//        }
//        
//        db.openConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/hotel","root","admin");
//        db.deleteRecords("hotel", "hotel_id", 3);
//        
//        db.openConnection("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/hotel","root","admin");
//        hotels = db.findAllRecords("hotel");
//        for(Map m : hotels){
//            System.out.println(m);
//        }
//        
//    }
    
}
