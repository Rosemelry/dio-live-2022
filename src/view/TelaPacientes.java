package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControlaPaciente;
import model.Paciente;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class TelaPacientes extends JFrame {
	
	ControlaPaciente controlapaciente = new ControlaPaciente();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textField_5;
	private JTextField textEmail;
	private JTable tablePacientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPacientes frame = new TelaPacientes();
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
	public TelaPacientes() throws ParseException {
		setTitle("Pacientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 569, 73);
		panel.add(panel_1);
		
		JLabel lblCadastroMedicos = new JLabel("Cadastro Pacientes");
		lblCadastroMedicos.setForeground(Color.WHITE);
		lblCadastroMedicos.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel_1.add(lblCadastroMedicos);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(51, 99, 22, 14);
		panel.add(lblNewLabel);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(94, 94, 92, 25);
		panel.add(textID);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(51, 140, 39, 14);
		panel.add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(94, 135, 450, 25);
		panel.add(textNome);
		
		JLabel lblEmail = new JLabel("CPF:");
		lblEmail.setBounds(51, 190, 39, 14);
		panel.add(lblEmail);
		
		JFormattedTextField textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textCpf.setBounds(94, 185, 142, 25);
		panel.add(textCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(51, 240, 55, 14);
		panel.add(lblTelefone);
		
		JFormattedTextField textTele = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		textTele.setBounds(110, 237, 114, 25);
		panel.add(textTele);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setBounds(259, 190, 108, 14);
		panel.add(lblDataDeNascimento);
		
		JFormattedTextField textData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textData.setBounds(366, 185, 114, 25);
		panel.add(textData);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textID.getText();
				String nome = textNome.getText();
				String cpf = textCpf.getText();
				String datanascimento = textData.getText();
				String email = textEmail.getText();
				String telefone = textTele.getText();
				 
				Paciente p = new Paciente(id, nome, cpf, datanascimento,email,telefone );
				controlapaciente.cadastraPaciente(p);
				
				DefaultTableModel tabel = (DefaultTableModel)tablePacientes.getModel();
				tabel.addRow(new String[] {id,nome,cpf,datanascimento,email,telefone});
				
				textID.setText("");
				textNome.setText("");
				textCpf.setText("");
				textData.setText("");
				textEmail.setText("");
				textTele.setText("");

				
				textID.requestFocus();
				
				JOptionPane.showMessageDialog(null,"Salvo com sucesso senhor "+ nome);
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBounds(230, 321, 86, 39);
		panel.add(btnSalvar);
		
		
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setBounds(242, 240, 39, 14);
		panel.add(lblEmail_1);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(291, 235, 260, 25);
		panel.add(textEmail);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Listar Pacientes", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pesquisar:");
		lblNewLabel_1.setBounds(37, 13, 70, 14);
		panel_2.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(117, 1, 312, 39);
		panel_2.add(textField_5);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setBounds(148, 339, 86, 39);
		panel_2.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((DefaultTableModel) tablePacientes.getModel()).removeRow(tablePacientes.getSelectedRow());
			}
		});
		btnExcluir.setForeground(Color.BLACK);
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(307, 339, 86, 39);
		panel_2.add(btnExcluir);
		
		JButton btnNewButton_1_1 = new JButton("\uD83D\uDD0E");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(439, 1, 48, 38);
		panel_2.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 549, 221);
		panel_2.add(scrollPane);
		
		tablePacientes = new JTable();
		scrollPane.setViewportView(tablePacientes);
		tablePacientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Data Nasc", "Email", "Telefone"
			}
		));
		tablePacientes.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
	}
}
