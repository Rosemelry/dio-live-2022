package controller;

import java.util.ArrayList;

import model.Paciente;

public class ControlaPaciente {
	
	ArrayList<Paciente> pacientes = new ArrayList<>();
	
	public void cadastraPaciente(Paciente paciente) {
		pacientes.add(paciente);
	}


}
