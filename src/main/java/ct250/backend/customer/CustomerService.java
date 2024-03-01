package ct250.backend.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ArrayList<Customer> findAll() {
        return (ArrayList<Customer>) customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void add(Customer customer) {
        // if (this.findById(customer.getId()) == null) {
        //     this.customerRepository.save(customer);
        // }
        this.customerRepository.save(customer);
    }


    public void deleteById(Long id) {
        this.customerRepository.deleteById(id);
    }
}
