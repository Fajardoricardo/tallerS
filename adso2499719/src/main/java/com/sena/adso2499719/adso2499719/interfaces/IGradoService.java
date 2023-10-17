package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dto.GradoDto;
import com.sena.adso2499719.adso2499719.entities.Grado;

public interface IGradoService {
	Page<GradoDto>  getDatatable(Pageable pagaPageable, String textoBusqueda);
	
	List<Grado> getAll();
	
	Grado getByid(Long id)throws Exception;
	
	Grado save(Grado grado);
	
	void update(Long id, Grado grado) throws Exception;
	
	void delete(Long id) throws Exception;
}
