package com.callmatos.java.maven.demobuildjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.callmatos.java.maven.demobuildjava.repositories.BookRepository;

@Controller
public class BookController {
    
    private final BookRepository bookRepository;

    //Spring MVC will inject an instance of Bood repository into Controller
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/books")
    public String getBook(Model bookModel){

        bookModel.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
