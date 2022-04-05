package com.gabriel.licona.valdez.demo.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.licona.valdez.demo.model.Vacante;
import com.gabriel.licona.valdez.demo.repository.VacantesRepository;
import com.gabriel.licona.valdez.demo.servicee.IntVacantes;
@Service
@Primary
public class VacantesServiceCrud implements IntVacantes {

	@Autowired
	private VacantesRepository repoVacantes;
	@Override
	public List<Vacante> obtenerTodos() {
		// TODO Auto-generated method stub
		return (List<Vacante>) repoVacantes.findAll();
	}

	@Override
	public void eliminar(Integer IdVacante) {
		repoVacantes.deleteById(IdVacante);

	}

	@Override
	public Vacante buscarPorId(Integer IdVacante) {
		Optional <Vacante> optional = repoVacantes.findById(IdVacante);
		if (optional.isPresent()) {
	return optional.get();
	}
		return null;
	}

	@Override
	public void agregar(Vacante vacante) {
		repoVacantes.save(vacante);

	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoVacantes.findAll(page);
	}

	@Override
	public int numeroRegistros() {
		// TODO Auto-generated method stub
		return (int) repoVacantes.count();
	}

}
