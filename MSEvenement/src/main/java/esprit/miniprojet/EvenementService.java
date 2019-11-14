package esprit.miniprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenementService {
	@Autowired
	private EvenementRepository evenementRepository;
	
	public Evenement AddEvenement(Evenement evenement){
		return evenementRepository.save(evenement);
	}
	
	public Evenement UpdateEvenement(int id,Evenement newEvenement) {
		if(evenementRepository.findById(id).isPresent()) {
			Evenement existingEvenement = evenementRepository.findById(id).get();
			existingEvenement.setDuration(newEvenement.getDuration());
			existingEvenement.setNom(existingEvenement.getNom());
			
			return evenementRepository.save(existingEvenement);
		}else {
			return null;
		}
	}
	
	public String DeleteEvenement(int id) {
		if (evenementRepository.findById(id).isPresent()) {
			evenementRepository.deleteById(id);
			return "User deleted";
		} else
			return "User not deleted, something happened";
	}
}
