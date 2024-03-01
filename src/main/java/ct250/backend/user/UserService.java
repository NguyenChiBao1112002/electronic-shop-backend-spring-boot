package ct250.backend.user;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public ArrayList<User> findAll() {
//        return users = this.userRepository.findAll();
//    }

    public List<UserDTO> findAll() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

//    public User findById(Long id) {
//        return this.userRepository.findById(id).orElse(null);
//    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        if (user != null) {
            Hibernate.initialize(user.getRoles()); // Eagerly fetch roles
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }

    public User findByAccount(String account) {
        return this.userRepository.findUserByAccount(account).orElse(null);
    }

    public void add(User user) {
        if (this.findById(user.getId()) == null) {
            this.userRepository.save(user);
        }
    }


    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
}
