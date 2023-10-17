package com.sena.adso2499719.adso2499719.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.ProfeMaterGradoDto;
import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;

@Repository
public interface ProfesorMateriaGradoRepository extends JpaRepository<ProfesorMateriaGrado, Long> {

	@Query(value = "select\r\n"
			+ "	pmg.id,\r\n"
			+ "    mat.nombre as materia,\r\n"
			+ "    grd.nombre as grado\r\n"
			+ " from profesores_materias_grados pmg\r\n"
			+ " inner join materias mat on mat.id = pmg.materia_id\r\n"
			+ " inner join grados grd on mat.id = pmg.grado_id"
			+ "where pmg.profesor_id = :profesorId ", nativeQuery = true)
	List<ProfeMaterGradoDto> getData(Long profesorId);
	
}
