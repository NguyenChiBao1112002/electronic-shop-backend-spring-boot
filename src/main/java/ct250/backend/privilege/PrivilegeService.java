package ct250.backend.privilege;

import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public ArrayList<Privilege> findAll() {
//        return (ArrayList<Privilege>) this.privilegeRepository.findAll();
//    }

    public List<PrivilegeDTO> findAll() {
        List<Privilege> privileges = this.privilegeRepository.findAll();
        return privileges.stream().map(PrivilegeDTO::new).collect(Collectors.toList());
    }

//    public Privilege findById(Long id) {
//        return this.privilegeRepository.findById(id).orElse(null);
//    }

    public PrivilegeDTO findById(Long id) {
        Privilege privilege = privilegeRepository.findById(id).orElse(null);
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        if (privilege != null) {
            Hibernate.initialize(privilege); // Eagerly fetch roles
            return modelMapper.map(privilege, PrivilegeDTO.class);
        }
        return null;
    }

    public Privilege findByName(String name) {
        return this.privilegeRepository.findByName(name).orElse(null);
    }

    public void add(Privilege role) {
        if (this.findById(role.getId()) == null) {
            this.privilegeRepository.save(role);
        }
    }

    public void deleteById(Long id) {
        this.privilegeRepository.deleteById(id);
    }
}
