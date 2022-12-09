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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vehicleparkingmanagementsystem.parkinghouse.parkingseat.Seat;
import vehicleparkingmanagementsystem.parkinghouse.parkingseat.SeatRepository;
import vehicleparkingmanagementsystem.parkinghouse.user.User;
import vehicleparkingmanagementsystem.parkinghouse.user.UserResponseDto;

/**
 * <<Description Here>>
 * 
 * @author SantoshKalathoki
 * @version
 * @since , Nov 21, 2022
 */

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  @Autowired
  private SeatRepository seatRepository;

  public BookingResponseDto booking(BookingCreateDto request) {

    BookingResponseDto bookingResponseDto = new BookingResponseDto();


    Booking userBooking = new Booking();
    userBooking.setCreatedDateTime(LocalDateTime.now());
    userBooking.setSeat(request.getSeat());
    userBooking.setFName(request.getFName());
    userBooking.setEmail(request.getEmail());
    userBooking.setMobileNumber(request.getMobileNumber());
    userBooking.setVechileNumber(request.getVechileNumber());

    userBooking.setUserId(request.getUserId());
    Booking savedUserBooking = bookingRepository.save(userBooking);

    List<Seat> list = (List<Seat>) seatRepository.findAll();

    System.out.println("Seat " + list);


    if (list.get(0).availableSeat < 1)
      // throw new RuntimeException("Seat is unavailable. Contact admin.");
      System.out.println("Seat is unavailable. Contact admin.");
    Seat seat = list.get(0);

    if (seat.availableSeat > 0) {
      seat.setAvailableSeat(seat.availableSeat - 1);
      seatRepository.save(seat);

      // if (seat.availableSeat == 0) {
      // System.out.println("Seat Unavailabe");
      // }

      bookingResponseDto.setCreatedDateTime(userBooking.getCreatedDateTime());
      bookingResponseDto.setId(savedUserBooking.getId());
      bookingResponseDto.setSeat(savedUserBooking.getSeat());
      bookingResponseDto.setFName(savedUserBooking.getFName());
      bookingResponseDto.setEmail(savedUserBooking.getEmail());
      bookingResponseDto.setMobileNumber(savedUserBooking.getMobileNumber());
      bookingResponseDto.setVechileNumber(savedUserBooking.getVechileNumber());
      // bookingResponseDto.setUserId(savedUserBooking.getUserId());
      return bookingResponseDto;
    }



    // SeatResponseDto seatResponseDto = seatService.getSeatById(request.getSeatId());

    return null;


  }

  public BookingResponseListDto getAllBooking() {
    List<BookingResponseDto> userBookingList = new ArrayList<>();
    List<Booking> bookings = (List<Booking>) bookingRepository.findAll();

    for (Booking booking : bookings) {
      userBookingList.add(getBookingResponseDto(booking));
    }

    BookingResponseListDto responseBooking = new BookingResponseListDto();
    responseBooking.setBookings(userBookingList);
    responseBooking.setTotal((long) userBookingList.size());


    return responseBooking;
  }


  private BookingResponseDto getBookingResponseDto(Booking booking) {
    BookingResponseDto response = new BookingResponseDto();
    response.setCreatedDateTime(booking.getCreatedDateTime());
    response.setId(booking.getId());
    response.setUserId(booking.getUserId());
    response.setEmail(booking.getEmail());
    response.setFName(booking.getFName());
    response.setSeat(booking.getSeat());
    response.setMobileNumber(booking.getMobileNumber());
    response.setVechileNumber(booking.getVechileNumber());


    // if (booking.getSeat() != null) {
    // SeatResponseDto seatResponseDto = seatService.getSeatById(booking.getSeat());
    // response.setSeat(seatResponseDto);
    // }
    return response;
  }

  /**
   * <<Add description here>>
   * 
   * @param id
   * @return
   * @author
   * @since , Modified In: @version, By @author
   */
  public BookingResponseDto getById(Long id) {
    Optional<Booking> optionalUser = bookingRepository.findById(id);
    if (optionalUser.isPresent()) {
      return getBookingResponseDto(optionalUser.get());
    }
    return null;
  }

}
