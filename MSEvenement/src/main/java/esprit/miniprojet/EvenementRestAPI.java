package esprit.miniprojet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evenements")
public class EvenementRestAPI {
	@Autowired
	private EvenementService evenementService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Evenement> CreateUser(@RequestBody Evenement evenement){
		return new ResponseEntity<Evenement>(evenementService.AddEvenement(evenement), HttpStatus.ACCEPTED);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Evenement> updateCandidat(@PathVariable(value = "id") int id, @RequestBody Evenement newEvenement){
		return new ResponseEntity<Evenement>(evenementService.UpdateEvenement(id, newEvenement), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
		return new ResponseEntity<String>(evenementService.DeleteEvenement(id), HttpStatus.OK);
	}
}
