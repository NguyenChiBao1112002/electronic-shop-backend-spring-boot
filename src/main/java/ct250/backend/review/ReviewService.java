package ct250.backend.review;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ct250.backend.customer.Customer;
import ct250.backend.order.OrderDetail;
import ct250.backend.order.OrderService;
import ct250.backend.product.ProductService;

@Service
public class ReviewService {
    
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    void addReview(Long orderDetailId, Review review) {
        OrderDetail orderDetail = this.orderService.findOrderDetailById(orderDetailId);
        review.setOrderDetail(orderDetail);
        Customer customer = orderDetail.getOrder().getCustomer();
        review.setCustomer(customer);
        this.reviewRepository.save(review);
    }

    ArrayList<Review> getAllReviews() {
        return (ArrayList<Review>) this.reviewRepository.findAll();
    }

    ArrayList<Review> getAllReviewsByProductId(Long productId) {
        return (ArrayList<Review>) this.reviewRepository.findByOrderDetail_ProductDetail_Product_Id(productId);
    }

    public Review findReviewById(Long id) {
        return  this.reviewRepository.findById(id).isPresent() ? 
                this.reviewRepository.findById(id).get() : null;
    }

    void deleteReviewById(Long id) {
        this.reviewRepository.deleteById(id);
    }

}
