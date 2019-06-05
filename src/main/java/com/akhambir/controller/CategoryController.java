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
    public ModelAndView getAll() {

        return getAllCategoriesAndBindToMw();
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.GET)
    public ModelAndView create(ModelAndView mw) {
        mw.addObject("category", new Category());
        mw.setViewName("add-category");
        return mw;
    }

    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Category category) {
        categoryService.create(category);

        return getAllCategoriesAndBindToMw();
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("c_id") Long id, ModelAndView mw) {
        mw.addObject("category", categoryService.getById(id));
        mw.setViewName("edit-category");
        return mw;
    }

    @RequestMapping(value = "/edit-category", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute Category category) {
        categoryService.update(category);

        return getAllCategoriesAndBindToMw();
    }

    @RequestMapping(value = "/delete-category", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam("c_id") Long id, ModelAndView mw) {
        categoryService.delete(id);

        return getAllCategoriesAndBindToMw();



        /*return fetchAllCategories

        return bindModelAndView.apply(mw).andThen()

                .apply(categoryService.getAll()
                .orElseGet(Collections::emptyList))
                .apply(mw);*/
    }

    /*private Supplier<List<Category>> fetchAllCategories = () -> categoryService.getAll()
            .orElseGet(Collections::emptyList);

    private Function<ModelAndView, Function<List<Category>, ModelAndView>> bindModelAndView = l -> mw -> {
        mw.addObject("categories", l);
        mw.setViewName("categories");
        return mw;
    };*/

    private ModelAndView getAllCategoriesAndBindToMw() {
        List<Category> list = categoryService.getAll()
                .orElseGet(Collections::emptyList);

        ModelAndView mw = new ModelAndView();
        mw.addObject("categories", list);
        mw.setViewName("categories");
        return mw;
    }
}
