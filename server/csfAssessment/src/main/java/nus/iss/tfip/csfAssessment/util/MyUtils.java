package nus.iss.tfip.csfAssessment.util;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import nus.iss.tfip.csfAssessment.model.BookChar;

public class MyUtils {

    public static JsonObject toJson(BookChar r){
        JsonObjectBuilder job = Json.createObjectBuilder()
                                .add("url", r.getUrl())
                                .add("byline", r.getByline())
                                .add("book_title", r.getBook_title())
                                .add("book_author", r.getBook_author())
                                .add("publication_dt",r.getPublication_dt())
                                .add("summary", r.getSummary())
                                .add("isbn13", r.getIsbn13());
    return job.build();
    }
    
}


