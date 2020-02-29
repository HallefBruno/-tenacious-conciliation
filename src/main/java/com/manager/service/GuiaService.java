package com.manager.service;

import com.manager.entity.Guia;
import com.manager.repository.IGuiaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuiaService {

    @Autowired
    private IGuiaRepository guiaRepository;

    @Transactional
    public List<Guia> save(List<Guia> guias) {
        return guiaRepository.saveAll(guias);
    }

}
