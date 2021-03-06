package com.akhambir.controller;

import com.akhambir.model.Category;
import com.akhambir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.Collections;
import java.util.List;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ModelAndView test(@ModelAttribute Category category, ModelAndView mw) {
        Category result = categoryService.increaseProductsPriceBy10P(category)
                .orElseGet(Category::new);

        mw.addObject("category", result);
        mw.setViewName("edit-category");
        return mw;
    }

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
        //TODO rewrite, bad practice
        Category result = categoryService.getByIdWithProducts(id)
                .orElseGet(Category::new);

        mw.addObject("category", result);
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

    @ResponseBody
    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllAsJson() {
        return categoryService.getAll()
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @ResponseBody
    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return categoryService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @ResponseBody
    @RequestMapping(value = "/api/category", method = RequestMethod.POST)
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return categoryService.create(category)
                .map(c -> ResponseEntity.created(toUri(c.getId())).body(c))
                .orElseGet(ResponseEntity.status(HttpStatus.CONFLICT)::build);
    }

    @ResponseBody
    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return categoryService.update(category)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.CONFLICT)::build);
    }

    @ResponseBody
    @RequestMapping(value = "/api/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    private ModelAndView getAllCategoriesAndBindToMw() {
        List<Category> list = categoryService.getAll()
                .orElseGet(Collections::emptyList);

        ModelAndView mw = new ModelAndView();
        mw.addObject("categories", list);
        mw.setViewName("categories");
        return mw;
    }

    private URI toUri(Long id) {
        return URI.create(String.format("/api/ /%s", id));
    }
}
