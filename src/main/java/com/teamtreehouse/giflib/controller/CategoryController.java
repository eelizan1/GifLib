package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.CategoryRepository;
import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Category;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GifRepository gifRepository;

    // "/categories" - returns list of categories
    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        // return index.html home page
        List<Category> categoryList = categoryRepository.getAllCategories();
        // add category list to the model map
        modelMap.put("categoryList", categoryList);
        return "categories";
    }

    // get single category
    @RequestMapping(path = "/category/{id}", method = RequestMethod.GET)
    public String categoryDetails(@PathVariable("id") int id, ModelMap modelMap) {
        Category category = categoryRepository.findCategoryByid(id);
        // add category object to the model map
        modelMap.put("category", category);
        System.out.println(category.getName());

        // get all gif associated with this category
        List<Gif> gifList = gifRepository.getGifsByCategory(id);
        // add category object to the model map
        modelMap.put("gifList", gifList);
        for(Gif gif: gifList)
            System.out.println(gif.getName());
        // return gif-details.html
        return "category";
    }
}
