package vehicleparkingmanagementsystem.parkinghouse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/users")

public class UserController {
  
  @Autowired
  private UserService userService;
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public UserResponseDto addUser(@RequestBody UserCreateDto request) {
    return userService.addUser(request);
    
  }
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  public UserResponseListDto getAll() {
    return userService.getAll();
  }

  @GetMapping("/by-id/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public UserResponseDto getById(@PathVariable Long id) {
      return userService.getById(id);
  }
  
  @PutMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public User update(@PathVariable Long id, @RequestBody UserUpdateDto request) {
      return userService.update(id, request);
  }
  
  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public void deleteById(@PathVariable Long id) {
    userService.delete(id);
  }
  
  @PostMapping("/login")
  public LoginResponseDto login(@RequestBody LoginRequestDto request) {
      return userService.login(request);
  }
  
  @PostMapping("/logout")
  public LogoutResponse logout(@RequestBody LogoutRequestDto request) {
      return userService.logout(request);
  }
}
