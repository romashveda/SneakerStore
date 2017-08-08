package ua.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.home.entity.Color;

public interface ColorDAO extends JpaRepository<Color,Integer>{
}
