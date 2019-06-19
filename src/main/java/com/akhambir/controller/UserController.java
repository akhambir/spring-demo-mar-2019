package com.akhambir.controller;

import com.akhambir.controller.external.model.UserRegistrationPayload;
import com.akhambir.model.User;
import com.akhambir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute User user, ModelAndView mw) {
        userService.add(user);
        List<User> users = userService.getAll()
                .orElseGet(Collections::emptyList);

        mw.addObject("users", users);
        mw.setViewName("users");
        return mw;
    }

    /*@RequestMapping(value = "/get-user", method = RequestMethod.GET)
    private ModelAndView getById(@RequestParam("u_id") Long id, ModelAndView mw) {
        mw.addObject("user", userService.getById(id));
        mw.setViewName("user");
        return mw;
    }*/

    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mw) {
        List<User> users = userService.getAll()
                .orElseGet(Collections::emptyList);

        mw.addObject("users", users);
        mw.setViewName("users");
        return mw;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView mw) {
        mw.addObject("user", new UserRegistrationPayload());
        mw.setViewName("register");
        return mw;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute UserRegistrationPayload urp, ModelAndView mw) {
        mw.addObject("user", userService.add(User.of(urp)));
        mw.setViewName("login");
        return mw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mw) {
        mw.addObject("user", new User());
        mw.setViewName("login");
        return mw;
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, ModelAndView mw) {
        mw.addObject("user", new User());
        mw.setViewName("login");
        return mw;
    }*/
}
