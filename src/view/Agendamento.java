package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControlaAgendamento;
import model.Agendamentos;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Agendamento extends JFrame {
	ControlaAgendamento controlaagendamento = new ControlaAgendamento();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textpaciente;
	private JTable tableagendamento;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agendamento frame = new Agendamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Agendamento() throws ParseException {
		setTitle("Agendamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 623, 73);
		contentPane.add(panel_1);
		
		JLabel lblAgendamentoDeConsulta = new JLabel("Agendamento de Consulta");
		lblAgendamentoDeConsulta.setForeground(Color.WHITE);
		lblAgendamentoDeConsulta.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel_1.add(lblAgendamentoDeConsulta);
		
		JFormattedTextField textdata = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textdata.setBounds(66, 92, 123, 38);
		contentPane.add(textdata);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(21, 104, 35, 14);
		contentPane.add(lblData);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(270, 104, 35, 14);
		contentPane.add(lblHora);
		
		JFormattedTextField texthora = new JFormattedTextField(new MaskFormatter("##:##"));
		texthora.setBounds(339, 92, 123, 38);
		contentPane.add(texthora);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(21, 152, 63, 14);
		contentPane.add(lblPaciente);
		
		textpaciente = new JTextField();
		textpaciente.setBounds(94, 140, 342, 38);
		contentPane.add(textpaciente);
		textpaciente.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = textdata.getText();
				String hora = texthora.getText();
				String paciente = textpaciente.getText();
				
				
				Agendamentos a = new Agendamentos(data, hora, paciente);
				controlaagendamento.cadastraAgenda(a);
				
				DefaultTableModel tabel = (DefaultTableModel)tableagendamento.getModel();
				tabel.addRow(new String[] {data,hora,paciente});
				
				
				textdata.setText("");
				texthora.setText("");
				textpaciente.setText("");
				
				textdata.requestFocus();
				
				JOptionPane.showMessageDialog(null,"Salvo com sucesso senhor "+ paciente  + "no dia" + data + "as" + hora);
					
				
			
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(514, 127, 86, 39);
		contentPane.add(btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 260, 579, 151);
		contentPane.add(scrollPane);
		
		tableagendamento = new JTable();
		scrollPane.setViewportView(tableagendamento);
		tableagendamento.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Hora", "Paciente"
			}
		));
		tableagendamento.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(124, 223, 312, 26);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisar:");
		lblNewLabel_1.setBounds(50, 229, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(137, 422, 86, 39);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tableagendamento.getModel()).removeRow(tableagendamento.getSelectedRow());
			}
		});
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(364, 422, 86, 39);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton_1_1 = new JButton("\uD83D\uDD0E");
		btnNewButton_1_1.setBounds(449, 223, 35, 26);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("Lista de Agendamento:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(197, 189, 214, 23);
		contentPane.add(lblNewLabel);
	}
}
