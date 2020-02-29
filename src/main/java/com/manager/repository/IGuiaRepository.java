
package com.manager.repository;

import com.manager.entity.Guia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuiaRepository extends JpaRepository<Guia, Long>{
    
}
