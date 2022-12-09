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
package vehicleparkingmanagementsystem.parkinghouse.user;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <<Description Here>>
 * @author SantoshKalathoki
 * @version 
 * @since , Nov 14, 2022
 */
@Getter
@Setter
public class UserResponseListDto {

  private List<UserResponseDto> users;
  private int total;
  
}
