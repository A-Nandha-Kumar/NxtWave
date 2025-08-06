package com.example.books.bookController;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.bookModel.bookModel;
import com.example.books.bookService.bookService;

@RestController()
public class bookController {

    bookService service = new bookService();

    @GetMapping("/allBooks")
    public ArrayList<bookModel> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    public bookModel getBookById(@PathVariable(value="bookId") int id){
        return service.getBookById(id);
    }

    @PostMapping("/addBook")
    public bookModel addBook(@RequestBody bookModel bookDetails){
        return service.addBook(bookDetails);
    }

    @PutMapping("/update/{bookId}")
    public bookModel updateBook(@RequestBody bookModel bookDetails, @PathVariable(value="bookId")int id){
        return service.updateBook(bookDetails, id);
    }
    
    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable(value="bookId") int id){
        return service.deleteBook(id);
    }

    
}
