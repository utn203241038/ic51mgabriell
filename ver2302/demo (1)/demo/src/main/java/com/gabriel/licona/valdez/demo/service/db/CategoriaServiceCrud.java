package com.gabriel.licona.valdez.demo.service.db;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.licona.valdez.demo.model.Categoria;
import com.gabriel.licona.valdez.demo.repository.CategoriasRepository;
import com.gabriel.licona.valdez.demo.servicee.IntServiceCategorias;
@Service
@Primary
public class CategoriaServiceCrud implements IntServiceCategorias {
	@Autowired
	private CategoriasRepository repoCategoria;

	@Override
	public List<Categoria> obtenerCategoria() {
		// TODO Auto-generated method stub
		return (List<Categoria>) repoCategoria.findAll();
	}

	@Override
	public void guardar(Categoria categoria) {
		repoCategoria.save(categoria);

	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria>optional = repoCategoria.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategoria.deleteById(idCategoria);

	}

	@Override
	public Integer numeroCategoria() {
		// TODO Auto-generated method stub
		return (int)repoCategoria.count();
	}

	@Override
	public Page<Categoria> buscarTodos(Pageable page) {
		// TODO Auto-generated method stub
		return repoCategoria.findAll(page);
	}
	


	

}
