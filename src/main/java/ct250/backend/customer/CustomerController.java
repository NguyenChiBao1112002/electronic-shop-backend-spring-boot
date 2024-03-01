package ct250.backend.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = {"/", ""})
    public ArrayList<Customer> getAllCustomers() {
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>("This customer is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        // Check if customer is exist or not?
        // Customer isExistedCustomer = customerService.findById(customer.getId());
        // if (isExistedCustomer == null) {
        //     this.customerService.add(customer);
        //     return new ResponseEntity<>(customer, HttpStatus.CREATED);
        // }
        // return new ResponseEntity<>("The customer with id=" + customer.getId() + " existed. Try again!", HttpStatus.BAD_REQUEST);
        this.customerService.add(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>("This customer is not exist", HttpStatus.NOT_FOUND);
        }
        this.customerService.deleteById(id);
        return new ResponseEntity<>("A customer with id=" + id + " is deleted successfully", HttpStatus.OK);
    }
}
