package ct250.backend.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/{customerId}/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<ArrayList<Order>> getAllOrders(@PathVariable Long customerId) {
        return new ResponseEntity<>(this.orderService.findAllOrders(customerId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<OrderDetail>> getAllOrderDetails(@PathVariable Long id) {
        return new ResponseEntity<>(this.orderService.findAllOrderDetailsByOrder(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Order> addOrder(@PathVariable Long customerId, @RequestBody Order order) {
        this.orderService.addOrder(customerId, order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        Order order = this.orderService.findOrderById(id);
        if (order == null) {
            return new ResponseEntity<>("Can not find order to cancel", HttpStatus.NOT_FOUND);
        }
        
        this.orderService.cancelOrder(id);
        return new ResponseEntity<>("Canceled successfully", HttpStatus.OK);
    }

    @PostMapping("/{orderId}")
    public ResponseEntity<ArrayList<OrderDetail>> addOrderDetailsToOrder(
        @PathVariable Long orderId, @RequestBody Long[] cartDetailsList) {
        return new ResponseEntity<>(this.orderService.addOrderDetailsToOrder(orderId, cartDetailsList),
                                    HttpStatus.CREATED);
    }
    
}
