package com.example.books.bookService;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.books.bookModel.bookModel;
import com.example.books.bookRepo.bookRepo;

public class bookService implements bookRepo {
    HashMap<Integer, bookModel> hmap = new HashMap<>();
    int bookId=3;

    public bookService() {
        bookModel b1 = new bookModel(1, "harry potter","harry_potter");
        bookModel b2 = new bookModel(2, "Rise","rise");
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
    }

    public ArrayList<bookModel> getAllBooks(){
        ArrayList<bookModel> bookCollection = new ArrayList<>(hmap.values());
        return bookCollection;
    }

    public bookModel getBookById(int id){
        if(hmap.get(id)==null){
            throw new RuntimeException("Book not found with id: " + id);
        }
        return hmap.get(id);
        /*
         public Optional<bookModel> getBookById(int id){
            return (hmap.get(id));
        */
    }

    public bookModel addBook(bookModel bookDetails) {
        bookDetails.setId(bookId++);
        hmap.put(bookId, bookDetails);
        return bookDetails;
    }

    public bookModel updateBook(bookModel bookDetails, int id){
        if(hmap.get(id)==null){
            throw new RuntimeException("Book not found with id: " + id);
        }
        else{
            bookModel oldBook = hmap.get(id);
            oldBook.setTitle(bookDetails.getTitle());
            oldBook.setAuthor(bookDetails.getAuthor());
            return oldBook;
        }
    }


    public String deleteBook(int id){
        if(hmap.get(id)==null){
            throw new RuntimeException("Book not found with id: " + id);
        }
        else{
            hmap.remove(id);
            return "Book with id: " + id + " deleted successfully";
        }
    }
}
