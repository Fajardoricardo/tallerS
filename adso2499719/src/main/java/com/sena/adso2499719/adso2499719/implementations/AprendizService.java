package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dto.AprendizDto;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;
import com.sena.adso2499719.adso2499719.interfaces.IAprendizService;
import com.sena.adso2499719.adso2499719.repositories.AprendizRepository;

@Service
public class AprendizService implements IAprendizService {
	
	@Autowired
	private AprendizRepository repository;
	
	@Override
	public Page<AprendizDto> getDatatable(Pageable pagaPageable, String textoBusqueda) {
		return repository.getDatatable(pagaPageable, textoBusqueda);
	}
	
	@Override
	public List<Aprendiz> getAll() {
		return repository.findAll();
	}

	@Override
	public Aprendiz getByid(Long id) throws Exception {
		Optional<Aprendiz> aprendizDBOpt = repository.findById(id);
		if (aprendizDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return aprendizDBOpt.get();
	}

	@Override
	public Aprendiz save(Aprendiz aprendiz) {
		aprendiz.setCreatedAt(LocalDateTime.now());
		return repository.save(aprendiz);
	}

	@Override
	public void update(Long id, Aprendiz aprendiz) throws Exception {
		Optional<Aprendiz> aprendizDBOpt = repository.findById(id);
		if (aprendizDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		Aprendiz aprendizDB = aprendizDBOpt.get();
		aprendizDB.setNombres(aprendiz.getNombres());
		aprendizDB.setApellidos(aprendiz.getApellidos());
		aprendizDB.setGrado(aprendiz.getGrado());
		aprendizDB.setUpdatedAt(LocalDateTime.now());
		
		repository.save(aprendizDB);
		
	}

	@Override
	public void delete(Long id) throws Exception{
		Optional<Aprendiz> aprendizDBOpt = repository.findById(id);
		if (aprendizDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);	
	}
}
