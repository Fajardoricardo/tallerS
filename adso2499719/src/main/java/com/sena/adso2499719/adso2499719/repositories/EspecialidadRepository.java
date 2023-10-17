package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.EspecialidadDto;
import com.sena.adso2499719.adso2499719.entities.Especialidad;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
	
	@Query(value =  "select esp.id, esp.nombre as Nombre_Especialidad from\r\n"
					+ "	especialidades as esp where concat(esp.nombre) like concat('%', :textobu, '%') ", nativeQuery = true)
	Page<EspecialidadDto> getDatatable(Pageable pagaPageable,@Param("textobu") String textoBusqueda);
}
