package ct250.backend.product;

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
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", ""})
    public ArrayList<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = this.productService.findProductById(id);
        if (product == null) {
            return new ResponseEntity<>("This product is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        Product product = this.productService.findProductById(id);
        if (product == null) {
            return new ResponseEntity<>("Can not find product to delete", HttpStatus.NOT_FOUND);
        }
        
        this.productService.deleteProductById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
    
    @GetMapping(value = "/{productId}/details")
    public ArrayList<ProductDetail> getAllProductDetails(@PathVariable Long productId) {
        return this.productService.getAllProductDetails(productId); 
    }

    @GetMapping(value = "/{productId}/details/{id}")
    public ResponseEntity<?> getProductDetailById(@PathVariable Long id) {
        ProductDetail productDetail = this.productService.findProductDetailById(id);
        if (productDetail == null) {
            return new ResponseEntity<>("This product detail is not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDetail, HttpStatus.OK);
    }

    @PostMapping(value = "/{productId}/details")
    public ResponseEntity<ProductDetail> addProductDetail(@PathVariable Long productId, @RequestBody ProductDetail productDetail) {
        this.productService.addProductDetail(productId, productDetail);
        return new ResponseEntity<>(productDetail, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}/details/{id}")
    public ResponseEntity<String> deleteProductDetailById(@PathVariable Long id) {
        ProductDetail productDetail = this.productService.findProductDetailById(id);
        if (productDetail == null) {
            return new ResponseEntity<>("Can not find product detail to delete", HttpStatus.NOT_FOUND);
        }
        
        this.productService.deleteProductDetailById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
