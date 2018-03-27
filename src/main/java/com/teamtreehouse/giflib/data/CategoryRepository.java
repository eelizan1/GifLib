package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1, "Tech"),
            new Category(2, "People"),
            new Category(3, "Destruction")
    );

    // find category by id
    public Category findCategoryByid(int id) {
        for(Category category : ALL_CATEGORIES) {
            if(id == category.getId()) {
                return category;
            }
        }
        return null;
    }

    // get all categories
    // return all the Gif objects
    public List<Category> getAllCategories() {
        return ALL_CATEGORIES;
    }
}
