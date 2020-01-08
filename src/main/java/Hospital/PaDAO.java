package Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaDAO extends JpaRepository<Patient, Integer>{

	
	
}
