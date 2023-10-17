package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.MateriaDto;
import com.sena.adso2499719.adso2499719.entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{
	@Query(value ="select mat.id, mat.nombre as Nombre_Materia from\r\n"
			    	+ "	materias as mat where concat(mat.nombre) like concat('%', \"f\", '%') ", nativeQuery = true)
	Page<MateriaDto>  getDatatable(Pageable pagaPageable,@Param("textobu") String textoBusqueda);
}
