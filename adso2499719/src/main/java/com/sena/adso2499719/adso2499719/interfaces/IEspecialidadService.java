package com.sena.adso2499719.adso2499719.interfaces;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.adso2499719.adso2499719.dto.EspecialidadDto;
import com.sena.adso2499719.adso2499719.entities.Especialidad;

public interface IEspecialidadService {

	Page<EspecialidadDto> getDatatable(Pageable pagaPageable, String textoBusqueda);
	
	List<Especialidad> getAll();
	
	Especialidad getByid(Long id) throws Exception;
	
	Especialidad save(Especialidad especialidad);
	
	void update(Long id, Especialidad especialidad) throws Exception;
	
	void delete(Long id) throws Exception;
}