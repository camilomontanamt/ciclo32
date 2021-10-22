package usa.sergio.arboleda.ciclo32.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usa.sergio.arboleda.ciclo32.dao.IQuadbikeDao;
import usa.sergio.arboleda.ciclo32.entity.Quadbike;

@Service
public class QuadbikeServices {
	
	@Autowired
	private IQuadbikeDao quadbikeDao;

	public QuadbikeServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Quadbike> findAll() {
		return (List<Quadbike>) quadbikeDao.findAll();
	}
	
	@Transactional
	public Optional<Quadbike> findbyId(Integer id) {
		return quadbikeDao.findById(id);
	}
	
	@Transactional
	public Quadbike save(Quadbike quadbike) {
		if (quadbike.getId() == null) {
			return quadbikeDao.save(quadbike);			
		} else {
			Optional<Quadbike> paux = findbyId(quadbike.getId());
			if (paux.isEmpty()) {
				return quadbikeDao.save(quadbike);
			} else {
				return quadbike;
			}
		}
	}
	
	@Transactional
	public void delete(Integer id) {
		quadbikeDao.deleteById(id);
	}
}
