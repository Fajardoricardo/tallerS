package com.sena.adso2499719.adso2499719.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dto.GradoDto;
import com.sena.adso2499719.adso2499719.entities.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long>{
	
	@Query(value = "select gra.id, gra.nombre , gra.salon, gra.jornada \r\n"
						+ "	from grados as gra where concat(gra.nombre, gra.salon)\r\n"
							+ " like concat('%', :textobu ,'%') ", nativeQuery = true)
	Page<GradoDto>  getDatatable(Pageable pagaPageable,@Param("textobu") String textoBusqueda);
}
