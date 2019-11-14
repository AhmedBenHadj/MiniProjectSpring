package esprit.miniprojet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	@Query("select p from Product p where p.category like :category")
	public Page<Product> GetProductByCategoryFromDB(@Param("category") Category category, Pageable pageable);
	@Query("select p from Product p where p.reference like :reference")
	public Page<Product> GetProductByReferenceFromDB(@Param("reference") String reference,Pageable pageable);
	@Query("select p from Product p where p.prix <= :prix")
	public Page<Product> GetProductsByInferiorPriceFromDB(@Param("prix") float prix, Pageable pageable);
	@Query("select p from Product p where p.prix >= :prix")
	public Page<Product> GetProductsBySuperiorPriceFromDB(@Param("prix") float prix, Pageable pageable);
	@Query("select p from Product p where p.prix = :prix")
	public Page<Product> GetProductByEqualPriceFromDB(@Param("prix") float prix, Pageable pageable);
	@Query("select p from Product p where p.mark = :mark")
	public Page<Product> GetProductsByMarkFromEDB(@Param("mark")Mark mark,Pageable pageable);
}
