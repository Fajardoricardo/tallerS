package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dto.GradoDto;
import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.interfaces.IGradoService;
import com.sena.adso2499719.adso2499719.repositories.GradoRepository;

@Service
public class GradoService implements IGradoService{

	@Autowired
	private GradoRepository repository;
	
	@Override
	public Page<GradoDto> getDatatable(Pageable pagaPageable, String textoBusqueda) {
		return repository.getDatatable(pagaPageable, textoBusqueda);
	}

		
	@Override
	public List<Grado> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Grado getByid(Long id) throws Exception {
		Optional<Grado> gradoOpcional = repository.findById(id);
		if (gradoOpcional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return gradoOpcional.get();
	}

	@Override
	public Grado save(Grado grado) {
		grado.setCreatedAt(LocalDateTime.now());
		return repository.save(grado);
	}

	@Override
	public void update(Long id, Grado grado) throws Exception {
		Optional<Grado> gradoDBOpt = repository.findById(id);
		if (gradoDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		Grado gradoDB = gradoDBOpt.get();
		gradoDB.setNombres(grado.getNombres());
		gradoDB.setJornadas(grado.getJornadas());
		gradoDB.setSalones(grado.getSalones());
		gradoDB.setUpdatedAt(LocalDateTime.now());
		repository.save(gradoDB);
	}

	@Override
	public void delete(Long id) throws Exception{
		Optional<Grado> gradoDBOpt = repository.findById(id);
		if (gradoDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);
	}
}
