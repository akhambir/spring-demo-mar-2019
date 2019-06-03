package com.akhambir.controller;

import com.akhambir.model.Category;
import com.akhambir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/add-category", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView mw) {
        mw.addObject("category", new Category());
        mw.setViewName("add-category");
        return mw;
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Category category, ModelAndView mw) {
        categoryService.create(category);
        List<Category> categories = categoryService.getAll()
                .orElseGet(Collections::emptyList);

        mw.addObject("categories", categories);
        mw.setViewName("categories");
        return mw;
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("c_id") Long id, ModelAndView mw) {
        mw.addObject("category", categoryService.getById(id));
        mw.setViewName("edit-category");
        return mw;
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Category category, ModelAndView mw) {
        categoryService.update(category);

        List<Category> categories = categoryService.getAll()
                .orElseGet(Collections::emptyList);

        mw.addObject("categories", categories);
        mw.setViewName("categories");
        return mw;
    }
}
