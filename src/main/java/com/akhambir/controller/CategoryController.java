package com.akhambir.controller;

import com.akhambir.model.Category;
import com.akhambir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView mw) {
         List<Category> categories = categoryService.getAll()
                 .orElseGet(Collections::emptyList);

         mw.addObject("categories", categories);
         mw.setViewName("categories");
         return mw;
    }

}
