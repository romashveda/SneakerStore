package ua.home.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.home.entity.Sex;

public interface SexDAO extends JpaRepository<Sex,Integer>{

//    @Query("from Sex s where s.sexName=:sex")
//    public Sex findByName(@Param("sex")String sex);
}
