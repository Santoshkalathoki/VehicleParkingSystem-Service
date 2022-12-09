
package vehicleparkingmanagementsystem.parkinghouse.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <<Description Here>>
 * 
 * @author SantoshKalathoki
 * @version
 * @since , Nov 14, 2022
 */

@Service
//@Slf4j
public class UserService {
  @Autowired
  public UserRepository userRepository;

  public UserResponseDto addUser(UserCreateDto request) {
    String originalPassword = request.getPassword();
    String encryptedPassword = BCrypt.hashpw(originalPassword, BCrypt.gensalt());
//
//    log.info("Original Password {}", originalPassword);
//    log.info("Encrypted Password {}", encryptedPassword);


    User user = new User();
    user.setFName(request.getFName());
    user.setPassword(encryptedPassword);
    user.setEmail(request.getEmail());
    user.setContactNumber(request.getContactNumber());
    user.setVehicleNumber(request.getVehicleNumber());

    User savedUser = userRepository.save(user);
    return getUserResponseDto(savedUser);
  }

  private UserResponseDto getUserResponseDto(User savedUser) {
    UserResponseDto response = new UserResponseDto();
    response.setId(savedUser.getId());
    response.setFName(savedUser.getFName());
    response.setPassword(savedUser.getPassword());
    response.setEmail(savedUser.getEmail());
    response.setContactNumber(savedUser.getContactNumber());
    response.setVehicleNumber(savedUser.getVehicleNumber());

    return response;

  }


  public UserResponseListDto getAll() {
    List<UserResponseDto> userResponseList = new ArrayList<>();
    List<User> users = (List<User>) userRepository.findAll();

    for (User user : users) {
      userResponseList.add(getUserResponseDto(user));
    }
    UserResponseListDto response = new UserResponseListDto();
    response.setUsers(userResponseList);
    response.setTotal(userResponseList.size());
    return response;
  }


  public UserResponseDto getById(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      return getUserResponseDto(optionalUser.get());
    }
    return null;
  }

  public User update(Long id, UserUpdateDto request) {
    Optional<User> optional = userRepository.findById(id);
    if (optional.isPresent()) {
      User user = optional.get();
      user.setFName(request.getFName());
      user.setPassword(request.getPassword());
      user.setEmail(request.getEmail());
      user.setContactNumber(request.getContactNumber());
      user.setVehicleNumber(request.getVehicleNumber());

      return userRepository.save(user);
    }
    return null;
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  public LoginResponseDto login(LoginRequestDto request) {
    
    LoginResponseDto response = new LoginResponseDto();
    
    User user = userRepository.findByEmail(request.getEmail());

    if (user == null) {
      throw  new RuntimeException("User does not exist. Please register first.");
    }
      
    boolean checkpw = BCrypt.checkpw(request.getPassword(), user.getPassword());
    if (!checkpw)
      throw new RuntimeException( "Invalid password. Please type your correct password.");

    user.setLoggedIn(true);
    userRepository.save(user);

    response.setUserId(user.getId());
    response.setEmail(user.getEmail());
    
    response.setName(user.getFName());
    
    return response;
    
    
  }

  public LogoutResponse logout(LogoutRequestDto request) {
    User user = userRepository.findByEmail(request.getEmail());

    LogoutResponse response = new LogoutResponse();
    
    if (user == null) {
      response.setMessage( "User does not exist. Please register first.");
      return response;
    }

    user.setLoggedIn(false);
    userRepository.save(user);

    return response;
  }

}
