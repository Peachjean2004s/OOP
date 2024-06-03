public class ArchiveMaterial extends Book {
    private int id ;
    private Status status ;

    public ArchiveMaterial(int id, String title, String au, String pub, int yr, int nump, Status e) {
        this.id = id;
        this.title = title;
        author = au;
        publiser = pub;
        year = yr;
        numberOfPages = nump;
        status = e ;

    }

    @Override
    public String toString() {
        return "ArchiveMaterial [id=" + id + ", title=" + title + ", READY=" + status + ", Massage= I am glad you pick me .]";
    }
    


}
