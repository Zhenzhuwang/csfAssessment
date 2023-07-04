package nus.iss.tfip.csfAssessment.model;

public class BookChar {
    private Integer book_id;
    private String title;
    private String authors;
    private String description;
    private String edition;
    private String format;
    private Integer pages;
    private Float rating;
    private Integer rating_count;
    private Integer review_count;
    private String genres;
    private String image_url;

    private String book_title;
    private String book_author;
    private String url;
    private String byline;
    private String summary;
    private String publication_dt;
    private int isbn13;

    

    public BookChar() {
    }


    public BookChar(Integer book_id, String title, String authors, String description, String edition, String format,
            Integer pages, Float rating, Integer rating_count, Integer review_count, String genres, String image_url) {
        this.book_id = book_id;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.edition = edition;
        this.format = format;
        this.pages = pages;
        this.rating = rating;
        this.rating_count = rating_count;
        this.review_count = review_count;
        this.genres = genres;
        this.image_url = image_url;
    }


    public Integer getBook_id() {
        return book_id;
    }


    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthors() {
        return authors;
    }


    public void setAuthors(String authors) {
        this.authors = authors;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getEdition() {
        return edition;
    }


    public void setEdition(String edition) {
        this.edition = edition;
    }


    public String getFormat() {
        return format;
    }


    public void setFormat(String format) {
        this.format = format;
    }


    public Integer getPages() {
        return pages;
    }


    public void setPages(Integer pages) {
        this.pages = pages;
    }


    public Float getRating() {
        return rating;
    }


    public void setRating(Float rating) {
        this.rating = rating;
    }


    public Integer getRating_count() {
        return rating_count;
    }


    public void setRating_count(Integer rating_count) {
        this.rating_count = rating_count;
    }


    public Integer getReview_count() {
        return review_count;
    }


    public void setReview_count(Integer review_count) {
        this.review_count = review_count;
    }


    public String getGenres() {
        return genres;
    }


    public void setGenres(String genres) {
        this.genres = genres;
    }


    public String getImage_url() {
        return image_url;
    }


    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }


    


    public BookChar(String book_title, String book_author, String url, String byline, String summary,
            String publication_dt, int isbn13) {
        this.book_title = book_title;
        this.book_author = book_author;
        this.url = url;
        this.byline = byline;
        this.summary = summary;
        this.publication_dt = publication_dt;
        this.isbn13 = isbn13;
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


    public int getIsbn13() {
        return isbn13;
    }


    public void setIsbn13(int isbn13) {
        this.isbn13 = isbn13;
    }


    public String getPublication_dt() {
        return publication_dt;
    }


    public void setPublication_dt(String publication_dt) {
        this.publication_dt = publication_dt;
    }

    
    @Override
    public String toString() {
        return "Review{title:%s, rating:%s}".formatted(title,rating);
    }
   

    
    
    
    
}
