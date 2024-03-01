package ct250.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/", ""})
//    public ArrayList<User> getAllUsers() {
//        return this.userService.findAll();
//    }

    public List<UserDTO> getAllUsers() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
//    public ResponseEntity<?> getUserById(@PathVariable Long id) {
//        User user = this.userService.findById(id);
//        if (user == null) {
//            return new ResponseEntity<>("This user is not exist", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user, HttpStatus.FOUND);
//    }

    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        if (userDTO == null) {
            return new ResponseEntity<>("This user is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        User isExistedUser = this.userService.findByAccount(user.getAccount());
        if (isExistedUser == null) {
            this.userService.add(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The user with account=" + user.getAccount() + " existed. Try again!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        UserDTO userDTO = this.userService.findById(id);
        if (userDTO == null) {
            return new ResponseEntity<>("This user is not exist", HttpStatus.NOT_FOUND);
        }
        this.userService.deleteById(id);
        return new ResponseEntity<>("A user with id=" + id + " is deleted successfully", HttpStatus.OK);
    }
}
