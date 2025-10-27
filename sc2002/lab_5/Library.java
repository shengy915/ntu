package lab_5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> library = new ArrayList<>();
    int books = 0;
    private Map<String, List<String>> Borrowed = new HashMap<>();
    public Library(){

    }
    public void add(String title, String author, String genre, int year){
        for (int i = 0; i<library.size();i++){
            if (library.get(i).getTitle() == title){
                //assuming no duplicate books
                System.out.println("Book alr in library");
                return;   
            }
        }
        
        library.add(new Book(title,author,genre,year));
        books++;
        System.out.println("Book added");
        System.out.println("Library contains "+ books+ " books");
    }

    public void remove(String title){
        for (int i = 0; i<library.size();i++){
            if (library.get(i).getTitle() == title){
                //assuming no duplicate books
                library.remove(i);
                books--;
                System.out.println("Book removed");
                return;   
            }
        }
        System.out.println("book not in lirary");
    }

    public void filterByGenre(String genre){
        List<Book> filtered = library.stream().filter(b->b.getGenre().equalsIgnoreCase(genre)).toList();
        for (int i =0; i<filtered.size();i++){
            Book book = filtered.get(i);
            System.out.printf("{Title: %s, Genre: %s, Author: %s, Year: %d}\n",book.getTitle(),book.getGenre(),book.getAuthor(),book.getYear());
        }
    }

    public void filterByAuthor(String author){
        List<Book> filtered = library.stream().filter(b->b.getAuthor().equalsIgnoreCase(author)).toList();
        for (int i =0; i<filtered.size();i++){
            Book book = filtered.get(i);
            System.out.printf("{Title: %s, Genre: %s, Author: %s, Year: %d}\n",book.getTitle(),book.getGenre(),book.getAuthor(),book.getYear());
        }
    }

    public void search(String letters){
        List<Book> searched = library.stream().filter(b->b.getTitle().equalsIgnoreCase(letters)).toList();
        for (int i =0; i<searched.size();i++){
            Book book = searched.get(i);
            System.out.printf("{Title: %s, Genre: %s, Author: %s, Year: %d}\n",book.getTitle(),book.getGenre(),book.getAuthor(),book.getYear());
        }
    }

    public void sortByTitle(){
        List<Book> filtered = library.stream().sorted((b1,b2) -> b1.getTitle().compareTo(b2.getTitle())).toList();
        for (int i =0; i<filtered.size();i++){
            Book book = filtered.get(i);
            System.out.printf("{Title: %s, Genre: %s, Author: %s, Year: %d}\n",book.getTitle(),book.getGenre(),book.getAuthor(),book.getYear());
        }
    }

    public void recommendations(String genre){
        List<Book> filtered = library.stream().filter(b->b.getGenre().equalsIgnoreCase(genre)).toList();
        int random = (int) Math.random()*filtered.size();
        Book book = filtered.get(random);
        System.out.printf("{Title: %s, Genre: %s, Author: %s, Year: %d}\n",book.getTitle(),book.getGenre(),book.getAuthor(),book.getYear());
    }
    
    public void borrow(String name, String title){
        String t = title.trim();
        for (int i = 0; i<library.size();i++){
            if (library.get(i).getTitle().equalsIgnoreCase(t)){
                //assuming no duplicate books
                System.out.println("Book in library, can borrow");
                library.get(i).borrow();
                books--;
                Borrowed.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
                System.out.println("book borrowed");
                System.out.println("Borrowers Details:"+ name + " books borrowed:" + Borrowed.get(name));
                return;
            }
        }
    }
    public void back(String name, String title){
        String t = title.trim();
        int index = 0;
        for (int i = 0; i<library.size();i++){
            if (library.get(i).getTitle().equalsIgnoreCase(t)){
                index = i;
                if (!library.get(i).isBorrowed()){
                    System.out.println("NOT OUR BOOK");
                    return;
                }break;
            }
        }
        library.get(index).back();
        books++;
        List<String> borrowed_books = Borrowed.get(name);
        if  (borrowed_books!= null){
            if(borrowed_books.contains(t)){
                borrowed_books.remove(t);
                System.out.println("Book returned");
                System.out.println("Borrowers Details:"+ name + " books borrowed:" + Borrowed.get(name));
            }
        } 
    }
}
