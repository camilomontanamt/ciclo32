package usa.sergio.arboleda.ciclo32.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import usa.sergio.arboleda.ciclo32.entity.Quadbike;
import usa.sergio.arboleda.ciclo32.services.QuadbikeServices;

@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class QuadbikeRestController {

	@Autowired
	private QuadbikeServices quadbikeService;
	
	public QuadbikeRestController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/all")
	public List<Quadbike> index() {
		return quadbikeService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Quadbike> show(@PathVariable Integer id) {
		return quadbikeService.findbyId(id);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Quadbike create(@RequestBody Quadbike quadbike) {
		return quadbikeService.saveQuadbike(quadbike);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id){
		quadbikeService.deleteQuadbike(id);
	}
}
