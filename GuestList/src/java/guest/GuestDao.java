/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fhcmartins
 */
public class GuestDao {
    private List<Guest> guests;

    public GuestDao() {
        guests = new ArrayList<Guest>();
    }
    
    public void persist(Guest guest){
        guests.add(guest);
    }
    
    public List<Guest> getAllGuests(){
        return guests;
    }
    
}
