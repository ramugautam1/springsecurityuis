package com.vastika.uis.controller;


import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user_form")
    public String getUserForm() {
        return "createUser";
    }

    @RequestMapping(value = "/user_save", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute User user, BindingResult result) {
        if(result.hasErrors()) {
        	return "createUser";
        }
    	userService.saveUser(user);
        return "redirect:/user_list";

    }


//-------------------------------------------------	


    @RequestMapping(value = "/user_edit")
    public String getUserEditForm(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @RequestMapping(value = "/user_update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User user, Model model) {
        userService.updateUser(user);
        return "redirect:/user_list";
    }
//-------------------------------------------------		


    @RequestMapping(value = "/user_delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/user_list";
    }

    //-------------------------------------------------
    @RequestMapping(value = {"/", "/user_list"}, method = RequestMethod.GET)
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "listUser";
    }
}
