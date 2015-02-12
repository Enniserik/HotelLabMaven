package hotel_web_model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eennis
 */
public class HotelDAOStrategy implements HotelDAO {
    
    private DBAccess dba;
//    private String driver;
//    private String url;
//    private String username;
//    private String password;
    
    public HotelDAOStrategy(){
        dba = new DBMySQLStrategy();
//        driver = HotelDataAccessFactory.getDriver();
//        url = HotelDataAccessFactory.getUrl();
//        username = HotelDataAccessFactory.getUsername();
//        password = HotelDataAccessFactory.getPassword();
    }
    
    @Override
    public List<Hotel> findAllHotels() {
        
//        dba.openConnection(driver, url, username, password);
        dba.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotel", "root", "admin");
        List<Map<String, Object>> records = dba.findAllRecords("hotel");
        List<Hotel> hotels = new ArrayList<>();
        Hotel h = null;
        for(Map m : records){
            h = new Hotel();
            h.setHotelId(Integer.valueOf(m.get("hotel_id").toString()));
            h.setHotelName(m.get("hotel_name").toString());
            h.setAddress(m.get("street_address").toString());
            h.setCity(m.get("city").toString());
            h.setState(m.get("state").toString());
            h.setPostalCode(m.get("postal_code").toString());
            String s = "";
            try{
                s = m.get("notes").toString();
            }catch(NullPointerException npe){
                s = "";
            }
            h.setNotes(s);
            hotels.add(h);
        }
        return hotels;
    }
    
    @Override
    public int updateHotelRecord(int pk, String col, String value) {
        
//        dba.openConnection(driver, url, username, password);
        dba.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotel", "root", "admin");
        int updates = dba.updateRecord("hotel", "hotel_id", pk, col, value);
    
        return updates;
        
    }
    
    @Override
    public int insertHotelRecord(List<String> colNames, List values) {
        
//        dba.openConnection(driver, url, username, password);
        dba.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotel", "root", "admin");
        int updates = dba.insertRecord("hotel", colNames, values);
        
        return updates;
        
    }
    
    @Override
    public int deleteHotelRecord(int pk) {
        
//        dba.openConnection(driver, url, username, password);
        dba.openConnection("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/hotel", "root", "admin");
        int updates = dba.deleteRecord("hotel", "hotel_id", pk);
        
        return updates;
        
    }
    
    
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        HotelDAO db = new HotelDAOStrategy();
//        List<Hotel> hotels = db.findAllHotels();
//        for(Hotel h : hotels){
//            System.out.println(h);
//        }
//    }
    
}
