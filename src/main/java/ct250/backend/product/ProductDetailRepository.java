package ct250.backend.product;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {

    ArrayList<ProductDetail> findByProduct_Id(Long productId);
    
}
