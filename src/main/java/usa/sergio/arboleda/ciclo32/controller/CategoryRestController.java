package usa.sergio.arboleda.ciclo32.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import usa.sergio.arboleda.ciclo32.entity.Category;
import usa.sergio.arboleda.ciclo32.services.CategoryServices;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryRestController {

	@Autowired
	private CategoryServices categoryService;
	
	@GetMapping("/all")
	public List<Category> index() {
		return categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Category> show(@PathVariable Integer id) {
		return categoryService.findbyId(id);
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Category create(@RequestBody Category category) {	
		return categoryService.saveCategory(category);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
	}

}
