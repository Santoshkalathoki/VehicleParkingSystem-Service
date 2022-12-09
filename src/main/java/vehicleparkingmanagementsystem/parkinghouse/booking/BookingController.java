/*************************************************************************
 * 
 * AADIM INNOVATION CONFIDENTIAL __________________
 *
 * All Rights Reserved.
 * 
 * NOTICE: All information contained here in is, and remains the property of Aadim Innovation and
 * its suppliers, if any. The intellectual and technical concepts contained here in are proprietary
 * to Aadim Innovation. Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Aadim Innovation.
 * 
 */
package vehicleparkingmanagementsystem.parkinghouse.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <<Description Here>>
 * 
 * @author SantoshKalathoki
 * @version
 * @since , Nov 21, 2022
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @PostMapping
  public BookingResponseDto booking(@RequestBody BookingCreateDto request) {
    return bookingService.booking(request);
  } 
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public BookingResponseListDto getAll() {
    return bookingService.getAllBooking();
  }
  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public BookingResponseDto getById( @PathVariable Long id) {
    return bookingService.getById(id);
  }
}
