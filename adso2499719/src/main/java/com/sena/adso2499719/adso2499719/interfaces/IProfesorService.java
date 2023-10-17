package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.ProfesorDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;


@Repository
public interface IProfesorService {
	
	Page<ProfesorDto> getDatatable(Pageable pagaPageable, String textoBusqueda);
	
	List<Profesor> getAll();

	Profesor getByid(Long id) throws Exception;
	
	Profesor save(Profesor profesor);
	
	void update(Long id, Profesor profesor) throws Exception;

	void delete(Long id) throws Exception;
}
