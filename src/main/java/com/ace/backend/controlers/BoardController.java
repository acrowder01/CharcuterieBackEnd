package com.ace.backend.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ace.backend.exceptions.ResourceNotFoundException;

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
	
	@GetMapping("boardtype/{id}")
		public ResponseEntity<board> getboardById(@PathVariable int id){
			board board = boardRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Boardtype not found")); 
					return ResponseEntity.ok(board);
			}
		 
		 @GetMapping("boards/{description}")
			public List<board> getboardsBydescription(@PathVariable String description) {
				List<board> boards = boardRepo.findBydescription(description);
				if(boards.isEmpty()) {
					System.out.println(new ResourceNotFoundException("Charcuterie Boards(s) with the name " + description + " not found."));
				}
				return boardRepo.findBydescription(description);
			}
			
			@PostMapping("addboard")
			public board newboard(@RequestBody board board) {
				return boardRepo.save(board);
			}
			
			@DeleteMapping("boardtype/{id}")
			public ResponseEntity<String> deleteboard(@PathVariable int id) {
				boardRepo.findById(id)
				
				.orElseThrow(() -> new ResourceNotFoundException("Student not found."));
				
				String message =  "Board has been deleted.";
				
				boardRepo.deleteById(id);
				return new ResponseEntity<>(message, HttpStatus.OK);
			}
			
			

			
	
}
	
	



