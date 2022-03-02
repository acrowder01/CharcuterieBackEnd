package com.ace.backend.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.ace.backend.models.board;
import com.ace.backend.repositories.BoardRepository;

 

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@GetMapping("/allboards")
	public List<board> getAllBoards(){
		return boardRepo.findAll();
	}
	
	
	
	
	
}
	
	



