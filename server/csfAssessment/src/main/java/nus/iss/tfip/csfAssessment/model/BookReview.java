package nus.iss.tfip.csfAssessment.model;

public class BookReview {
    private String book_title;
    private String book_author;
    private String url;
    private String byline;
    private String summary;
    private String publication_dt;
    private int isbn13;

    public BookReview() {

    }
    

    // Define the constructor with parameters
    public BookReview(String byline, String bookTitle, String bookAuthor, String summary, String publicationDt, String url) {
        this.byline = byline;
        this.book_title = bookTitle;
        this.book_author = bookAuthor;
        this.summary = summary;
        this.publication_dt = publicationDt;
        this.url = url;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublication_dt() {
        return publication_dt;
    }

    public void setPublication_dt(String publication_dt) {
        this.publication_dt = publication_dt;
    }

    public int getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(int isbn13) {
        this.isbn13 = isbn13;
    }

    public void setRating(Float rating) {
    }

}
