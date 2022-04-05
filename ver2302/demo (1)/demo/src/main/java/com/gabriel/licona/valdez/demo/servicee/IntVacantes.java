package com.gabriel.licona.valdez.demo.servicee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gabriel.licona.valdez.demo.model.Vacante;

public interface IntVacantes {

	public List<Vacante>obtenerTodas();
	public void eliminar(Integer IdVacante);
	public Vacante buscarPorId(Integer IdVacante);
	public void guardar(Vacante vacante);
	public Page<Vacante> buscarTodas(Pageable page);
	//********************************************
	public int numeroRegistros();

}
