package com.sena.adso2499719.adso2499719.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dto.ApiResponseDto;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;
import com.sena.adso2499719.adso2499719.interfaces.IAprendizService;

@RequestMapping("api/aprendiz")
@RestController
@CrossOrigin("http://localhost:4200")
public class AprendizController {
	@Autowired
	private IAprendizService service;
	
	@GetMapping("datatable")
	public ResponseEntity<Page<?>> datatable(@RequestParam(name = "page") Integer page,
			@RequestParam(name = "size") Integer size,
			@RequestParam(name = "column_order") String columnOder,
			@RequestParam(name = "column_direction") String columnDirection,
			@RequestParam(name = "search", required = false) String search ){
		List<Order> orders = new ArrayList<>();
		if (columnDirection.equals("asc")) {
			orders.add(new Order(Direction.ASC, columnOder));
		}else {
			orders.add(new Order(Direction.DESC, columnOder));
		}
		if (search == null) {
			search = "";
		}
		return ResponseEntity.ok(service.getDatatable(PageRequest.of(page, size, Sort.by(orders)), search));
	}
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Aprendiz>>> getAll(){
		try {
			//service.getAll()
			return ResponseEntity.ok(new ApiResponseDto<List<Aprendiz>>("Datos obtenidos", true, service.getAll()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Aprendiz>>(e.getMessage(), false, null));
		}
	}
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<Aprendiz>> getById(@PathVariable Long id){
		try {
			//service.getByid(id)
			return ResponseEntity.ok(new ApiResponseDto<Aprendiz>("Datos encontrados", true, service.getByid(id)));

		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Aprendiz>(e.getMessage(), false, null));
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<Aprendiz>> save(@RequestBody Aprendiz aprendiz){
		try {
			return ResponseEntity.ok(new ApiResponseDto<Aprendiz>("Se guardo con exito", true, service.save(aprendiz)));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Aprendiz>(e.getMessage(), false, null));
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Aprendiz>> update(@PathVariable Long id,@RequestBody Aprendiz aprendiz){
		try {
			service.update(id, aprendiz);
			return ResponseEntity.ok(new ApiResponseDto<Aprendiz>("Registro modificado", true, null));		
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Aprendiz>(e.getMessage(), false, null));
		}
	
	}
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Aprendiz>> delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok(new ApiResponseDto<Aprendiz>("Registro eliminado", true, null));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Aprendiz>(e.getMessage(), false, null));
		}
		
	}
	
}
