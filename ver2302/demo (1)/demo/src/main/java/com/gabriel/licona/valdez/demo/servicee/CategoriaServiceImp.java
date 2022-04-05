package com.gabriel.licona.valdez.demo.servicee;


import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.licona.valdez.demo.model.Categoria;

@Service
public class CategoriaServiceImp implements IntServiceCategorias {

private List<Categoria> lista = null;
	
	public CategoriaServiceImp() {
		lista = new LinkedList<Categoria>();
		Categoria c1= new Categoria();
		c1.setId(1);
		c1.setNombre("Programadores");
		c1.setDescripcion("Desarrollo de aplicaciones web y movil");
		lista.add(c1);
		
		Categoria c2= new Categoria();
		c2.setId(2);
		c2.setNombre("Ingenieros");
		c2.setDescripcion("Para realizar proyectos de diferentes rama");
		lista.add(c2);
		
		Categoria c3= new Categoria();
		c3.setId(3);
		c3.setNombre("Analistas");
		c3.setDescripcion("analizar y describir los proyectos");
		lista.add(c3);
	}
	
	public List<Categoria> obtenerCategoria() {
		// TODO Auto-generated method stub
		return lista;
	}

	public void guardar(Categoria categoria) {
		lista.add(categoria);

	}

	public Categoria buscarPorId(Integer idCategoria) {
		int i = 0;
		while(i < lista.size()) {
			Categoria c = lista.get(i);
			if( c.getId() == idCategoria) {
				return lista.get(i);
			}
			i++;
		}
		return null;
	}

	public void eliminar(Integer idCategoria) {
		lista.remove(buscarPorId(idCategoria));

	}

	public Integer numeroCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
