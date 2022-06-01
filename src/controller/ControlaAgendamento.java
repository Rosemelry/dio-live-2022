package controller;

import java.util.ArrayList;

import model.Agendamentos;

public class ControlaAgendamento {
	ArrayList<Agendamentos> agendar = new ArrayList<>();
	
	public void cadastraAgenda(Agendamentos agenda) {
		agendar.add(agenda);
	}

}
