package com.donikrizky.kicau.mutualservice.dto.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ItemResponseDTO {

	private String username;
	private String comment;
	private Integer parentItemId;
	private Date createdDate;
	
	public ItemResponseDTO(String comment, Integer parentItemId, Date createdDate) {
		this.comment = comment;
		this.parentItemId = parentItemId;
		this.createdDate = createdDate;
	}

	public ItemResponseDTO(String username, String comment, Integer parentItemId, Date createdDate) {
		this.username = username;
		this.comment = comment;
		this.parentItemId = parentItemId;
		this.createdDate = createdDate;
	}
}
