package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.MateriaDto;
import com.sena.adso2499719.adso2499719.entities.Materia;

@Repository
public interface IMateriaService {

	Page<MateriaDto>  getDatatable(Pageable pagaPageable, String textoBusqueda);
	
	List<Materia> getAll();

	Materia getByid(Long id) throws Exception;
	
	Materia save(Materia materia);
	
	void update(Long id, Materia materia) throws Exception;

	void delete(Long id) throws Exception;
}
