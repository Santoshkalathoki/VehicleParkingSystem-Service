package vehicleparkingmanagementsystem.parkinghouse.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <<Description Here>>
 * @author SantoshKalathoki
 * @version 
 * @since , Nov 14, 2022
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   *<<Add description here>>
   * @param email
   * @return
   * @author
   * @since , Modified In: @version, By @author
   */
  User findByEmail(String email);

}
