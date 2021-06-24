package com.surfboards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.surfboards.dto.request.SurfBoardDTO;
import com.surfboards.entity.Surfboard;

@Mapper
public interface SurfBoardMapper {

	SurfBoardMapper INSTANCE = Mappers.getMapper(SurfBoardMapper.class);
	
	Surfboard toModel(SurfBoardDTO surfBoardDTO);
	
	SurfBoardDTO toDTO(Surfboard surfboard);
}
