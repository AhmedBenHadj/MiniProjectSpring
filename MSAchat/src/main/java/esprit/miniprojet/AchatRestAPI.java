package esprit.miniprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/achats")
public class AchatRestAPI {
	@Autowired
	private AchatService achatService;
	
	@PostMapping(value = "/{idUser}/{idProduct}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Achat> CreateAchat(@PathVariable(value = "idUser") int idUser,@PathVariable(value = "idProduct") int idProduct){
		return new ResponseEntity<Achat>(achatService.AddAchat(idUser,idProduct), HttpStatus.CREATED);
	}
}
