package nus.iss.tfip.csfAssessment.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.tfip.csfAssessment.model.BookChar;

@Repository
public class BooksRepository {

    // private static final String SQL_GET_BOOKSLIST = "SELECT book_id, title, description FROM goodreads.book2018 WHERE title like '?%'";
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // public List<Map<String, Object>> getBooksList(String title){
    //     return jdbcTemplate.queryForList(SQL_GET_BOOKSLIST,BeanPropertyRowMapper.newInstance(BookChar.class));
    // }
    private static final String SQL_GET_BOOKSLIST = "SELECT book_id, title, description FROM goodreads.book2018 WHERE title LIKE ?";

        public List<Map<String, Object>> getBooksList(String firstAlphabet) {
            String filter = firstAlphabet + "%";
            return jdbcTemplate.queryForList(SQL_GET_BOOKSLIST, filter);
        }

}
