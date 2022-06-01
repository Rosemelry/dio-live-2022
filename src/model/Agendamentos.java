package model;

public class Agendamentos {
	private String data;
	private String hora;
	private String paciente;
	
	
	public Agendamentos(String data, String hora, String paciente){
		this.data = data;
		this.hora = hora;
		this.paciente = paciente;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getPaciente() {
		return paciente;
	}


	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

}
