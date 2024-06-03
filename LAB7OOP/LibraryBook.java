import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryBook extends Book implements BorrowAble {
    private int id;
    private Boolean availForBorrow = true ;
    private LocalDate dateBorrow;
    private PrintType type;

    public LibraryBook(int id, String title, String au, String pub, int yr, int nump, PrintType e) {
        this.id = id;
        this.title = title;
        author = au;
        publiser = pub;
        year = yr;
        numberOfPages = nump;
        type = e;

    }

    public void setBookAvailableFalse() {
        availForBorrow = false;
    }

    public void setBookAvailableTrue() {
        availForBorrow = true;
    }

    public Boolean isAvailable() {
        return availForBorrow ;
    }

    
    @Override
    public Boolean checkoutItem(int yy, int mm, int dd) {
        if (isAvailable() && type == PrintType.PRINT) {
            dateBorrow = LocalDate.of(yy, mm, dd);
            setBookAvailableFalse();
            return true;
        }
        else {
            return false ;
        }
    }

    @Override
    public int returnItem(int yy, int mm, int dd) {
        LocalDate today = LocalDate.of(yy,mm,dd);
        long daysBetween = ChronoUnit.DAYS.between(dateBorrow, today);
        if(this.isAvailable() == false && daysBetween > 7)
        {
           return (int)daysBetween - 7;

        }
        return 0;
    }

    @Override
    public String toString() {
        return "LibraryBook [id=" + id + ", title=" + title + ", PRINT=" + type + ", availForBorrow=" + availForBorrow+ "]";
    }

}