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

import usa.sergio.arboleda.ciclo32.entity.Reservation;
import usa.sergio.arboleda.ciclo32.services.ReservationServices;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationRestController {
	
	@Autowired
	private ReservationServices reservationServices;
	
	@GetMapping("/all")
	public List<Reservation> index() {
		return reservationServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Reservation> show(@PathVariable Integer idReservation) {
		return reservationServices.findbyId(idReservation);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation create(@RequestBody Reservation reservation) {	
		return reservationServices.saveCategory(reservation);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idReservation) {
		reservationServices.deleteCategory(idReservation);
	}

}
