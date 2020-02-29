package com.manager.endpoint;

import com.manager.entity.Guia;
import com.manager.repository.IGuiaRepository;
import com.manager.service.GuiaService;
import com.manager.util.BuscarXmlGuia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("guia")
public class GuiaController {

    @Autowired
    private GuiaService guiaService;

    @Autowired
    private IGuiaRepository guiaRepository;

    @Autowired
    private BuscarXmlGuia buscarXmlGuia;

    @GetMapping("save")
    public List<Guia> save() {
        
        guiaRepository.findAll().forEach((item) -> {
            
        });
        
        return guiaRepository.findAll();
    }

}
