package nus.iss.tfip.csfAssessment.util;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import nus.iss.tfip.csfAssessment.model.BookChar;
import nus.iss.tfip.csfAssessment.model.BookReview;

public class MyUtils {

    // public static JsonObject toJson(BookChar r){
    //     JsonObjectBuilder job = Json.createObjectBuilder()
    //                             .add("url", r.getUrl())
    //                             .add("byline", r.getByline())
    //                             .add("book_title", r.getBook_title())
    //                             .add("book_author", r.getBook_author())
    //                             .add("publication_dt",r.getPublication_dt())
    //                             .add("summary", r.getSummary())
    //                             .add("isbn13", r.getIsbn13());
    // return job.build();
    // }
   public static JsonObject toJson(BookChar r) {
        JsonObjectBuilder job = Json.createObjectBuilder()
                .add("url", r.getImage_url())
                .add("book_title", r.getTitle())
                .add("book_author", r.getAuthors())
                .add("summary", r.getDescription())
                .add("rating", r.getGenres())
                .add("pages",r.getPages())
                .add("book_id", r.getBook_id());
        return job.build();
    }

    public static JsonObject toJson(BookReview r) {
        JsonObjectBuilder job = Json.createObjectBuilder()
                .add("byline", r.getByline())
                .add("book_title", r.getBook_title())
                .add("book_author", r.getBook_author())
                .add("summary", r.getSummary())
                .add("publication_dt", r.getPublication_dt())
                .add("url", r.getUrl());
        return job.build();
    } 
}


