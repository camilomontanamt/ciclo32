package usa.sergio.arboleda.ciclo32.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo32.dao.ICategoryDao;
import usa.sergio.arboleda.ciclo32.entity.Category;

@Service
public class CategoryServices {

	@Autowired
	private ICategoryDao categoryDao;

	public CategoryServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Category> findAll() {
		return (List<Category>) categoryDao.findAll();
	}

	@Transactional
	public Optional<Category> findbyId(Integer id) {
		return categoryDao.findById(id);
	}

	@Transactional
	public Category saveCategory(Category category) {
		if (category.getId() == null) {
			return categoryDao.save(category);			
		} else {
			Optional<Category> paux = findbyId(category.getId());
			if (paux.isEmpty()) {
				return categoryDao.save(category);
			} else {
				return category;
			}
		}
	}

	@Transactional
	public void deleteCategory(Integer id) {
		categoryDao.deleteById(id);
	}

}
