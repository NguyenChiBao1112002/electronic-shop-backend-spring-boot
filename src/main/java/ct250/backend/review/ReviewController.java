package ct250.backend.review;

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
@RequestMapping("/products/{productId}/reviews")
public class ReviewController {
    
    @Autowired
    ReviewService ReviewService;

    @GetMapping(value = {"/", ""})
    public ResponseEntity<ArrayList<Review>> getAllReviewsByProductId(@PathVariable Long productId) {
        ArrayList<Review> reviews = this.ReviewService.getAllReviewsByProductId(productId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        Review review = this.ReviewService.findReviewById(id);
        if (review == null) {
            return new ResponseEntity<>("This review is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
    
    @PostMapping(value = "/order-details/{orderDetailId}")
    public ResponseEntity<Review> addReview(@PathVariable Long orderDetailId,
                                            @RequestBody Review review) {
        this.ReviewService.addReview(orderDetailId, review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long id) {
        Review Review = this.ReviewService.findReviewById(id);
        if (Review == null) {
            return new ResponseEntity<>("Can not find review to delete", HttpStatus.NOT_FOUND);
        }
        
        this.ReviewService.deleteReviewById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

}
