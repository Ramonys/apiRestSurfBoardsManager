package com.surfboards.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurfBoardDTO {

	
	private Long id;
	
	@NotEmpty(message = "Field Board Model is empty or incorrect")
	@Size(max = 20)
	private String boardModel;
	
	@NotNull(message = "Field Year Made is empty or incorrect")
	private Integer yearMade;
	
	@NotNull(message = "Field Serie is empty or incorrect")
	private Integer serie;
	
	@NotNull(message = "Field Price is empty or incorrect")
	private Double price;
	
	@NotNull(message = "Field Volume is empty or incorrect")
	private Integer volume;
	
	@NotNull
	private ShapperDTO shapper;
}
