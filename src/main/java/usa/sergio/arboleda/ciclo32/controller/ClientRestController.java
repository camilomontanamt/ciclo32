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

import usa.sergio.arboleda.ciclo32.entity.Client;
import usa.sergio.arboleda.ciclo32.services.ClientServices;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientRestController {
	
	@Autowired
	private ClientServices clientServices;

	@GetMapping("/all")
	public List<Client> index() {
		return clientServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Client> show(@PathVariable Integer idClient) {
		return clientServices.findbyId(idClient);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Client create(@RequestBody Client client) {	
		return clientServices.saveClient(client);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idClient) {
		clientServices.deleteClient(idClient);
	}
}
