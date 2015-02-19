package com.hotellab.model;

import java.util.List;

/**
 *
 * @author eennis
 */
public interface HotelDAO {

    public abstract List<Hotel> findAllHotels();
    public abstract int updateHotelRecord(int pk, String col, String value);
    public abstract int deleteHotelRecord(int pk);
    public abstract int insertHotelRecord(List<String> colNames, List values);
    
    
}
