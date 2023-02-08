import java.util.LinkedList; 

public class Category {

    private Integer category_id;
    private String category;
    private String acronym;
    private static LinkedList<Categories> categories;
    

    public Category(Integer category_id, String category, String acronym) {
	this.category_id = category_id;
	this.category = category;
	this.acronym;
    }
    
    public static void createCategory(Category categ) {
       
    }

    public static String getCategories() {
	return categories.toString();
    }
    
    public static void getCategory(int category_id) {
	
    }
    
    public static void deleteCategory(int category_id) {
	
    }
    
}
