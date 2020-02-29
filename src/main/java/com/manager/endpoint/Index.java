
package com.manager.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
public class Index {
    
    
    //../arquivo/download?nome=glosamax_2019-06-04.xml&data=2019-06-04
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("Index");
        return mv;
    }
    
}
