
package com.example.demo.dao;

import com.example.demo.entity.Bebidas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IBebidasDao extends JpaRepository<Bebidas, Long>{
    public Page<Bebidas> findAll(Pageable paginacion);
   
}
