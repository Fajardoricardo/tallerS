package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dto.EspecialidadDto;
import com.sena.adso2499719.adso2499719.entities.Especialidad;
import com.sena.adso2499719.adso2499719.interfaces.IEspecialidadService;
import com.sena.adso2499719.adso2499719.repositories.EspecialidadRepository;

@Service
public class EspecialidadService implements IEspecialidadService{

	@Autowired
	private EspecialidadRepository repository;
	
	@Override
	public Page<EspecialidadDto> getDatatable(Pageable pagaPageable, String textoBusqueda) {
		return repository.getDatatable(pagaPageable, textoBusqueda);
	}

	@Override
	public List<Especialidad> getAll() {
		return repository.findAll();
	}

	@Override
	public Especialidad getByid(Long id) throws Exception {
		Optional<Especialidad> especialidadOptional = repository.findById(id);
		if (especialidadOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return especialidadOptional.get();
	}

	@Override
	public Especialidad save(Especialidad especialidad) {
		especialidad.setCreatedAT(LocalDateTime.now());
		return repository.save(especialidad);
	}

	@Override
	public void update(Long id, Especialidad especialidad) throws Exception {
		Optional<Especialidad> especialidadDBOpt = repository.findById(id);
		if (especialidadDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
			//return;
		}
		Especialidad especialidadDB = especialidadDBOpt.get();
		especialidadDB.setNombres(especialidad.getNombres());
		especialidadDB.setUpdatedAT(LocalDateTime.now());
		
		repository.save(especialidadDB);		
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Especialidad> especialidadOptional = repository.findById(id);
		if (especialidadOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);
	}
}
