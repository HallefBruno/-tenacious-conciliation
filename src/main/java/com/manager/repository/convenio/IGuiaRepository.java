
package com.manager.repository.convenio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.convenio.Guia;

@Repository
public interface IGuiaRepository extends JpaRepository<Guia, Long> {
    public List<Guia> findByNgPrestOrderByDataPagamentoAsc(String n);
}
