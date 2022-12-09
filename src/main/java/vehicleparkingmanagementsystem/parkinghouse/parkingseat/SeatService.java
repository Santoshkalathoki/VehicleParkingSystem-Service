
package vehicleparkingmanagementsystem.parkinghouse.parkingseat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vehicleparkingmanagementsystem.parkinghouse.user.User;
import vehicleparkingmanagementsystem.parkinghouse.user.UserResponseDto;
import vehicleparkingmanagementsystem.parkinghouse.user.UserResponseListDto;

/**
 * <<Description Here>>
 * 
 * @author SantoshKalathoki
 * @version
 * @since , Nov 14, 2022
 */
@Service
public class SeatService {

  @Autowired
  private SeatRepository seatRepository;

  public SeatResponseDto addSeat(SeatCreateDto request) {
    Seat seat = new Seat();
    seat.setSeat(request.getSeat());
    seat.setAvailableSeat(request.getSeat());
    Seat savedSeat = seatRepository.save(seat);
    return getSeatResponseDto(savedSeat);
  }

  public SeatResponseDto getSeatById(Long id) {
    Optional<Seat> optionalSeat = seatRepository.findById(id);
    if (optionalSeat.isPresent()) {
      return getSeatResponseDto(optionalSeat.get());
    }
    return null;
  }

  private SeatResponseDto getSeatResponseDto(Seat savedSeat) {
    SeatResponseDto response = new SeatResponseDto();
    response.setId(savedSeat.getId());
    response.setSeat(savedSeat.getSeat());
    response.setAvailableSeat(savedSeat.getAvailableSeat());
    return response;
  }

  public Seat update(Long id, SeatUpdateDto request) {
    Optional<Seat> optional = seatRepository.findById(id);
    if (optional.isPresent()) {
      Seat seat = optional.get();
      seat.setSeat(request.getSeat());
      seat.setAvailableSeat(request.getSeat());
      return seatRepository.save(seat);
    }
    return null;
  }

  public SeatResponseListDto getAll() {
    List<SeatResponseDto> seatResponseList = new ArrayList<>();
    List<Seat> seats = (List<Seat>) seatRepository.findAll();

    for (Seat seat : seats) {
      seatResponseList.add(getSeatResponseDto(seat));
    }
    SeatResponseListDto response = new SeatResponseListDto();
    response.setSeats(seatResponseList);
    response.setTotal(seatResponseList.size());
    return response;
  }
}


