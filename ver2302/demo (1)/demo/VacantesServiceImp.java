package com.gabriel.licona.valdez.demo.servicee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import com.gabriel.licona.valdez.demo.model.Vacante;

public class VacantesServiceImp implements IntVacantes {

	/*private List<Vacante>lista= null;
	
	public VacantesServiceImp() {
		lista= new LinkedList<>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			Vacante v1= new Vacante();
			v1.setId(1);
			v1.setNombre("programador web");
			v1.setDescripcion("Desarrolla o crear procesos o programa para la web");
			v1.setFecha(LocalDate.parse("12-12-2021", dtf));
			v1.setSalario(2500.00);
			
			Vacante v2= new Vacante();
			v2.setId(2);
			v2.setNombre("Contador publico");
			v2.setDescripcion("Nominas y finanzas");
			v2.setFecha(LocalDate.parse("12-12-2021", dtf));
			v2.setSalario(2500.00);
			
			Vacante v3= new Vacante();
			v3.setId(3);
			v3.setNombre("programador javascript");
			v3.setDescripcion("Desarrolla aplicaciones moviles");
			v3.setFecha(LocalDate.parse("12-12-2021", dtf));
			v3.setSalario(2500.00);
		//*******************************************
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
		}catch(DateTimeParseException ex) {
			System.out.println("Error :" + ex.getMessage());
		}
		}
	@Override
	public List<Vacante> obtenerTodos() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));	
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		int i = 0;
		while(i < lista.size()) {
			Vacante v = lista.get(i);
			if( v.getId() == idVacante) {
				return lista.get(i);
			}
			i++;
		}
		return null;
	}

	@Override
	public void agregar(Vacante IdVacante) {
		// TODO Auto-generated method stub

	}

	@Override
	public int numeroRegistros() {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
