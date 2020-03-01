package com.manager.endpoint;

import com.manager.entity.convenio.Guia;
import com.manager.repository.convenio.IGuiaRepository;
import com.manager.service.GuiaService;
import com.manager.service.HospitalService;
import com.manager.util.BuscarXmlGuia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("guia")
public class GuiaController {

    @Autowired
    private GuiaService guiaService;
    
    @Autowired 
    private HospitalService hospitalService;

    @Autowired
    private IGuiaRepository guiaRepository;

    @Autowired
    private BuscarXmlGuia buscarXmlGuia;
    
    @RequestMapping
    public ModelAndView init() {
    	ModelAndView mv = new ModelAndView("Conciliacao");
    	mv.addObject("listGuia", guiaRepository.findByNgPrestOrderByDataPagamentoAsc("43425029"));
    	mv.addObject("listGuiaHospital", hospitalService.hospitalGuia("43425029"));
    	return mv;
    }
    
    @GetMapping(value = "save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Guia> save() {
    	
    	//hospitalService.pesquisaFilipeta("43425029");
    	
        return guiaRepository.findAll();
    }

}
