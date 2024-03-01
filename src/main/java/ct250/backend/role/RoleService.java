package ct250.backend.role;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public ArrayList<Role> findAll() {
//        return (ArrayList<Role>) this.roleRepository.findAll();
//    }

    public List<RoleDTO> findAll() {
        List<Role> roles = this.roleRepository.findAll();
        return roles.stream().map(RoleDTO::new).collect(Collectors.toList());
    }

//    public Role findById(Long id) {
//        return this.roleRepository.findById(id).orElse(null);
//    }

    public RoleDTO findById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        if (role != null) {
            Hibernate.initialize(role.getPrivileges()); // Eagerly fetch roles
            return modelMapper.map(role, RoleDTO.class);
        }
        return null;
    }

    public Role findByName(String name) {
        return this.roleRepository.findByName(name).orElse(null);
    }

    public void add(Role role) {
        if (this.findById(role.getId()) == null) {
            this.roleRepository.save(role);
        }
    }

    public void deleteById(Long id) {
        this.roleRepository.deleteById(id);
    }
}
