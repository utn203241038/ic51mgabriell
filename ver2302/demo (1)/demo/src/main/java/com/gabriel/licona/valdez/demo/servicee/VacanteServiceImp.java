package com.gabriel.licona.valdez.demo.servicee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabriel.licona.valdez.demo.model.Categoria;
import com.gabriel.licona.valdez.demo.model.Vacante;
@Service
public class VacanteServiceImp implements IntVacantes {

private List<Vacante>lista= null;
	
	public VacanteServiceImp() {
		lista= new LinkedList<Vacante>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			Vacante v1= new Vacante();
			Categoria c1 = new Categoria();
			v1.setId(1);
			v1.setNombre("programador web");
			v1.setDescripcion("Desarrolla o crear procesos o programa para la web");
			v1.setFecha("12-12-2021");
			//v1.setFecha(LocalDate.parse("12-12-2021", dtf));
			v1.setSalario(2500.00);
			v1.setDestacado(0);
			v1.setEstatus("Creada");
			v1.setImagen("logo.png");
			v1.setDetalles("<h1>Presentacion de ley</h1><ul><li>capacitacion</ul><li>transporte</li><li>Bono de proactividad</li></ul>");
			c1.setId(2);
			c1.setNombre("Ingenieros");
			c1.setDescripcion("Para realizar proyectos de diferentes rama");
			v1.setCategoria(c1);
			Vacante v2= new Vacante();
			Categoria c2 = new Categoria();
			v2.setId(2);
			v2.setNombre("Contador publico");
			v2.setDescripcion("Nominas y finanzas");
			v2.setFecha("12-12-2021");
			//v2.setFecha(LocalDate.parse("12-12-2021", dtf));
			v2.setSalario(2500.00);
			v2.setDestacado(1);
			v2.setEstatus("Aprobada");
			v2.setImagen("logo10.png");
			v2.setDetalles("<h1>Presentacion de ley</h1><ul><li>capacitacion</ul><li>transporte</li><li>Bono de proactividad</li></ul>");
			c2.setId(3);
			c2.setNombre("Analistas");
			c2.setDescripcion("analizar y describir los proyectos");
			v2.setCategoria(c2);
			
			Vacante v3= new Vacante();
			
			Categoria c3 = new Categoria();
			v3.setId(3);
			v3.setNombre("programador javascript");
			v3.setDescripcion("Desarrolla aplicaciones moviles");
			v3.setFecha("12-12-2021");
			//v3.setFecha(LocalDate.parse("12-12-2021", dtf));
			v3.setSalario(2500.00);
			v3.setDestacado(0);
			v3.setEstatus("creada");
			v3.setImagen("logo1.png");
			v3.setDetalles("<h1>Presentacion de ley</h1><ul><li>capacitacion</ul><li>transporte</li><li>Bono de proactividad</li></ul>");
			c3.setId(1);
			c3.setNombre("Programadores");
			c3.setDescripcion("Desarrollo de aplicaciones web y movil");
			v3.setCategoria(c3);
		//*******************************************
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
		}catch(DateTimeParseException ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		}

	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	public void eliminar(Integer IdVacante) {
		lista.remove(buscarPorId(IdVacante));

	}

	public Vacante buscarPorId(Integer IdVacante) {
		int i = 0;
		while(i < lista.size()) {
			Vacante v = lista.get(i);
			if( v.getId() == IdVacante) {
				return lista.get(i);
			}
			i++;
		}
		return null;
	}

	public void agregar(Vacante vacante) {
		lista.add(vacante);

	}

	public int numeroRegistros() {
	
		int to;
	to=obtenerTodas().size();
		return to;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
