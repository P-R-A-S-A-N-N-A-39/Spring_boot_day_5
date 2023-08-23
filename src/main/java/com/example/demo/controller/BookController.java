package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookEntity;
import com.example.demo.service.BookService;


@RestController
public class BookController {

	@Autowired
	BookService book;
	@PostMapping("addbook")
	public BookEntity add(@RequestBody BookEntity ss) {
		return book.saveinfo(ss);
	}
	
	@GetMapping("showbook")
	public List<BookEntity> show(){
		return book.showinfo();
	}
	
	@PutMapping("updatebook")
	public BookEntity modify(@RequestBody BookEntity ss) {
		return book.changeinfo(ss);
	}
	
	@DeleteMapping("deletebook")
	public String del(@RequestBody BookEntity ss) {
		book.deleteinfo(ss);
		return "Deleted successfully";
	}
	
	@DeleteMapping("delid/{id}")
	public void deleteuid(@PathVariable int id) {
		book.deletemyid(id);
	}
	
	@PostMapping("addnbook")
	public List<BookEntity>addndetails(@RequestBody List<BookEntity> ss){
		return book.savedetails(ss);
	}
	
	@GetMapping("getbook/{id}")
	public Optional<BookEntity> showid(@PathVariable int id)
	{
		return book.getbyid(id);
	}
	
	@PutMapping("updatebook/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody BookEntity ss) {
		return book.updateinfobyid(id, ss);
	}
}