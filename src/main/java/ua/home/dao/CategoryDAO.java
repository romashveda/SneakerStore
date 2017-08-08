package ua.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.home.entity.Category;

public interface CategoryDAO extends JpaRepository<Category,Integer>{
}
