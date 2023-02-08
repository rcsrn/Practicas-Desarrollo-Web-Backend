import java.util.Scanner;

public class Practica1 {
    
    private static Scanner reader;
    
    private static void handleAction(int action) {
	if (action == 1) {
	    createCategoryAction();
	} else if (action == 2) {
	    getCategoryListAction();
	} else {
	    queryCategoryAction();
	}
    }
    
    private static void createCategoryAction() {
	Scanner scan  = new Scanner(System.in);
	
	System.out.println("Ingrese el id");
	String id = scan.nextLine();
	
	System.out.println("Ingrese la categoria");
	String category = scan.nextLine();
	
	System.out.println("Ingrese el acronimo");
	String acronym = scan.nextLine();
	
	Category.createCategory(new Category(id, category, acronym));
    }

    private static void getCategoryListAction() {
	System.out.println(Category.getCategories());
    }

    private static void queryCategoryAction() {
	
    }
    
    
    private static void showInstructions() {
	String s1 = "Ingrese 1 si desea crear alguna categoria\n";
	String s2 = "Ingrese 2 si desea ver la lista de categorias existentes\n";
	String s3 = "Ingrese 3 si desea consular alguna categoria\n";
	
	System.out.println(s1 + s2 + s3);
    }

    
    
    public static void main(String[] args) {
	reader = new Scanner(System.in);
	showInstructions();
	while (true) {
	    handleAction(reader.nextInt());
	}
    }   
}

// Scanner scan  = new Scanner(System.in);
	
// 	System.out.println("Ingrese el id");
// 	String id = scan.nextLine();
	
// 	System.out.println("Ingrese la categoria");
// 	String category = scan.nextLine();

// 	System.out.println("Ingrese el acronimo");
// 	String acronym = scan.nextLine();

