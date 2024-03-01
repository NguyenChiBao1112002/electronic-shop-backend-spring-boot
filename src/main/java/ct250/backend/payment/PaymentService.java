package ct250.backend.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.ArrayList;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public ArrayList<Payment> findAllPayments() {
        return (ArrayList<Payment>) this.paymentRepository.findAll();
    }

    public Payment findPaymentById(Long id) {
        return this.paymentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Payment addPayment(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @Transactional
    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = findPaymentById(id);
        if (existingPayment != null) {
            // Update fields based on your requirements
            existingPayment.setAmount(payment.getAmount());
            existingPayment.setStatus(payment.getStatus());
            // existingPayment.setDate(payment.getDate());
            existingPayment.setMethod(payment.getMethod());

            this.paymentRepository.save(existingPayment);
            return existingPayment;
        }
        return null;
    }

    @Transactional
    public boolean deletePayment(Long id) {
        Payment resultFindPayment = findPaymentById(id);
        if (resultFindPayment != null) {
            this.paymentRepository.delete(resultFindPayment);
            return true;
        } else {
            return false;
        }
    }
}
