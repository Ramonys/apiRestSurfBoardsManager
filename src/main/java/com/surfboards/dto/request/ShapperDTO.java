package com.surfboards.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShapperDTO {

	private Long id;
	
	@NotEmpty(message = "Field name is empty")
	@Size(max = 30)
	private String name;
	
	@NotEmpty(message ="Field contact is empty")
	@Size(max = 40)
	private String contact;
}
