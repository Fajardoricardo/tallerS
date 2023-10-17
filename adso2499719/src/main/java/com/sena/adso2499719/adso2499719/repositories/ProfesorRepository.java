package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.ProfesorDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

	@Query(value = "select pro.id, pro.nombres, \r\n "
			+ " pro.apellidos, esp.name as nombreEspecialidad \r\n "
			+ " from profesores as pro\r\n "
			+ " inner join especialidades as esp on esp.id = pro.especialidad_id \r\n "
			+ " where concat (pro.nombres, pro.apellidos, esp.name) like concat ('%', :textobu, '%') ", nativeQuery = true)
	Page<ProfesorDto> getDatatable(Pageable pagaPageable, @Param("textobu") String textoBusqueda);
}
