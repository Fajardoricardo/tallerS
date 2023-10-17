package com.sena.adso2499719.adso2499719.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dto.ProfeMaterGradoDto;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;
import com.sena.adso2499719.adso2499719.interfaces.IProfesorMateriaGradoService;
import com.sena.adso2499719.adso2499719.repositories.ProfesorMateriaGradoRepository;

@Service
public class ProfesorMateriaGradoService implements IProfesorMateriaGradoService{

	@Autowired
	private ProfesorMateriaGradoRepository repository;
	
	@Override
	public List<ProfeMaterGradoDto> getData(Long profesorId) {
		// TODO Auto-generated method stub
		return repository.getData(profesorId);
	}

	@Override
	public ProfesorMateriaGrado save(ProfesorMateriaGrado profesorMateriaGrado) {
		return repository.save(profesorMateriaGrado);
	}

	@Override
	public void delete(Long profesorMateriaGradoId) {

		repository.deleteById(profesorMateriaGradoId);
		
	}

}
