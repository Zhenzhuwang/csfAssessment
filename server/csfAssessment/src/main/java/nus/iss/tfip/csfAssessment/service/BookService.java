package nus.iss.tfip.csfAssessment.service;


import java.io.StringReader;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import nus.iss.tfip.csfAssessment.model.BookChar;
import nus.iss.tfip.csfAssessment.repository.BooksRepository;

@Service
public class BookService {


    //Request URL https://api.nytimes.com/svc/books/v3/reviews.json?author=Stephen+King&api-key=yourkey


    public static final String REVIEW_URL = "https://api.nytimes.com/svc/books/v3/reviews.json";

    @Value("${api.key}")
    private String privateKey;

    @Autowired
    private BooksRepository booksRepository;

    // public String getReviewById(int book_id){
    //     List<Document> bookList = booksRepository.getReviewById(book_id);
    //     List<String> jList = bookList.stream().map(v -> v.toJson()).toList();
    // }
    
public List<BookChar> searchReviews(String query){
    String url = UriComponentsBuilder.fromUriString(REVIEW_URL)
                .queryParam("author", query)
                .queryParam("api-key", privateKey)
                .build()
                .toUriString();

//REQUEST CONTAINER
RequestEntity<Void> request = RequestEntity.get(url)
    // .accept(MediaType.APPLICATION_JSON)
    .accept()
    .build();
RestTemplate template = new RestTemplate();
String responseBody = "";
try {
    ResponseEntity<String> response = template.exchange(request, String.class);
    responseBody = response.getBody();
} catch (Exception e) {
    e.printStackTrace();
    return new LinkedList<BookChar>();
}
//read response
JsonReader reader = Json.createReader(new StringReader(responseBody));
JsonObject responseObj = reader. readObject();
//on invalid return empty list
if (responseObj.isNull("results")){
    return new LinkedList<BookChar>();
}
JsonArray results = responseObj.getJsonArray("results");

List<BookChar> reviewList = results.stream()
                                .map(v->v.asJsonObject())
                                .map(v->this.reviewMarshalling(v))
                                .toList();
                        return reviewList;

}

private BookChar reviewMarshalling(JsonObject jObj){
    BookChar r = new BookChar();
    r.setTitle(jObj.getString("book_title"));
    r.setAuthors(jObj.getString("book_author"));
    r.setByline(jObj.getString("byline"));
    r.setSummary(jObj.getString("summary"));
    r.setPublication_dt(jObj.getString("publication_dt"));
    r.setUrl(jObj.getString("url"));
    r.setIsbn13(jObj.getInt(null));
    return r;
}

    
}
