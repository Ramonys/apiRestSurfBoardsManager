package com.surfboards.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.surfboards.dto.MessageResponseDTO;
import com.surfboards.dto.request.SurfBoardDTO;
import com.surfboards.entity.Surfboard;
import com.surfboards.exception.SurfBoardNotFoundException;
import com.surfboards.mapper.SurfBoardMapper;
import com.surfboards.repository.SurfBoardRepository;

import lombok.Data;

@Service
@Data
public class SurfBoardService {

	private SurfBoardRepository surfBoardRep;
	
	private final SurfBoardMapper surfBoardMapper = SurfBoardMapper.INSTANCE;
	
	@Autowired
	public SurfBoardService(SurfBoardRepository surfBoardRep) {
		this.surfBoardRep = surfBoardRep;
	}
	
	@PostMapping
	public MessageResponseDTO createBoard(SurfBoardDTO boardDTO) {
		Surfboard boardToSave = surfBoardMapper.toModel(boardDTO);
		Surfboard savedSurfBoard =surfBoardRep.save(boardToSave);

		return MessageResponseDTO
				.builder()
				.message("created Surfboard "+savedSurfBoard.getId())
				.build();
	}

	public List<SurfBoardDTO> listAll() {
		List<Surfboard> allBoards = surfBoardRep.findAll();
		return allBoards.stream()
				.map(surfBoardMapper::toDTO)
				.collect(Collectors.toList());
	}

	public SurfBoardDTO findById(Long id) throws SurfBoardNotFoundException {
		Surfboard surfboard = verifyIfExist(id);
		return surfBoardMapper.toDTO(surfboard);
	}

	public void deleteById(Long id) throws SurfBoardNotFoundException {
		verifyIfExist(id);
		surfBoardRep.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, SurfBoardDTO surfBoardDTO) throws SurfBoardNotFoundException {
		verifyIfExist(id);
		
		Surfboard boardToUpdate = surfBoardMapper.toModel(surfBoardDTO);
		Surfboard updatedSurfBoard =surfBoardRep.save(boardToUpdate);

		return MessageResponseDTO
				.builder()
				.message("Updated Surfboard with ID:  "+updatedSurfBoard.getId())
				.build();
	}
	
	private Surfboard verifyIfExist(Long id) throws SurfBoardNotFoundException {
		 return surfBoardRep.findById(id)
		.orElseThrow(() -> new SurfBoardNotFoundException(id));		
	}

}
