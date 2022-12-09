package vehicleparkingmanagementsystem.parkinghouse.parkingseat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <<Description Here>>
 * @author SantoshKalathoki
 * @version 
 * @since , Nov 14, 2022
 */

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/api/seat")
public class SeatController {

  @Autowired
  private SeatService seatService;
 
  @PostMapping
  @ResponseStatus(code = HttpStatus.OK)
  public SeatResponseDto addSeat(@RequestBody SeatCreateDto request) {
    return seatService.addSeat(request);
  }
  
  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public SeatResponseDto get(@PathVariable Long id) {
    return seatService.getSeatById(id);
  }
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public SeatResponseListDto getAll() {
    return seatService.getAll();
  }
  
  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public Seat Update(@PathVariable Long id, @RequestBody SeatUpdateDto request) {
    return seatService.update(id, request);
  }
  
}
