/*************************************************************************
 * 
 * AADIM INNOVATION CONFIDENTIAL
 * __________________                                                                                          
 *
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained here in is, and remains
 * the property of Aadim Innovation and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * here in are proprietary to Aadim Innovation. Dissemination of this
 * information or reproduction of this material is strictly forbidden unless
 * prior written permission is obtained from Aadim Innovation.
 * 
 */
package vehicleparkingmanagementsystem.parkinghouse.booking;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <<Description Here>>
 * @author SantoshKalathoki
 * @version 
 * @since , Nov 21, 2022
 */
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long>{

}
