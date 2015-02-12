package hotel_web_model;

/**
 *
 * @author eennis
 */
public class Hotel {
    
    private int hotelId;
    private String hotelName;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String notes;

    public Hotel() {
    }

    public Hotel(int hotelId, String hotelName, String address, String city, String state, String postalCode, String notes) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.notes = notes;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.hotelId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (this.hotelId != other.hotelId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotelId=" + hotelId + ", hotelName=" + hotelName + ", address=" + address + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", notes=" + notes + '}';
    }
    
}
