package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dto.ProfesorDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;
import com.sena.adso2499719.adso2499719.interfaces.IProfesorService;
import com.sena.adso2499719.adso2499719.repositories.ProfesorRepository;


@Service
public class ProfesorService implements IProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public Page<ProfesorDto> getDatatable(Pageable pagaPageable, String textoBusqueda) {
		return repository.getDatatable(pagaPageable, textoBusqueda);
	}
	
	@Override
	public List<Profesor> getAll() {
		return repository.findAll();
	}

	@Override
	public Profesor getByid(Long id) throws Exception {
		Optional<Profesor> profesorOpcional = repository.findById(id);
		if (profesorOpcional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return profesorOpcional.get();
	}

	@Override
	public Profesor save(Profesor profesor) {
		profesor.setCreatedAt(LocalDateTime.now());
		return repository.save(profesor);
	}

	@Override
	public void update(Long id, Profesor profesor) {
		Optional<Profesor> profesorDBOpt = repository.findById(id);
		if (profesorDBOpt.isEmpty()) {
			return;
		}
		Profesor profesorDB = profesorDBOpt.get();
		profesorDB.setNombres(profesor.getNombres());
		profesorDB.setApellidos(profesor.getApellidos());
		profesorDB.setEspecialidad(profesor.getEspecialidad());
		repository.save(profesorDB);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Profesor> profesorDBOpt = repository.findById(id);
		if (profesorDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);

	}

}
