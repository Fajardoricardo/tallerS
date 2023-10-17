package com.sena.adso2499719.adso2499719.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidades")
public class Especialidad {
	
	@Id
	//strategy
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombres;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAT;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAT;
	
	@Column(name = "deleted_at")
	private LocalDateTime deletedAT;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public LocalDateTime getCreatedAT() {
		return createdAT;
	}

	public void setCreatedAT(LocalDateTime createdAT) {
		this.createdAT = createdAT;
	}

	public LocalDateTime getUpdatedAT() {
		return updatedAT;
	}

	public void setUpdatedAT(LocalDateTime updatedAT) {
		this.updatedAT = updatedAT;
	}

	public LocalDateTime getDeletedAT() {
		return deletedAT;
	}

	public void setDeletedAT(LocalDateTime deletedAT) {
		this.deletedAT = deletedAT;
	}

}
