package ct250.backend.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public ArrayList<Manager> findAll() {
        return (ArrayList<Manager>) managerRepository.findAll();
    }

    public Manager findById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    public void add(Manager manager) {
        this.managerRepository.save(manager);
    }


    public void deleteById(Long id) {
        this.managerRepository.deleteById(id);
    }
}
