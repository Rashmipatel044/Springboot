package com.formvalidation.form_validation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.formvalidation.form_validation.entities.login_Data;

import jakarta.validation.Valid;

@Controller
public class Mycontroller {
    @GetMapping("/form")
    public String openForm(Model model){
        System.out.println("Opening form");
        model.addAttribute("login_Data",new login_Data());
        return "form";
    }

    //Handler for processing form

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("login_Data")login_Data loginData,BindingResult result){

        if(result.hasErrors()){
            System.out.println(result);
            return "form";
        }
        System.out.println(loginData);
        return "sucess";
    }
}
