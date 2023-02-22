package com.product;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

public class Category {
    
    private Integer category_id;
    private String category;
    private String acronym;
    private static LinkedList<Category> categories = new LinkedList<Category>();
    
    public Category(Integer category_id, String category, String acronym) {
		this.category_id = category_id;
		this.category = category;
		this.acronym = acronym;
    }
    
    public static void createCategory(Category newCategory) {
	for (Category category : categories)
	    if (category.category_id.intValue() == newCategory.category_id.intValue())
		throw new IllegalArgumentException();
	categories.addLast(newCategory);
    }

    public static LinkedList<Category> getCategories() {
	return categories;
    }

    public static boolean listIsEmpty() {
	return categories.size() == 0;
    }
    
    public static Category getCategory(int category_id) {
	for (Category category : categories) 
	    if (category.category_id == category_id)
		return category;
	throw new NoSuchElementException();
    }
    
    public static void deleteCategory(Integer category_id) {
	for (Category category : categories)
	    if (category.category_id.intValue() == category_id.intValue()) {
		categories.remove(category);
		return;
	    }
	throw new NoSuchElementException();
    }

    @Override public String toString() {
	return "{" + category_id + ", " + category + ", " + acronym +"}";
    }
}
