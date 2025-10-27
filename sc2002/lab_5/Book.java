package lab_5;

public class Book {
    private String title, author, genre;
    private int year;
    private boolean borrowed = false;

    public Book(String title, String author, String genre, int year){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.year=year;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }
    public boolean isBorrowed(){
        return borrowed;
    }
    public void borrow(){
        this.borrowed=true;
    }
    public void back(){
        this.borrowed=false;
    }
}
