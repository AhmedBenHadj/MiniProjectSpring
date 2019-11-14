package esprit.miniprojet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EvenementRepository extends JpaRepository<Evenement, Integer>{
	@Query("select e from Evenement e where e.nom like :nom")
	public Page<Evenement> GetEvenementByNomFromDB(@Param("nom")String nom, Pageable pageable);
}
