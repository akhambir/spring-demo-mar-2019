package com.akhambir.controller;

import com.akhambir.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public ModelAndView paramExample(@RequestParam(required = false) String name, @RequestParam Integer age) {
        ModelAndView mw = new ModelAndView();
        mw.addObject("name", name);
        mw.addObject("age", age);
        mw.setViewName("params");
        return mw;
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public ModelAndView addUser(ModelAndView mw) {
        mw.addObject("user", new User());
        mw.setViewName("add-user");
        return mw;
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute User user) {
        //userService.addUser(user);
        System.out.println();
        return null;
    }
}
