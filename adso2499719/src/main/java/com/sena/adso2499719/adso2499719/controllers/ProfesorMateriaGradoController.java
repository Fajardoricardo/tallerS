package com.sena.adso2499719.adso2499719.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dto.ApiResponseDto;
import com.sena.adso2499719.adso2499719.dto.ProfeMaterGradoDto;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;
import com.sena.adso2499719.adso2499719.implementations.ProfesorMateriaGradoService;

@RestController
@RequestMapping("api/profesor_materia_gardo")
@CrossOrigin("http://localhost:4200")
public class ProfesorMateriaGradoController {
	
	@Autowired
	private ProfesorMateriaGradoService service;
	
	@GetMapping("{profesorId}")
	public ResponseEntity<ApiResponseDto<List<ProfeMaterGradoDto>>> getAll(@PathVariable Long profesorId){
		try {
			
			return ResponseEntity.ok(new ApiResponseDto<List<ProfeMaterGradoDto>>("Datos obtenidos", true, service.getData(profesorId)));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ProfeMaterGradoDto>>(e.getMessage(), false, null));
		}
	}

	
	@PostMapping
	public ResponseEntity<ApiResponseDto<ProfesorMateriaGrado>> save(@RequestBody ProfesorMateriaGrado profesorMateriaGrado){
		try {
			return ResponseEntity.ok(new ApiResponseDto<>("Se guardo con exito", true, service.save(profesorMateriaGrado)));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), false, null));
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<ProfeMaterGradoDto>> delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok(new ApiResponseDto<>("Registro eliminado", true, null));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), false, null));
		}
		
	}
	

}
