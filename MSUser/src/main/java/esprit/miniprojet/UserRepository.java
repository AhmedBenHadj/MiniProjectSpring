package esprit.miniprojet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.nom like :nom")
	public Page<User> GetUserByNomFromDB(@Param("nom")String nom, Pageable pageable);
	@Query("select u from User u where u.email like :email")
	public Page<User> GetUserByEmailFromDB(@Param("email")String email, Pageable pageable);
}
