package com.surfboards.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.surfboards.dto.MessageResponseDTO;
import com.surfboards.dto.request.SurfBoardDTO;
import com.surfboards.exception.SurfBoardNotFoundException;
import com.surfboards.service.SurfBoardService;

@RestController
@RequestMapping("/api/v1/surfboard")
public class SurfBoardController {
	
	
	private SurfBoardService surfboardService;
	
	
	@Autowired
	public SurfBoardController(SurfBoardService surfboardService) {
		this.surfboardService = surfboardService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createBoard(@RequestBody @Valid SurfBoardDTO boardDTO) {
		return surfboardService.createBoard(boardDTO);
	}
	
	@GetMapping
	public List<SurfBoardDTO> listAll(){
		return surfboardService.listAll();
	}
	
	@GetMapping("/{id}")
	public SurfBoardDTO findById(@PathVariable Long id) throws SurfBoardNotFoundException {
		return surfboardService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid SurfBoardDTO surfBoardDTO) throws SurfBoardNotFoundException {
		return surfboardService.updateById(id, surfBoardDTO);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws SurfBoardNotFoundException {
		surfboardService.deleteById(id);
	}

}
