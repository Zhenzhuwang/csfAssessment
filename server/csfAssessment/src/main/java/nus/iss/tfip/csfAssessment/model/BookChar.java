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

    
    

    

   
    
}
