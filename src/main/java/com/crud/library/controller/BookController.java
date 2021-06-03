package com.crud.library.controller;

import com.crud.library.domain.dto.BookDto;
import com.crud.library.mapper.BookMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private DbService service;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method =  RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long bookId) throws NotFoundRecordException {
        return bookMapper.mapToBookDto(service.getBookById(bookId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addNewBook", consumes = APPLICATION_JSON_VALUE)
    public void addNewBook(@RequestBody BookDto bookDto) {
        bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public void updateBook(@RequestBody BookDto bookDto) {
        bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) {
        service.deleteBook(bookId);
    }
}
