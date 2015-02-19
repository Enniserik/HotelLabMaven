package com.hotellab.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eennis
 */
public class HotelService {
    
    private HotelDAO dao;
    
    public HotelService(String driver, String url, String username, String password){
        dao = new HotelDAOStrategy(driver, url, username, password);
    }
    
    public List<Hotel> retrieveAllHotels() {
        return dao.findAllHotels();
//        for(Hotel h : hotels){
//            System.out.println(h);
//        }
    }
    
    public void updateHotelRecord(int pk, String field, String value) {

        dao.updateHotelRecord(pk, field, value);
        System.out.println("Record Updated");
        
    }
    
    public void insertHotelRecord(String name, String address, String city, String state,
                                  String postal, String notes) {
        
        List<String> colNames = new ArrayList<>();
        List values = new ArrayList();
        
        colNames.add("hotel_name");
        colNames.add("street_address");
        colNames.add("city");
        colNames.add("state");
        colNames.add("postal_code");
        colNames.add("notes");
        
        values.add(name);
        values.add(address);
        values.add(city);
        values.add(state);
        values.add(postal);
        values.add(notes);
        
        dao.insertHotelRecord(colNames, values);
        
    }
    
    public void deleteHotelRecord(int pk) { 
    
        dao.deleteHotelRecord(pk);
        
    }
    
}
