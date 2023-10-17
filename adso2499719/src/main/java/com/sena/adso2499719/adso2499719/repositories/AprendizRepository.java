package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.AprendizDto;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;

@Repository
public interface AprendizRepository extends JpaRepository<Aprendiz, Long>{

	@Query(value = "select apren.id, apren.nombre, apren.apellido,\r\n"
			+ "	gra.nombre as Nombre_Grado, gra.salon as Salon,\r\n"
			+ "		gra.jornada as Jornada from aprendices as apren inner join grados as gra on gra.id = apren.grado_id\r\n"
			+ "			where concat(apren.nombre, apren.apellido, gra.nombre) like concat('%', :textobu ,'%')", nativeQuery = true)
	Page<AprendizDto> getDatatable(Pageable pagaPageable,@Param("textobu") String textoBusqueda);
}
