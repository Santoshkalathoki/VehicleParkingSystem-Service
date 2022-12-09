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

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * <<Description Here>>
 * @author SantoshKalathoki
 * @version 
 * @since , Nov 21, 2022
 */
@Getter
@Setter
@Entity
public class Booking {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  private String fName;
  private String email;
//  private String password;
  private String mobileNumber;
  private String vechileNumber;
  private Long userId;
  private int seat;
  LocalDateTime createdDateTime = LocalDateTime.now();
}
