public abstract class Book extends Library  {
    protected String isbn ;
    protected String title ;
    protected String author ;
    protected String publiser ;
    protected int year ;
    protected int numberOfPages ;
    private int currentPageNumber ;

    public Book(){
        
    }

   public  Book(String isbn ,String title ,String author ,String pub,int yr ,int numPages) {
    this.isbn = isbn ;
    this.title = title ;
    this.author = author;
    publiser = pub ;
    year = yr ;
    numberOfPages = numPages ;
   }

   public void turnPageForward(){
    currentPageNumber++;

   }
   public void turnPageBackward(){
    currentPageNumber--;
   }
   public int nowAtPage(){
    return currentPageNumber ;
   }
   public String getTitle(){
    return title ;
   }
}
