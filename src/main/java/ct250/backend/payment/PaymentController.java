package ct250.backend.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping({ "/", "" })
    public ResponseEntity<?> getAllPayment() {
        return new ResponseEntity<>(this.paymentService.findAllPayments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable Long id) {
        Payment payment = this.paymentService.findPaymentById(id);
        if (payment == null) {
            return new ResponseEntity<>("This payment is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(payment, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaymentById(@PathVariable Long id) {
        Payment payment = this.paymentService.findPaymentById(id);
        if (payment == null) {
            return new ResponseEntity<>("This payment is not exist", HttpStatus.NOT_FOUND);
        }

        this.paymentService.deletePayment(id);
        return new ResponseEntity<>("A payment with id=" + id + " is deleted successfully", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePaymentById(@PathVariable Long id, @RequestBody Payment payment) {
        if (this.paymentService.updatePayment(id, payment) != null) {
            return new ResponseEntity<>("A payment with id=" + id + " is updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("The payment with id=" + payment.getId() + " fail updated. Try again!",
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/")
    public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
        Payment isExistedPayment = this.paymentService.findPaymentById(payment.getId());
        if (isExistedPayment == null) {
            this.paymentService.addPayment(payment);
            return new ResponseEntity<>(payment, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The payment with id=" + payment.getId() + " existed. Try again!",
                HttpStatus.BAD_REQUEST);
    }
}
