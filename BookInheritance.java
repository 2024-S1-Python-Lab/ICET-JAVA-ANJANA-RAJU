import java.util.Scanner;

class Publisher {
    String name;

 public void getPublisherDetails() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Publisher Name: ");
   name = sc.nextLine();
    }
}

class Book extends Publisher {
  String title;
 int year;

 public void getBookDetails() {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter Book Title: ");
     title = sc.nextLine();
    System.out.println("Enter Publication Year: ");
    year = sc.nextInt();
   sc.nextLine(); 
    }

 public void displayBookDetails() {
     System.out.println("\nPublisher: " );
     System.out.println("Title: " + title);
    System.out.println("Year of Publication: ");
    }
}

class Literature extends Book {
    String gen;

    public void getLiteratureDetails() {
    Scanner sc = new Scanner(System.in);
     System.out.println("Enter Generation: ");
    gen = sc.nextLine();
    }

    
    public void displayBookDetails() {
   super.displayBookDetails();
    System.out.println("Generation: " + gen);
    }
}

class Fiction extends Book {
    String theme;

    public void getFictionDetails() {
      Scanner sc = new Scanner(System.in);
    System.out.println("Enter Theme: ");
    theme = sc.nextLine();
    }

  
 public void displayBookDetails() {
    super.displayBookDetails();
   System.out.println("Theme: " );
    }
}

public class BookInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println(" literature books: ");
        int numLitBooks = sc.nextInt();
        Literature[] litBooks = new Literature[numLitBooks];
        System.out.println("literature books:");
        for (int i = 0; i < numLitBooks; i++) {
            litBooks[i] = new Literature();
            litBooks[i].getPublisherDetails();
            litBooks[i].getBookDetails();
            litBooks[i].getLiteratureDetails();
        }

        
        System.out.println("Enter the number of fiction books: ");
        int numFicBooks = sc.nextInt();
        Fiction[] ficBooks = new Fiction[numFicBooks];
        System.out.println("Enter details for fiction books:");
        for (int i = 0; i < numFicBooks; i++) {
            ficBooks[i] = new Fiction();
            ficBooks[i].getPublisherDetails();
            ficBooks[i].getBookDetails();
            ficBooks[i].getFictionDetails();
        }

        
        System.out.println("\nLiterature Books:");
        for (Literature litBook : litBooks) {
            litBook.displayBookDetails();
            System.out.println();
        }

       
        System.out.println("\nFiction Books:");
        for (Fiction ficBook : ficBooks) {
            ficBook.displayBookDetails();
            System.out.println();
        }

        
    }
}

