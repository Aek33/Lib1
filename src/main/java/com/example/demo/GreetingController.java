package com.example.demo;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private BookRep bookRep;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        List<Book> books = bookRep.findAll();

        model.put("books", books);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String bName, @RequestParam String bAuthor, Map<String, Object> model) {
        Book book = new Book(bName, bAuthor);

        bookRep.save(book);

        List<Book> books = bookRep.findAll();

        model.put("books", books);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter,  Map<String, Object> model){
        List<Book> books;
        if (filter != null && !filter.isEmpty()){
            books = bookRep.findBybName(filter);
        }
        else {
            books = bookRep.findAll();
        }

        model.put("books", books);

        return "main";
       }
}
