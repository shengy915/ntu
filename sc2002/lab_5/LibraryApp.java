package lab_5;

import java.util.Scanner;

public class LibraryApp {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sel = 0;
        Library library = new Library();
        do {
            System.out.print("(1) Add Book\n" +
                    "(2) Remove book\n" +
                    "(3) Filter by Genre\n" +
                    "(4) Filter by Author\n" +
                    "(5) Search\n" +
                    "(6) Recommendations\n" +
                    "(7) Sort by title\n" +
                    "(8) Borrow\n" +
                    "(9) Return\n" +
                    "(0) Quit\nChoose an option: ");
            sel = sc.nextInt();
            
            switch(sel)
            {
                case 1:
                    System.out.print("Enter Title: ");
                    String title1 = sc.next();
                    System.out.print("Enter Author: ");
                    String author1 = sc.next();
                    System.out.print("Enter Genre: ");
                    String genre1 = sc.next();
                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();
                    library.add(title1, author1, genre1, year);
                    break;
                case 2:
                    System.out.print("Enter Title: ");
                    String title2 = sc.next();
                    library.remove(title2);
                    break;
                case 3:
                    System.out.print("Enter Genre: ");
                    String genre2 = sc.next();
                    library.filterByGenre(genre2);
                    break;
                case 4:
                    System.out.print("Enter Author: ");
                    String author2 = sc.next();
                    library.filterByAuthor(author2);
                    break;
                case 5:
                    System.out.print("Enter Word: ");
                    String word = sc.next();
                    library.search(word);
                    break;
                case 6:
                    System.out.print("Enter genre: ");
                    String genre3 = sc.next();
                    library.recommendations(genre3);
                    break;
                case 7:
                    library.sortByTitle();
                    break;
                case 8:
                    System.out.print("Enter Name: ");
                    String name1 = sc.next();
                    System.out.print("Enter Title: ");
                    String title3 = sc.next();
                    library.borrow(name1, title3);
                    break;
                case 9:
                    System.out.print("Enter Name: ");
                    String name2 = sc.next();
                    System.out.print("Enter Title: ");
                    String title4 = sc.next();
                    library.back(name2, title4);
                    break;
            }

        } while (sel != 0);
    sc.close();
    }
}
