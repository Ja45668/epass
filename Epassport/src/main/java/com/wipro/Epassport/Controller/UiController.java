package com.wipro.Epassport.Controller;

import com.wipro.Epassport.Entity.Epassport;
import com.wipro.Epassport.Exception.UserAlreadyExistException;
import com.wipro.Epassport.Service.EpassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UiController {
    @Autowired
    private EpassportService service;
    @GetMapping("/registration_form")
    public String showRegistrationForm(Model model)
    {
        Epassport epassport = new Epassport();
        model.addAttribute("epassport",epassport);
        return "EpassportRegistrationForm";
    }
    @PostMapping("/save")
    public String saveEpassport(@ModelAttribute("epassport") Epassport registrationDto, Model model)
    {
        try{
            service.save(registrationDto);
            return "redirect:/registration_form?success";
        }
        catch(UserAlreadyExistException e)
        {
            model.addAttribute("errorMessage",e.getMessage());
            return "EpassportRegistrationForm";
        }
    }
    @GetMapping("/Signup")
    public String showSignupForm(Model model)
    {
        Epassport epassport = new Epassport();
        model.addAttribute("epassport",epassport);
        return "index";
    }
}
