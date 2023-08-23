package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookEntity;
import com.example.demo.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo br;
	
	public BookEntity saveinfo(BookEntity ss)
	{
		return br.save(ss);
	}
	public List<BookEntity> savedetails(List<BookEntity> ss)
	{
		return (List<BookEntity>) br.saveAll(ss);
	}
	
	public List<BookEntity> showinfo(){
		return br.findAll();
	}
	
	public BookEntity changeinfo(BookEntity ss) {
		return br.saveAndFlush(ss);
	}
	
	public void deleteinfo(BookEntity ss) {
		br.delete(ss);
	}
	
	public void deletemyid(int id) {
		br.deleteById(id);
	}
	
	public Optional<BookEntity> getbyid(int id)
	{
		return br.findById(id);
	}
	
	public String updateinfobyid(int id,BookEntity ss) {
		br.saveAndFlush(ss);
		if(br.existsById(id)) {
			return "Updated";
		}
		else {
			return "Enter valid Id";
		}
	}
	
}
