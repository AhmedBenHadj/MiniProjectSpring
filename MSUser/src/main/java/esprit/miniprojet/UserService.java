package esprit.miniprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User AddUser(User user){
		return userRepository.save(user);
	}
	
	public User UpdateUser(int id,User newUser) {
		if(userRepository.findById(id).isPresent()) {
			User existingUser = userRepository.findById(id).get();
			existingUser.setAdresse(newUser.getAdresse());
			existingUser.setEmail(newUser.getEmail());
			existingUser.setNom(newUser.getNom());
			existingUser.setPassword(newUser.getPassword());
			existingUser.setPrenom(newUser.getPrenom());
			
			return userRepository.save(existingUser);
		}else {
			return null;
		}
	}
	
	public String DeleteUser(int id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
			return "User deleted";
		} else
			return "User not deleted, something happened";
	}
}
