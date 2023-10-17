package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;

import com.sena.adso2499719.adso2499719.dto.ProfeMaterGradoDto;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;

public interface IProfesorMateriaGradoService {

	List<ProfeMaterGradoDto> getData(Long profesorId);
	
	ProfesorMateriaGrado save(ProfesorMateriaGrado profesorMateriaGrado);
	
	void delete(Long profesorMateriaGradoId);
}
