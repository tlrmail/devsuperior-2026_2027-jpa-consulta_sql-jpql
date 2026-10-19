package com.devsuperior.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, String> {
	
	@Query(nativeQuery = true, value = "SELECT e.cpf, e.enome, d.dnome "
			+ "FROM empregados e "
			+ "INNER JOIN departamentos d ON e.dnumero = d.dnumero "
			+ "WHERE e.cpf NOT IN( "
			+ "	SELECT e2.cpf "
			+ "	FROM empregados e2 "
			+ "	INNER JOIN trabalha t ON t.cpf_emp = e.cpf "
			+ ")"
			+ "ORDER BY e.cpf")
	List<EmpregadoDeptProjection> search1();

	@Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) "
			+ "FROM Empregado obj "
			+ "WHERE obj.cpf NOT IN( "
			+ "	SELECT obj2.cpf "
			+ "	FROM Empregado obj2 "
			+ "	INNER JOIN obj2.projetosOndeTrabalha "
			+ ")"
			+ "ORDER BY obj.cpf")
	List<EmpregadoDeptDTO> search2();
}
