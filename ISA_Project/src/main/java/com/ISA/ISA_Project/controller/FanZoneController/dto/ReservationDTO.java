package com.ISA.ISA_Project.controller.FanZoneController.dto;

public class ReservationDTO {
	
	private Long userId;
	private Long productId;
	
	public ReservationDTO() {
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	

}
