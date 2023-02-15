import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

public class Practica1 {
    
    private static Scanner reader;
    
    private static void handleAction(int action) {
	if (action == 1) {
	    createCategoryAction();
	} else if (action == 2) {
	    getCategoryListAction();
	} else if (action == 3) {
	    findCategoryAction();
	} else if (action == 4) {
	    removeCategoryAction();
	} else {
	    use();
	}
    }
    
    private static void createCategoryAction() {
	Scanner scan  = new Scanner(System.in);
	
	System.out.println("Ingrese el id.");
	Integer categoryId = scan.nextInt();

	scan = new Scanner(System.in);
	
	System.out.println("Ingrese la categoria.");
	String category = scan.nextLine();
	
	System.out.println("Ingrese el acronimo.");
	String acronym = scan.nextLine();
	
	try {
	    Category.createCategory(new Category(categoryId, category, acronym));
	} catch (IllegalArgumentException iae) {
	    System.out.println("El id de la categoria ingresado ya existe.");
	}
    }

    private static void getCategoryListAction() {
	if (Category.listIsEmpty()) 
	    System.out.println("No existen categorias registradas.");
	else System.out.println(Category.getCategories());
    }

    private static void findCategoryAction() {
	System.out.println("Ingrese el id de la categoria a buscar.");
	Integer categoryId = reader.nextInt();

	try {
	    Category category = Category.getCategory(categoryId);
	    System.out.println(category.toString());
	} catch (NoSuchElementException nsee) {
	    System.out.println("No existe una categoria con el id ingresado.");
	} 
    }

    private static void removeCategoryAction() {
	System.out.println("Ingrese el id de la categoria a eliminar.");
	Integer categoryId = reader.nextInt();

	try {
	    Category.deleteCategory(categoryId);
	} catch (NoSuchElementException nsee) {
	    System.out.println("No existe una categoria con el id ingresado.");
	}
    }
    
    private static void showInstructions() {
	String s1 = "Ingrese 1 si desea crear alguna categoria.\n";
	String s2 = "Ingrese 2 si desea ver la lista de categorias existentes.\n";
	String s3 = "Ingrese 3 si desea consular alguna categoria.\n";
	String s4 = "Ingrese 4 si desea eliminar alguna categoria.\n";
	
	System.out.println(s1 + s2 + s3 + s4);
    }

    private static void use() {
	System.out.println("Ingrese una opcion valida.");
    }
    
    public static void main(String[] args) {
	reader = new Scanner(System.in);
	showInstructions();
	while (true) {
	    handleAction(reader.nextInt());
	}
    }   
}
