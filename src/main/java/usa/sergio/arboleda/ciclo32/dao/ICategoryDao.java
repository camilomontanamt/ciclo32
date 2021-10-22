package usa.sergio.arboleda.ciclo32.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import usa.sergio.arboleda.ciclo32.entity.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer>{

}
