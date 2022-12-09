package vehicleparkingmanagementsystem.parkinghouse.parkingseat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "Seat")
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  public Long seat;
  public Long availableSeat;

}
