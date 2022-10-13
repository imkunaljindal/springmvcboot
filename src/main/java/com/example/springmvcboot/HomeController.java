package com.example.springmvcboot;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvcboot.model.Alien;

@Controller
public class HomeController {
    
    @ModelAttribute
    public void modelData(Model m)
    {
        m.addAttribute("name","Aliens");
    }
    
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    
    // @RequestMapping("add")
    // public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m)
    // {
    //     // ModelAndView mv = new ModelAndView();
    //     // mv.setViewName("result");
    //     int num3 = i+j;
        
    //     // mv.addObject("num3", num3);
    //     m.addAttribute("num3", num3);

    //     return "result";
    // }


    @GetMapping("getAliens")
    public String getAliens(Model m)
    {
        List<Alien> aliens = Arrays.asList(new Alien(101,"Kunal"), new Alien(102,"Jindal"));
        m.addAttribute("result",aliens);
        return "showAliens";
    }
    
    @RequestMapping(value="addAlien",method=RequestMethod.POST)
    public String addAlien(@ModelAttribute("a1") Alien a)
    {
        // Alien a = new Alien();
        // a.setAid(aid);
        // a.setAname(aname);

       // m.addAttribute("alien", a);
        return "result";
    }
}
