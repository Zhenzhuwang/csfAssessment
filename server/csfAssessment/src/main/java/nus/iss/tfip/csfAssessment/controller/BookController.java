package nus.iss.tfip.csfAssessment.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import nus.iss.tfip.csfAssessment.model.BookChar;
import nus.iss.tfip.csfAssessment.service.BookService;
import nus.iss.tfip.csfAssessment.util.MyUtils;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api", produces =MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    
    @Autowired
    private BookService bookSvc;

    @GetMapping(path="/books")
    public ResponseEntity<String>searchReview(@RequestParam String query){
        //get response
        List<BookChar>reviewList = bookSvc.searchReviews(query);
        //invalid search term return empty
        if (reviewList.size()== 0) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("[]");
        }
        //build json
        List<JsonObject> jList = reviewList.stream()
                                            .map(v-> MyUtils.toJson(v))
                                            .toList();

        System.out.println(jList.toString());
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jList.toString());
    }

}
