package APIs_AGCO;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.Cleaner.Cleanable;
import java.security.Principal;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sistema_API_BI extends JFrame {

	private JPanel contentPane;
	private JComboBox cbTipo;
	private JComboBox cbAno;
	private JComboBox cbMes;
	private JComboBox cbTipoAnual;
	private JComboBox cbAnoAnual;
	private JTextField txtEndereço;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JTextField txtNomeArquivoFinal;
	private JTextField txtCliente;

	JFileChooser chooser;
	File[] files;
	ArrayList<String> jsons = new ArrayList<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema_API_BI frame = new Sistema_API_BI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sistema_API_BI() {
		setResizable(false);
		setTitle("Sistema API BI");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\tela.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 545);


		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel Relatórios = new JPanel();
		contentPane.add(Relatórios, "name_870753633825854");
		Relatórios.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Configura\u00E7\u00E3o / Inst\u00E2ncia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 12, 608, 115);
		Relatórios.add(panel);

		JLabel label = new JLabel("Endere\u00E7o:");
		label.setBounds(12, 55, 69, 16);
		panel.add(label);

		txtEndereço = new JTextField();
		txtEndereço.setText("agco.service-now.com");
		txtEndereço.setColumns(10);
		txtEndereço.setBounds(83, 53, 513, 20);
		panel.add(txtEndereço);

		JLabel label_1 = new JLabel("Login:");
		label_1.setBounds(12, 85, 69, 16);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Senha:");
		label_2.setBounds(345, 85, 50, 16);
		panel.add(label_2);

		txtLogin = new JTextField();
		txtLogin.setText("js52206");
		txtLogin.setColumns(10);
		txtLogin.setBounds(83, 83, 183, 20);
		panel.add(txtLogin);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("");
		txtSenha.setBounds(413, 83, 183, 20);
		panel.add(txtSenha);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 27, 69, 16);
		panel.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setText("AGCO");
		txtCliente.setBounds(83, 25, 114, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Chamados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 139, 608, 149);
		Relatórios.add(panel_1);

		cbAno = new JComboBox();
		cbAno.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017"}));
		cbAno.setSelectedIndex(0);
		cbAno.setBounds(68, 25, 186, 25);
		panel_1.add(cbAno);

		cbMes = new JComboBox();
		cbMes.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "01. Janeiro", "02. Fevereiro", "03. Mar\u00E7o", "04. Abril", "05. Maio", "06. Junho", "07. Julho", "08. Agosto", "09. Setembro", "10. Outubro", "11. Novembro", "12. Dezembro"}));
		cbMes.setSelectedIndex(0);
		cbMes.setBounds(410, 25, 186, 25);
		panel_1.add(cbMes);

		JLabel label_3 = new JLabel("Ano:");
		label_3.setBounds(12, 29, 55, 16);
		panel_1.add(label_3);

		JLabel label_4 = new JLabel("M\u00EAs:");
		label_4.setBounds(355, 29, 37, 16);
		panel_1.add(label_4);

		JLabel label_5 = new JLabel("Tipo:");
		label_5.setBounds(12, 66, 55, 16);
		panel_1.add(label_5);

		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "01. Incidente", "02. Incidente SLA", "03. Task", "04. NCR", "05. RITM", "06. RITM_TASK"}));
		cbTipo.setSelectedIndex(0);
		cbTipo.setToolTipText("");
		cbTipo.setBounds(68, 62, 186, 25);
		panel_1.add(cbTipo);

		JButton btnExecutar = new JButton("Executar");
		btnExecutar.setBounds(410, 61, 186, 26);
		panel_1.add(btnExecutar);
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					getRequestChamados();
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnExecutar.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\executar.png"));

		JButton btnAtivos = new JButton("Ativos");
		btnAtivos.setBounds(410, 98, 80, 26);
		panel_1.add(btnAtivos);

		JButton btnBacklog = new JButton("Backlog");
		btnBacklog.setBounds(516, 98, 80, 26);
		panel_1.add(btnBacklog);
		btnBacklog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getRequestBacklog();
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getRequestAtivos();
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton btnRegiao = new JButton("Regi\u00E3o");
		btnRegiao.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\region.png"));
		btnRegiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					getRequestRegion();
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnRegiao.setBounds(10, 300, 143, 26);
		Relatórios.add(btnRegiao);

		JButton btnLocalidade = new JButton("Localidade");
		btnLocalidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getRequestLocation();
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		btnLocalidade.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\location.png"));
		btnLocalidade.setBounds(165, 300, 143, 26);
		Relatórios.add(btnLocalidade);

		JButton btnDepartamento = new JButton("Departamento");
		btnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					getRequestDepartment();
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDepartamento.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\department.png"));
		btnDepartamento.setBounds(320, 300, 143, 26);
		Relatórios.add(btnDepartamento);

		JButton btnUsuarios = new JButton("Usu\u00E1rios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					getRequestUser();
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnUsuarios.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\users.png"));
		btnUsuarios.setBounds(165, 338, 143, 26);
		Relatórios.add(btnUsuarios);

		JButton btnGrupos = new JButton("Grupos");
		btnGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getRequestUserGroup();
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnGrupos.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\group.png"));
		btnGrupos.setBounds(10, 338, 143, 26);
		Relatórios.add(btnGrupos);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 447, 608, 14);
		Relatórios.add(progressBar);

		JButton btnNewButton = new JButton("Contrato SLA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					getRequestContractSLA();
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(475, 300, 143, 26);
		Relatórios.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Business Service");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getRequestBusinessService();
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(320, 338, 143, 26);
		Relatórios.add(btnNewButton_1);

		JPanel RelatóriosOutros = new JPanel();
		contentPane.add(RelatóriosOutros, "name_870744321731249");
		RelatóriosOutros.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Unificar Arquivos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_2.setBounds(12, 184, 530, 93);
		RelatóriosOutros.add(panel_2);
		panel_2.setLayout(null);

		JButton btnUnirArquivosIncidentes = new JButton("Selecionar Arquivos...");
		btnUnirArquivosIncidentes.setEnabled(false);
		btnUnirArquivosIncidentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				chooser.showOpenDialog(new JOptionPane());
				files = chooser.getSelectedFiles();

				for (int i = 0; i < files.length; i++) {
					jsons.add(fileToString(files[i]));
				}
				LoadPage lp = new LoadPage();
				String mj = lp.mergeJSON(jsons);
				WriteInFile(mj);

				jsons.clear();

			}
		});
		btnUnirArquivosIncidentes.setBounds(332, 55, 186, 26);
		panel_2.add(btnUnirArquivosIncidentes);


		txtNomeArquivoFinal = new JTextField();
		txtNomeArquivoFinal.setEnabled(false);
		txtNomeArquivoFinal.setBounds(178, 23, 340, 20);
		panel_2.add(txtNomeArquivoFinal);
		txtNomeArquivoFinal.setColumns(10);

		JLabel lblNomeDoArquivo = new JLabel("Nome do Arquivo Final:");
		lblNomeDoArquivo.setBounds(12, 25, 148, 16);
		panel_2.add(lblNomeDoArquivo);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Relat\u00F3rio Anual", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 35, 530, 100);
		RelatóriosOutros.add(panel_3);
		panel_3.setLayout(null);

		JButton btnExecutarAnual = new JButton("Executar");
		btnExecutarAnual.setEnabled(false);
		btnExecutarAnual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Executa o relatório do ano inteiro

				try {
					getRequestChamadosAnual();
				} catch (HttpException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnExecutarAnual.setBounds(332, 60, 186, 26);
		panel_3.add(btnExecutarAnual);

		cbAnoAnual = new JComboBox();
		cbAnoAnual.setEnabled(false);
		cbAnoAnual.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017"}));
		cbAnoAnual.setBounds(84, 24, 186, 25);
		panel_3.add(cbAnoAnual);

		cbTipoAnual = new JComboBox();
		cbTipoAnual.setEnabled(false);
		cbTipoAnual.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "01. Incidente", "02. Incidente SLA", "03. Task", "04. NCR", "05. RITM", "06. RITM_TASK"}));
		cbTipoAnual.setSelectedIndex(0);
		cbTipoAnual.setBounds(84, 61, 186, 25);
		panel_3.add(cbTipoAnual);
		cbTipoAnual.setToolTipText("");

		JLabel label_14 = new JLabel("Ano:");
		label_14.setBounds(12, 28, 55, 16);
		panel_3.add(label_14);

		JLabel label_16 = new JLabel("Tipo:");
		label_16.setBounds(12, 65, 55, 16);
		panel_3.add(label_16);

		JCheckBox ckbRelatorioAnual = new JCheckBox("");
		ckbRelatorioAnual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if(ckbRelatorioAnual.isSelected() == true) {
					btnExecutarAnual.setEnabled(true);
					cbAnoAnual.setEnabled(true);
					cbTipoAnual.setEnabled(true);
				}else {
					btnExecutarAnual.setEnabled(false);
					cbAnoAnual.setEnabled(false);
					cbTipoAnual.setEnabled(false);
				}

			}
		});
		ckbRelatorioAnual.setBounds(12, 8, 112, 24);
		RelatóriosOutros.add(ckbRelatorioAnual);

		JCheckBox ckbUnificarArquivos = new JCheckBox("");
		ckbUnificarArquivos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(ckbUnificarArquivos.isSelected() == true) {
					txtNomeArquivoFinal.setEnabled(true);
					btnUnirArquivosIncidentes.setEnabled(true);
				}else {
					txtNomeArquivoFinal.setEnabled(false);
					btnUnirArquivosIncidentes.setEnabled(false);
				}
			}
		});
		ckbUnificarArquivos.setBounds(12, 152, 112, 24);
		RelatóriosOutros.add(ckbUnificarArquivos);

		JPanel Suporte = new JPanel();
		contentPane.add(Suporte, "name_870633674395929");
		Suporte.setLayout(null);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\help.png"));
		label_6.setBounds(288, 44, 256, 291);
		Suporte.add(label_6);

		JPanel Sobre = new JPanel();
		contentPane.add(Sobre, "name_870827713563303");
		Sobre.setLayout(null);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\jmsilva1\\Documents\\000_Power_BI_Desktop\\00_Teste_JSON\\Sistema_API_BI_v5\\icones\\sobre_2.png"));
		label_7.setBounds(293, 90, 249, 287);
		Sobre.add(label_7);

		JLabel label_8 = new JLabel("Esse sistema faz a atualiza\u00E7\u00E3o dos arquivos JSON,");
		label_8.setEnabled(false);
		label_8.setBounds(12, 46, 330, 14);
		Sobre.add(label_8);

		JLabel label_9 = new JLabel("Sistema API BI");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_9.setEnabled(false);
		label_9.setBounds(12, 12, 148, 23);
		Sobre.add(label_9);

		JLabel label_10 = new JLabel("para que depois possa ser alimentado os relat\u00F3rios");
		label_10.setEnabled(false);
		label_10.setBounds(12, 58, 356, 14);
		Sobre.add(label_10);

		JLabel label_11 = new JLabel("e dashboads do Power BI.");
		label_11.setEnabled(false);
		label_11.setBounds(12, 71, 304, 14);
		Sobre.add(label_11);

		JLabel lblVersoagosto = new JLabel("Vers\u00E3o: 8.0 (agosto de 2019)");
		lblVersoagosto.setEnabled(false);
		lblVersoagosto.setBounds(12, 260, 219, 14);
		Sobre.add(lblVersoagosto);

		JLabel label_13 = new JLabel("Desenvolvido por J\u00F4natas Martins da Silva");
		label_13.setEnabled(false);
		label_13.setBounds(12, 285, 249, 14);
		Sobre.add(label_13);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmSair);

		JMenu mnNewMenu_1 = new JMenu("Relat\u00F3rio");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatórios.setVisible(true);
				RelatóriosOutros.setVisible(false);
				Sobre.setVisible(false);
				Suporte.setVisible(false);				
			}
		});
		mnNewMenu_1.add(mntmPrincipal);

		JSeparator separator = new JSeparator();
		mnNewMenu_1.add(separator);

		JMenuItem mntmOutros = new JMenuItem("Outros Relat\u00F3rios");
		mntmOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatórios.setVisible(false);
				RelatóriosOutros.setVisible(true);
				Sobre.setVisible(false);
				Suporte.setVisible(false);	
			}
		});
		mnNewMenu_1.add(mntmOutros);

		JMenu mnSobre = new JMenu("Ajuda");
		menuBar.add(mnSobre);

		JMenuItem mntmSuporte = new JMenuItem("Suporte");
		mntmSuporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatórios.setVisible(false);
				RelatóriosOutros.setVisible(false);
				Sobre.setVisible(false);
				Suporte.setVisible(true);
			}
		});
		mnSobre.add(mntmSuporte);

		JSeparator separator_1 = new JSeparator();
		mnSobre.add(separator_1);

		JMenuItem mntmAjuda = new JMenuItem("Sobre");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatórios.setVisible(false);
				RelatóriosOutros.setVisible(false);
				Sobre.setVisible(true);
				Suporte.setVisible(false);
			}
		});
		mnSobre.add(mntmAjuda);

		chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);

	}
	//==========================================================================================================
	//TESTE GERAL CHAMADOS
	public void getRequestChamados() throws HttpException, IOException {

		//String tipoEndereco = "-";
		int tipo = 0;
		String tableApi;

		String ano;

		String dataInicio1 = null;
		String dataInicio2 = null;
		String dataMeio1 = null;
		String dataMeio2 = null;
		String dataFim1 = null;
		String dataFim2 = null;

		String mesInicio = null;
		String mesMeio = null;
		String mesFim = null;

		String cliente = txtCliente.getText();

		//TIPO
		// 01. Incidente
		// incident
		// 02. Incidente SLA
		// incident_sla
		// 03. Task
		// task
		// 04. NCR
		// new_call
		// 05. RITM
		// sc_req_item
		// 06. RITM_TASK
		// task

		if(cbTipo.getSelectedIndex() == 1) {// 01. Incidente
			tableApi = "incident";
			tipo = 1;
		}else if(cbTipo.getSelectedIndex() == 2) {// 02. Incidente SLA
			tableApi = "incident_sla";
			tipo = 2;
		}else if(cbTipo.getSelectedIndex() == 3) {// 03. Task
			tableApi = "task";
			tipo = 3;
		}else if(cbTipo.getSelectedIndex() == 4) {// 04. NCR
			tableApi = "new_call";
			tipo = 4;
		}else if(cbTipo.getSelectedIndex() == 5) {// 05. RITM
			tableApi = "sc_req_item";
			tipo = 5;
		}else if(cbTipo.getSelectedIndex() == 6) {// 06. RITM_TASK
			tableApi = "task";
			tipo = 6;
		}else {
			tableApi = null;
		}

		//ANO
		if(cbAno.getSelectedItem().toString().equals("2017")) {
			ano = "2017";
		}else if(cbAno.getSelectedItem().toString().equals("2018")) {
			ano = "2018";
		}else if(cbAno.getSelectedItem().toString().equals("2019")) {
			ano = "2019";
		}else {
			ano = "";
		}
		//MES
		if(cbMes.getSelectedIndex() == 1) {
			//Periodo
			dataInicio1 = "01-01";
			dataInicio2 = "01-10";
			dataMeio1 = "01-11";
			dataMeio2 = "01-21";
			dataFim1 = "01-22";
			dataFim2 = "01-31";

			mesInicio = "janeiro_inicio";
			mesMeio = "janeiro_meio";
			mesFim = "janeiro_fim";

		}else if(cbMes.getSelectedIndex() == 2) {
			//Periodo
			dataInicio1 = "02-01";
			dataInicio2 = "02-10";
			dataMeio1 = "02-11";
			dataMeio2 = "02-21";
			dataFim1 = "02-22";
			dataFim2 = "02-28";

			mesInicio = "fevereiro_inicio";
			mesMeio = "fevereiro_meio";
			mesFim = "fevereiro_fim";

		}else if(cbMes.getSelectedIndex() == 3) {
			//Periodo
			dataInicio1 = "03-01";
			dataInicio2 = "03-10";
			dataMeio1 = "03-11";
			dataMeio2 = "03-21";
			dataFim1 = "03-22";
			dataFim2 = "03-31";

			mesInicio = "março_inicio";
			mesMeio = "março_meio";
			mesFim = "março_fim";

		}else if(cbMes.getSelectedIndex() == 4) {
			//Periodo
			dataInicio1 = "04-01";
			dataInicio2 = "04-10";
			dataMeio1 = "04-11";
			dataMeio2 = "04-21";
			dataFim1 = "04-22";
			dataFim2 = "04-30";
			mesInicio = "abril_inicio";
			mesMeio = "abril_meio";
			mesFim = "abril_fim";

		}else if(cbMes.getSelectedIndex() == 5) {
			dataInicio1 = "05-01";
			dataInicio2 = "05-10";
			dataMeio1 = "05-11";
			dataMeio2 = "05-21";
			dataFim1 = "05-22";
			dataFim2 = "05-31";
			mesInicio = "maio_inicio";
			mesMeio = "maio_meio";
			mesFim = "maio_fim";

		}else if(cbMes.getSelectedIndex() == 6) {
			dataInicio1 = "06-01";
			dataInicio2 = "06-10";
			dataMeio1 = "06-11";
			dataMeio2 = "06-21";
			dataFim1 = "06-22";
			dataFim2 = "06-30";
			mesInicio = "junho_inicio";
			mesMeio = "junho_meio";
			mesFim = "junho_fim";

		}else if(cbMes.getSelectedIndex() == 7) {
			dataInicio1 = "07-01";
			dataInicio2 = "07-10";
			dataMeio1 = "07-11";
			dataMeio2 = "07-21";
			dataFim1 = "07-22";
			dataFim2 = "07-31";
			mesInicio = "julho_inicio";
			mesMeio = "julho_meio";
			mesFim = "julho_fim";

		}else if(cbMes.getSelectedIndex() == 8) {
			dataInicio1 = "08-01";
			dataInicio2 = "08-10";
			dataMeio1 = "08-11";
			dataMeio2 = "08-21";
			dataFim1 = "08-22";
			dataFim2 = "08-31";
			mesInicio = "agosto_inicio";
			mesMeio = "agosto_meio";
			mesFim = "agosto_fim";

		}else if(cbMes.getSelectedIndex() == 9) {
			dataInicio1 = "09-01";
			dataInicio2 = "09-10";
			dataMeio1 = "09-11";
			dataMeio2 = "09-21";
			dataFim1 = "09-22";
			dataFim2 = "09-30";
			mesInicio = "setembro_inicio";
			mesMeio = "setembro_meio";
			mesFim = "setembro_fim";

		}else if(cbMes.getSelectedIndex() == 10) {
			dataInicio1 = "10-01";
			dataInicio2 = "10-10";
			dataMeio1 = "10-11";
			dataMeio2 = "10-21";
			dataFim1 = "10-22";
			dataFim2 = "10-31";
			mesInicio = "outubro_inicio";
			mesMeio = "outubro_meio";
			mesFim = "outubro_fim";

		}else if(cbMes.getSelectedIndex() == 11) {
			dataInicio1 = "11-01";
			dataInicio2 = "11-10";
			dataMeio1 = "11-11";
			dataMeio2 = "11-21";
			dataFim1 = "11-22";
			dataFim2 = "11-30";
			mesInicio = "novembro_inicio";
			mesMeio = "novembro_meio";
			mesFim = "novembro_fim";

		}else if(cbMes.getSelectedIndex() == 12) {
			dataInicio1 = "12-01";
			dataInicio2 = "12-10";
			dataMeio1 = "12-11";
			dataMeio2 = "12-21";
			dataFim1 = "12-22";
			dataFim2 = "12-30";
			mesInicio = "dezembro_inicio";
			mesMeio = "dezembro_meio";
			mesFim = "dezembro_fim";
		}

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {

			if(tipo == 1) {//01. INCIDENTES

				//A PARTIR DO DIA 01 ATÉ O DIA 10
				HttpGet httpget_Incident = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_resolvedBETWEENjavascript:gs.dateGenerate(%27"+ano+"-"+dataInicio1+"%27%2C%2700:00:00%27)@javascript:gs.dateGenerate(%27"+ano+"-"+dataInicio2+"%27%2C%2723:59:59%27)%5Eassignment_groupLIKE_SA&sysparm_first_row=1&sysparm_view=");

				httpget_Incident.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpget_Incident.getRequestLine());
				CloseableHttpResponse responseIncident = httpclient.execute(httpget_Incident);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseIncident.getStatusLine());
					String responseBodyIncident = EntityUtils.toString(responseIncident.getEntity());
					System.out.println(responseBodyIncident);

					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_"+ano+"\\tb_incident_"+mesInicio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyIncident).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();

					}

				} finally {
					responseIncident.close();
				}

				//A PARTIR DO DIA 11 ATÉ 21
				HttpGet httpgetIncident2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_resolvedBETWEENjavascript:gs.dateGenerate(%27"+ano+"-"+dataMeio1+"%27%2C%2700:00:00%27)@javascript:gs.dateGenerate(%27"+ano+"-"+dataMeio2+"%27%2C%2723:59:59%27)%5Eassignment_groupLIKE_SA&sysparm_first_row=1&sysparm_view=");

				httpgetIncident2.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetIncident2.getRequestLine());
				CloseableHttpResponse responseIncident2 = httpclient.execute(httpgetIncident2);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseIncident2.getStatusLine());
					String responseBodyIncident2 = EntityUtils.toString(responseIncident2.getEntity());
					System.out.println(responseBodyIncident2);

					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_"+ano+"\\tb_incident_"+mesMeio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyIncident2).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
				} finally {
					responseIncident2.close();
				}

				//A PARTIR DO DIA 22 ATÉ FINAL DO MES
				HttpGet httpgetIncident3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_resolvedBETWEENjavascript:gs.dateGenerate(%27"+ano+"-"+dataFim1+"%27%2C%2700:00:00%27)@javascript:gs.dateGenerate(%27"+ano+"-"+dataFim2+"%27%2C%2723:59:59%27)%5Eassignment_groupLIKE_SA&sysparm_first_row=1&sysparm_view=");

				httpgetIncident3.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetIncident3.getRequestLine());
				CloseableHttpResponse responseIncident3 = httpclient.execute(httpgetIncident3);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseIncident3.getStatusLine());
					String responseBodyIncident3 = EntityUtils.toString(responseIncident3.getEntity());
					System.out.println(responseBodyIncident3);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_"+ano+"\\tb_incident_"+mesFim+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyIncident3).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseIncident3.close();
				}

			}else if(tipo == 2) {//INCIDENTE_SLA

				//A PARTIR DO DIA 01 ATÉ O DIA 10
				HttpGet httpgetINCSLA = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=inc_u_resolvedBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataInicio2+"'%2C'23%3A59%3A59')%5Einc_assignment_groupLIKE_SA");

				httpgetINCSLA.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetINCSLA.getRequestLine());
				CloseableHttpResponse responseINCSLA = httpclient.execute(httpgetINCSLA);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseINCSLA.getStatusLine());
					String responseBodyINCSLA = EntityUtils.toString(responseINCSLA.getEntity());
					System.out.println(responseBodyINCSLA);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_sla_"+ano+"\\tb_incident_sla_"+mesInicio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyINCSLA).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();

					}
					//-------------------------------------------------------------------
				} finally {
					responseINCSLA.close();
				}

				//A PARTIR DO DIA 11 ATÉ O 21
				HttpGet httpgetINCSLA2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=inc_u_resolvedBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataMeio2+"'%2C'23%3A59%3A59')%5Einc_assignment_groupLIKE_SA");

				httpgetINCSLA2.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetINCSLA2.getRequestLine());
				CloseableHttpResponse responseINCSLA2 = httpclient.execute(httpgetINCSLA2);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseINCSLA2.getStatusLine());
					String responseBodyINCSLA2 = EntityUtils.toString(responseINCSLA2.getEntity());
					System.out.println(responseBodyINCSLA2);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_sla_"+ano+"\\tb_incident_sla_"+mesMeio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyINCSLA2).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseINCSLA2.close();
				}

				//A PARTIR DO DIA 22 ATÉ O FINAL DO MÊS
				HttpGet httpgetINCSLA3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=inc_u_resolvedBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataFim2+"'%2C'23%3A59%3A59')%5Einc_assignment_groupLIKE_SA");

				httpgetINCSLA3.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetINCSLA3.getRequestLine());
				CloseableHttpResponse responseINCSLA3 = httpclient.execute(httpgetINCSLA3);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseINCSLA3.getStatusLine());
					String responseBodyINCSLA3 = EntityUtils.toString(responseINCSLA3.getEntity());
					System.out.println(responseBodyINCSLA3);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_sla_"+ano+"\\tb_incident_sla_"+mesFim+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyINCSLA3).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseINCSLA3.close();
				}

			}else if(tipo == 3) {//TASK

				//A PARTIR DO DIA 01 ATÉ O DIA 15
				HttpGet httpgetTask = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHTASK%5Eassignment_groupLIKE_SA%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

				httpgetTask.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetTask.getRequestLine());
				CloseableHttpResponse responseTask = httpclient.execute(httpgetTask);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseTask.getStatusLine());
					String responseBodyTask = EntityUtils.toString(responseTask.getEntity());
					System.out.println(responseBodyTask);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_task_"+ano+"\\tb_task_"+mesInicio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyTask).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseTask.close();
				}

				//A PARTIR DO DIA 11 ATÉ O DIA 21
				HttpGet httpgetTask2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHTASK%5Eassignment_groupLIKE_SA%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

				httpgetTask2.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetTask2.getRequestLine());
				CloseableHttpResponse responseTask2 = httpclient.execute(httpgetTask2);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseTask2.getStatusLine());
					String responseBodyTask2 = EntityUtils.toString(responseTask2.getEntity());
					System.out.println(responseBodyTask2);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_task_"+ano+"\\tb_task_"+mesMeio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyTask2).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseTask2.close();
				}


				//A PARTIR DO DIA 22 ATÉ O FINAL DO MES
				HttpGet httpgetTask3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHTASK%5Eassignment_groupLIKE_SA%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataFim2+"'%2C'23%3A59%3A59')");

				httpgetTask3.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetTask3.getRequestLine());
				CloseableHttpResponse responseTask3 = httpclient.execute(httpgetTask3);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseTask3.getStatusLine());
					String responseBodyTask3 = EntityUtils.toString(responseTask3.getEntity());
					System.out.println(responseBodyTask3);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_task_"+ano+"\\tb_task_"+mesFim+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyTask3).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseTask3.close();
				}

			}else if(tipo == 4) {//NCR

				//A PARTIR DO DIA 01 ATÉ O DIA 15
				HttpGet httpgetNCR = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_ad_hoc_grp_assign_to%3Db44fc1e80a0a3c9f012f639eadb791e1%5Esys_created_onBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

				httpgetNCR.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetNCR.getRequestLine());
				CloseableHttpResponse responseNCR = httpclient.execute(httpgetNCR);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseNCR.getStatusLine());
					String responseBodyNCR = EntityUtils.toString(responseNCR.getEntity());
					System.out.println(responseBodyNCR);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ncr_"+ano+"\\tb_ncr_"+mesInicio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyNCR).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}

				} finally {
					responseNCR.close();
				}

				//A PARTIR DO DIA 11 ATÉ O DIA 21
				HttpGet httpgetNCR2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_ad_hoc_grp_assign_to%3Db44fc1e80a0a3c9f012f639eadb791e1%5Esys_created_onBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

				httpgetNCR2.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetNCR2.getRequestLine());
				CloseableHttpResponse responseNCR2 = httpclient.execute(httpgetNCR2);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseNCR2.getStatusLine());
					String responseBodyNCR2 = EntityUtils.toString(responseNCR2.getEntity());
					System.out.println(responseBodyNCR2);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ncr_"+ano+"\\tb_ncr_"+mesMeio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyNCR2).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseNCR2.close();
				}

				//A PARTIR DO DIA 22 ATÉ O FIM DO MÊS
				HttpGet httpgetNCR3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_ad_hoc_grp_assign_to%3Db44fc1e80a0a3c9f012f639eadb791e1%5Esys_created_onBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataFim2+"'%2C'23%3A59%3A59')");

				httpgetNCR3.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetNCR2.getRequestLine());
				CloseableHttpResponse responseNCR3 = httpclient.execute(httpgetNCR3);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseNCR3.getStatusLine());
					String responseBodyNCR3 = EntityUtils.toString(responseNCR3.getEntity());
					System.out.println(responseBodyNCR3);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ncr_"+ano+"\\tb_ncr_"+mesFim+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyNCR3).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseNCR3.close();
				}

			}else if(tipo == 5) {//RITM

				//A PARTIR DO DIA 01 ATÉ O DIA 10
				HttpGet httpgetRITM = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=closed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

				httpgetRITM.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetRITM.getRequestLine());
				CloseableHttpResponse responseRITM = httpclient.execute(httpgetRITM);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseRITM.getStatusLine());
					String responseBodyRITM = EntityUtils.toString(responseRITM.getEntity());
					System.out.println(responseBodyRITM);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_"+ano+"\\tb_ritm_"+mesInicio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyRITM).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();

					}
					//-------------------------------------------------------------------
				} finally {
					responseRITM.close();
				}

				//A PARTIR DO DIA 11 ATÉ O DIA 21
				HttpGet httpgetRITM2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=closed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

				httpgetRITM2.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetRITM2.getRequestLine());
				CloseableHttpResponse responseRITM2 = httpclient.execute(httpgetRITM2);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseRITM2.getStatusLine());
					String responseBodyRITM2 = EntityUtils.toString(responseRITM2.getEntity());
					System.out.println(responseBodyRITM2);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_"+ano+"\\tb_ritm_"+mesMeio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyRITM2).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();

					}
					//-------------------------------------------------------------------
				} finally {
					responseRITM2.close();
				}

				//A PARTIR DO DIA 22 ATÉ ÚLTIMO DIA DO MÊS
				HttpGet httpgetRITM3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=closed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataFim2+"'%2C'23%3A59%3A59')");

				httpgetRITM3.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetRITM3.getRequestLine());
				CloseableHttpResponse responseRITM3 = httpclient.execute(httpgetRITM3);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseRITM3.getStatusLine());
					String responseBodyRITM3 = EntityUtils.toString(responseRITM3.getEntity());
					System.out.println(responseBodyRITM3);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_"+ano+"\\tb_ritm_"+mesFim+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyRITM3).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseRITM3.close();
				}

			}else if(tipo == 6) {//RITM_TASK

				//A PARTIR DO DIA 01 ATÉ O DIA 10
				HttpGet httpgetRITMTASK = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHRITM%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

				httpgetRITMTASK.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetRITMTASK.getRequestLine());
				CloseableHttpResponse responseRITMTASK = httpclient.execute(httpgetRITMTASK);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseRITMTASK.getStatusLine());
					String responseBodyRITMTASK = EntityUtils.toString(responseRITMTASK.getEntity());
					System.out.println(responseBodyRITMTASK);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_task_"+ano+"\\tb_ritm_task_"+mesInicio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyRITMTASK).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseRITMTASK.close();
				}

				//A PARTIR DO DIA 11 ATÉ O DIA 21
				HttpGet httpgetRITMTASK2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHRITM%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

				httpgetRITMTASK2.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetRITMTASK2.getRequestLine());
				CloseableHttpResponse responseRITMTASK2 = httpclient.execute(httpgetRITMTASK2);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseRITMTASK2.getStatusLine());
					String responseBodyRITMTASK2 = EntityUtils.toString(responseRITMTASK2.getEntity());
					System.out.println(responseBodyRITMTASK2);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_task_"+ano+"\\tb_ritm_task_"+mesMeio+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyRITMTASK2).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseRITMTASK2.close();
				}

				//A PARTIR DO DIA 22 ATÉ O FINAL DO MES
				HttpGet httpgetRITMTASK3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHRITM%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+ano+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+ano+"-"+dataFim2+"'%2C'23%3A59%3A59')");

				httpgetRITMTASK3.setHeader("Accept", "application/json");
				System.out.println("Executing request " + httpgetRITMTASK3.getRequestLine());
				CloseableHttpResponse responseRITMTASK3 = httpclient.execute(httpgetRITMTASK3);
				try {
					System.out.println("----------------------------------------");
					System.out.println(responseRITMTASK3.getStatusLine());
					String responseBodyRITMTASK3 = EntityUtils.toString(responseRITMTASK3.getEntity());
					System.out.println(responseBodyRITMTASK3);
					//-------------------------------------------------------------------
					FileWriter writeFile = null;            
					try{
						writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_task_"+ano+"\\tb_ritm_task_"+mesFim+"_"+ano+".json");
						//Escreve no arquivo conteudo do Objeto JSON
						writeFile.write(((Object) responseBodyRITMTASK3).toString());
						writeFile.close();
					}
					catch(IOException e){
						e.printStackTrace();
					}
					//-------------------------------------------------------------------
				} finally {
					responseRITMTASK3.close();
				}

			}



		} finally {
			httpclient.close();
		}
	}

	//==========================================================================================================
	//LOCATION

	public void getRequestLocation() throws HttpException, IOException {

		String cliente = txtCliente.getText();

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/cmn_location");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_location.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	//==========================================================================================================
	//REGION

	public void getRequestRegion() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/u_region");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_region.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}


	//==========================================================================================================
	//CONTRACT SLA

	public void getRequestContractSLA() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/contract_sla");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_contract_sla.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}



	//==========================================================================================================
	//BUSINESS SERVICE

	public void getRequestBusinessService() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/cmdb_ci_service");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_cmdb_ci_service.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	//==========================================================================================================
	//DEPARTMENT

	public void getRequestDepartment() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/cmn_department");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_department.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	//==========================================================================================================
	//USER GROUP

	public void getRequestUserGroup() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/sys_user_group");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_user_group.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	//==========================================================================================================
	//USER

	public void getRequestUser() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/sys_user?sysparm_query=active%3Dtrue%5Elocation.u_service_desk_support_groupLIKE_SA");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_user.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	//==========================================================================================================
	//TESTE GERAL CHAMADOS ANUAL

	public void getRequestChamadosAnual() throws HttpException, IOException {

		String anoAnual;
		int tipo = 0;
		String tableApi;

		String dataInicio1 = null;
		String dataInicio2 = null;
		String dataMeio1 = null;
		String dataMeio2 = null;
		String dataFim1 = null;
		String dataFim2 = null;

		String mesInicio = null;
		String mesMeio = null;
		String mesFim = null;

		String cliente = txtCliente.getText();

		//TIPO
		if(cbTipoAnual.getSelectedIndex() == 1) {// 01. Incidente
			tableApi = "incident";
			tipo = 1;
		}else if(cbTipoAnual.getSelectedIndex() == 2) {// 02. Incidente SLA
			tableApi = "incident_sla";
			tipo = 2;
		}else if(cbTipoAnual.getSelectedIndex() == 3) {// 03. Task
			tableApi = "task";
			tipo = 3;
		}else if(cbTipoAnual.getSelectedIndex() == 4) {// 04. NCR
			tableApi = "new_call";
			tipo = 4;
		}else if(cbTipoAnual.getSelectedIndex() == 5) {// 05. RITM
			tableApi = "sc_req_item";
			tipo = 5;
		}else if(cbTipoAnual.getSelectedIndex() == 6) {// 06. RITM_TASK
			tableApi = "task";
			tipo = 6;
		}else {
			tableApi = null;
		}
		//ANO
		if(cbAnoAnual.getSelectedItem().toString().equals("2017")) {
			anoAnual = "2017";
		}else if(cbAnoAnual.getSelectedItem().toString().equals("2018")) {
			anoAnual = "2018";
		}else if(cbAnoAnual.getSelectedItem().toString().equals("2019")) {
			anoAnual = "2019";
		}else {
			anoAnual = "";
		}

		//MES
		if(txtLogin.getText().equals("") || txtSenha.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Erro! Verifique se as configurações estão corretas.");
		}else {

			for(int i = 1;i<13;i++) {

				if(i == 1) {
					dataInicio1 = "01-01";
					dataInicio2 = "01-10";
					dataMeio1 = "01-11";
					dataMeio2 = "01-21";
					dataFim1 = "01-22";
					dataFim2 = "01-31";

					mesInicio = "janeiro_inicio";
					mesMeio = "janeiro_meio";
					mesFim = "janeiro_fim";

				}else if(i == 2) {
					dataInicio1 = "02-01";
					dataInicio2 = "02-10";
					dataMeio1 = "02-11";
					dataMeio2 = "02-21";
					dataFim1 = "02-22";
					dataFim2 = "02-28";

					mesInicio = "fevereiro_inicio";
					mesMeio = "fevereiro_meio";
					mesFim = "fevereiro_fim";

				}else if(i == 3) {
					dataInicio1 = "03-01";
					dataInicio2 = "03-10";
					dataMeio1 = "03-11";
					dataMeio2 = "03-21";
					dataFim1 = "03-22";
					dataFim2 = "03-31";

					mesInicio = "março_inicio";
					mesMeio = "março_meio";
					mesFim = "março_fim";

				}else if(i == 4) {
					dataInicio1 = "04-01";
					dataInicio2 = "04-10";
					dataMeio1 = "04-11";
					dataMeio2 = "04-21";
					dataFim1 = "04-22";
					dataFim2 = "04-30";
					mesInicio = "abril_inicio";
					mesMeio = "abril_meio";
					mesFim = "abril_fim";

				}else if(i == 5) {
					dataInicio1 = "05-01";
					dataInicio2 = "05-10";
					dataMeio1 = "05-11";
					dataMeio2 = "05-21";
					dataFim1 = "05-22";
					dataFim2 = "05-31";
					mesInicio = "maio_inicio";
					mesMeio = "maio_meio";
					mesFim = "maio_fim";


				}else if(i == 6) {
					dataInicio1 = "06-01";
					dataInicio2 = "06-10";
					dataMeio1 = "06-11";
					dataMeio2 = "06-21";
					dataFim1 = "06-22";
					dataFim2 = "06-30";
					mesInicio = "junho_inicio";
					mesMeio = "junho_meio";
					mesFim = "junho_fim";

				}else if(i == 7) {
					dataInicio1 = "07-01";
					dataInicio2 = "07-10";
					dataMeio1 = "07-11";
					dataMeio2 = "07-21";
					dataFim1 = "07-22";
					dataFim2 = "07-31";
					mesInicio = "julho_inicio";
					mesMeio = "julho_meio";
					mesFim = "julho_fim";

				}else if(i == 8) {
					dataInicio1 = "08-01";
					dataInicio2 = "08-10";
					dataMeio1 = "08-11";
					dataMeio2 = "08-21";
					dataFim1 = "08-22";
					dataFim2 = "08-31";
					mesInicio = "agosto_inicio";
					mesMeio = "agosto_meio";
					mesFim = "agosto_fim";


				}else if(i == 9) {
					dataInicio1 = "09-01";
					dataInicio2 = "09-10";
					dataMeio1 = "09-11";
					dataMeio2 = "09-21";
					dataFim1 = "09-22";
					dataFim2 = "09-30";
					mesInicio = "setembro_inicio";
					mesMeio = "setembro_meio";
					mesFim = "setembro_fim";

				}else if(i == 10) {
					dataInicio1 = "10-01";
					dataInicio2 = "10-10";
					dataMeio1 = "10-11";
					dataMeio2 = "10-21";
					dataFim1 = "10-22";
					dataFim2 = "10-31";
					mesInicio = "outubro_inicio";
					mesMeio = "outubro_meio";
					mesFim = "outubro_fim";

				}else if(i == 11) {
					dataInicio1 = "11-01";
					dataInicio2 = "11-10";
					dataMeio1 = "11-11";
					dataMeio2 = "11-21";
					dataFim1 = "11-22";
					dataFim2 = "11-30";
					mesInicio = "novembro_inicio";
					mesMeio = "novembro_meio";
					mesFim = "novembro_fim";

				}else if(i == 12) {
					dataInicio1 = "12-01";
					dataInicio2 = "12-10";
					dataMeio1 = "12-11";
					dataMeio2 = "12-21";
					dataFim1 = "12-22";
					dataFim2 = "12-30";
					mesInicio = "dezembro_inicio";
					mesMeio = "dezembro_meio";
					mesFim = "dezembro_fim";
				}


				CredentialsProvider credsProvider = new BasicCredentialsProvider();
				credsProvider.setCredentials(
						new AuthScope(new HttpHost(txtEndereço.getText())),
						new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
				CloseableHttpClient httpclient = HttpClients.custom()
						.setDefaultCredentialsProvider(credsProvider)
						.build();



				try {

					if(tipo == 1) {//01. INCIDENTES

						//A PARTIR DO DIA 01 ATÉ O DIA 10
						HttpGet httpget_Incident = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_resolvedBETWEENjavascript:gs.dateGenerate(%27"+anoAnual+"-"+dataInicio1+"%27%2C%2700:00:00%27)@javascript:gs.dateGenerate(%27"+anoAnual+"-"+dataInicio2+"%27%2C%2723:59:59%27)%5Eassignment_groupLIKE_SA&sysparm_first_row=1&sysparm_view=");

						httpget_Incident.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpget_Incident.getRequestLine());
						CloseableHttpResponse responseIncident = httpclient.execute(httpget_Incident);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseIncident.getStatusLine());
							String responseBodyIncident = EntityUtils.toString(responseIncident.getEntity());
							System.out.println(responseBodyIncident);

							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_"+anoAnual+"\\tb_incident_"+mesInicio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyIncident).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();

							}

						} finally {
							responseIncident.close();
						}

						//A PARTIR DO DIA 11 ATÉ 21
						HttpGet httpgetIncident2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_resolvedBETWEENjavascript:gs.dateGenerate(%27"+anoAnual+"-"+dataMeio1+"%27%2C%2700:00:00%27)@javascript:gs.dateGenerate(%27"+anoAnual+"-"+dataMeio2+"%27%2C%2723:59:59%27)%5Eassignment_groupLIKE_SA&sysparm_first_row=1&sysparm_view=");

						httpgetIncident2.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetIncident2.getRequestLine());
						CloseableHttpResponse responseIncident2 = httpclient.execute(httpgetIncident2);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseIncident2.getStatusLine());
							String responseBodyIncident2 = EntityUtils.toString(responseIncident2.getEntity());
							System.out.println(responseBodyIncident2);

							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_"+anoAnual+"\\tb_incident_"+mesMeio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyIncident2).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
						} finally {
							responseIncident2.close();
						}

						//A PARTIR DO DIA 22 ATÉ FINAL DO MES
						HttpGet httpgetIncident3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_resolvedBETWEENjavascript:gs.dateGenerate(%27"+anoAnual+"-"+dataFim1+"%27%2C%2700:00:00%27)@javascript:gs.dateGenerate(%27"+anoAnual+"-"+dataFim2+"%27%2C%2723:59:59%27)%5Eassignment_groupLIKE_SA&sysparm_first_row=1&sysparm_view=");

						httpgetIncident3.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetIncident3.getRequestLine());
						CloseableHttpResponse responseIncident3 = httpclient.execute(httpgetIncident3);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseIncident3.getStatusLine());
							String responseBodyIncident3 = EntityUtils.toString(responseIncident3.getEntity());
							System.out.println(responseBodyIncident3);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_"+anoAnual+"\\tb_incident_"+mesFim+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyIncident3).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseIncident3.close();
						}

					}else if(tipo == 2) {//INCIDENTE_SLA

						//A PARTIR DO DIA 01 ATÉ O DIA 10
						HttpGet httpgetINCSLA = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=inc_u_resolvedBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio2+"'%2C'23%3A59%3A59')%5Einc_assignment_groupLIKE_SA");

						httpgetINCSLA.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetINCSLA.getRequestLine());
						CloseableHttpResponse responseINCSLA = httpclient.execute(httpgetINCSLA);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseINCSLA.getStatusLine());
							String responseBodyINCSLA = EntityUtils.toString(responseINCSLA.getEntity());
							System.out.println(responseBodyINCSLA);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_sla_"+anoAnual+"\\tb_incident_sla_"+mesInicio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyINCSLA).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();

							}
							//-------------------------------------------------------------------
						} finally {
							responseINCSLA.close();
						}

						//A PARTIR DO DIA 11 ATÉ O 21
						HttpGet httpgetINCSLA2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=inc_u_resolvedBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio2+"'%2C'23%3A59%3A59')%5Einc_assignment_groupLIKE_SA");

						httpgetINCSLA2.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetINCSLA2.getRequestLine());
						CloseableHttpResponse responseINCSLA2 = httpclient.execute(httpgetINCSLA2);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseINCSLA2.getStatusLine());
							String responseBodyINCSLA2 = EntityUtils.toString(responseINCSLA2.getEntity());
							System.out.println(responseBodyINCSLA2);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_sla_"+anoAnual+"\\tb_incident_sla_"+mesMeio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyINCSLA2).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseINCSLA2.close();
						}

						//A PARTIR DO DIA 22 ATÉ O FINAL DO MÊS
						HttpGet httpgetINCSLA3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=inc_u_resolvedBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim2+"'%2C'23%3A59%3A59')%5Einc_assignment_groupLIKE_SA");

						httpgetINCSLA3.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetINCSLA3.getRequestLine());
						CloseableHttpResponse responseINCSLA3 = httpclient.execute(httpgetINCSLA3);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseINCSLA3.getStatusLine());
							String responseBodyINCSLA3 = EntityUtils.toString(responseINCSLA3.getEntity());
							System.out.println(responseBodyINCSLA3);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_incident_sla_"+anoAnual+"\\tb_incident_sla_"+mesFim+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyINCSLA3).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseINCSLA3.close();
						}

					}else if(tipo == 3) {//TASK

						//A PARTIR DO DIA 01 ATÉ O DIA 15
						HttpGet httpgetTask = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHTASK%5Eassignment_groupLIKE_SA%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

						httpgetTask.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetTask.getRequestLine());
						CloseableHttpResponse responseTask = httpclient.execute(httpgetTask);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseTask.getStatusLine());
							String responseBodyTask = EntityUtils.toString(responseTask.getEntity());
							System.out.println(responseBodyTask);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_task_"+anoAnual+"\\tb_task_"+mesInicio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyTask).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseTask.close();
						}

						//A PARTIR DO DIA 11 ATÉ O DIA 21
						HttpGet httpgetTask2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHTASK%5Eassignment_groupLIKE_SA%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

						httpgetTask2.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetTask2.getRequestLine());
						CloseableHttpResponse responseTask2 = httpclient.execute(httpgetTask2);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseTask2.getStatusLine());
							String responseBodyTask2 = EntityUtils.toString(responseTask2.getEntity());
							System.out.println(responseBodyTask2);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_task_"+anoAnual+"\\tb_task_"+mesMeio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyTask2).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseTask2.close();
						}


						//A PARTIR DO DIA 22 ATÉ O FINAL DO MES
						HttpGet httpgetTask3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHTASK%5Eassignment_groupLIKE_SA%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim2+"'%2C'23%3A59%3A59')");

						httpgetTask3.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetTask3.getRequestLine());
						CloseableHttpResponse responseTask3 = httpclient.execute(httpgetTask3);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseTask3.getStatusLine());
							String responseBodyTask3 = EntityUtils.toString(responseTask3.getEntity());
							System.out.println(responseBodyTask3);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_task_"+anoAnual+"\\tb_task_"+mesFim+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyTask3).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseTask3.close();
						}

					}else if(tipo == 4) {//NCR

						//A PARTIR DO DIA 01 ATÉ O DIA 15
						HttpGet httpgetNCR = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_ad_hoc_grp_assign_to%3Db44fc1e80a0a3c9f012f639eadb791e1%5Esys_created_onBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

						httpgetNCR.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetNCR.getRequestLine());
						CloseableHttpResponse responseNCR = httpclient.execute(httpgetNCR);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseNCR.getStatusLine());
							String responseBodyNCR = EntityUtils.toString(responseNCR.getEntity());
							System.out.println(responseBodyNCR);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ncr_"+anoAnual+"\\tb_ncr_"+mesInicio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyNCR).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}

						} finally {
							responseNCR.close();
						}

						//A PARTIR DO DIA 11 ATÉ O DIA 21
						HttpGet httpgetNCR2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_ad_hoc_grp_assign_to%3Db44fc1e80a0a3c9f012f639eadb791e1%5Esys_created_onBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

						httpgetNCR2.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetNCR2.getRequestLine());
						CloseableHttpResponse responseNCR2 = httpclient.execute(httpgetNCR2);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseNCR2.getStatusLine());
							String responseBodyNCR2 = EntityUtils.toString(responseNCR2.getEntity());
							System.out.println(responseBodyNCR2);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ncr_"+anoAnual+"\\tb_ncr_"+mesMeio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyNCR2).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseNCR2.close();
						}

						//A PARTIR DO DIA 22 ATÉ O FIM DO MÊS
						HttpGet httpgetNCR3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=u_ad_hoc_grp_assign_to%3Db44fc1e80a0a3c9f012f639eadb791e1%5Esys_created_onBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim2+"'%2C'23%3A59%3A59')");

						httpgetNCR3.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetNCR2.getRequestLine());
						CloseableHttpResponse responseNCR3 = httpclient.execute(httpgetNCR3);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseNCR3.getStatusLine());
							String responseBodyNCR3 = EntityUtils.toString(responseNCR3.getEntity());
							System.out.println(responseBodyNCR3);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ncr_"+anoAnual+"\\tb_ncr_"+mesFim+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyNCR3).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseNCR3.close();
						}

					}else if(tipo == 5) {//RITM

						//A PARTIR DO DIA 01 ATÉ O DIA 10
						HttpGet httpgetRITM = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=closed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

						httpgetRITM.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetRITM.getRequestLine());
						CloseableHttpResponse responseRITM = httpclient.execute(httpgetRITM);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseRITM.getStatusLine());
							String responseBodyRITM = EntityUtils.toString(responseRITM.getEntity());
							System.out.println(responseBodyRITM);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_"+anoAnual+"\\tb_ritm_"+mesInicio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyRITM).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();

							}
							//-------------------------------------------------------------------
						} finally {
							responseRITM.close();
						}

						//A PARTIR DO DIA 11 ATÉ O DIA 21
						HttpGet httpgetRITM2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=closed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

						httpgetRITM2.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetRITM2.getRequestLine());
						CloseableHttpResponse responseRITM2 = httpclient.execute(httpgetRITM2);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseRITM2.getStatusLine());
							String responseBodyRITM2 = EntityUtils.toString(responseRITM2.getEntity());
							System.out.println(responseBodyRITM2);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_"+anoAnual+"\\tb_ritm_"+mesMeio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyRITM2).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();

							}
							//-------------------------------------------------------------------
						} finally {
							responseRITM2.close();
						}

						//A PARTIR DO DIA 22 ATÉ ÚLTIMO DIA DO MÊS
						HttpGet httpgetRITM3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=closed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim2+"'%2C'23%3A59%3A59')");

						httpgetRITM3.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetRITM3.getRequestLine());
						CloseableHttpResponse responseRITM3 = httpclient.execute(httpgetRITM3);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseRITM3.getStatusLine());
							String responseBodyRITM3 = EntityUtils.toString(responseRITM3.getEntity());
							System.out.println(responseBodyRITM3);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_"+anoAnual+"\\tb_ritm_"+mesFim+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyRITM3).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseRITM3.close();
						}

					}else if(tipo == 6) {//RITM_TASK

						//A PARTIR DO DIA 01 ATÉ O DIA 10
						HttpGet httpgetRITMTASK = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHRITM%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataInicio2+"'%2C'23%3A59%3A59')");

						httpgetRITMTASK.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetRITMTASK.getRequestLine());
						CloseableHttpResponse responseRITMTASK = httpclient.execute(httpgetRITMTASK);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseRITMTASK.getStatusLine());
							String responseBodyRITMTASK = EntityUtils.toString(responseRITMTASK.getEntity());
							System.out.println(responseBodyRITMTASK);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_task_"+anoAnual+"\\tb_ritm_task_"+mesInicio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyRITMTASK).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseRITMTASK.close();
						}

						//A PARTIR DO DIA 11 ATÉ O DIA 21
						HttpGet httpgetRITMTASK2 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHRITM%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataMeio2+"'%2C'23%3A59%3A59')");

						httpgetRITMTASK2.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetRITMTASK2.getRequestLine());
						CloseableHttpResponse responseRITMTASK2 = httpclient.execute(httpgetRITMTASK2);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseRITMTASK2.getStatusLine());
							String responseBodyRITMTASK2 = EntityUtils.toString(responseRITMTASK2.getEntity());
							System.out.println(responseBodyRITMTASK2);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_task_"+anoAnual+"\\tb_ritm_task_"+mesMeio+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyRITMTASK2).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseRITMTASK2.close();
						}

						//A PARTIR DO DIA 22 ATÉ O FINAL DO MES
						HttpGet httpgetRITMTASK3 = new HttpGet("https://agco.service-now.com/api/now/table/"+tableApi+"?sysparm_query=numberSTARTSWITHRITM%5Eclosed_atBETWEENjavascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim1+"'%2C'00%3A00%3A00')%40javascript%3Ags.dateGenerate('"+anoAnual+"-"+dataFim2+"'%2C'23%3A59%3A59')");

						httpgetRITMTASK3.setHeader("Accept", "application/json");
						System.out.println("Executing request " + httpgetRITMTASK3.getRequestLine());
						CloseableHttpResponse responseRITMTASK3 = httpclient.execute(httpgetRITMTASK3);
						try {
							System.out.println("----------------------------------------");
							System.out.println(responseRITMTASK3.getStatusLine());
							String responseBodyRITMTASK3 = EntityUtils.toString(responseRITMTASK3.getEntity());
							System.out.println(responseBodyRITMTASK3);
							//-------------------------------------------------------------------
							FileWriter writeFile = null;            
							try{
								writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_ritm_task_"+anoAnual+"\\tb_ritm_task_"+mesFim+"_"+anoAnual+".json");
								//Escreve no arquivo conteudo do Objeto JSON
								writeFile.write(((Object) responseBodyRITMTASK3).toString());
								writeFile.close();
							}
							catch(IOException e){
								e.printStackTrace();
							}
							//-------------------------------------------------------------------
						} finally {
							responseRITMTASK3.close();
						}

					}

				} finally {
					httpclient.close();
				}
			}
		}
	}

	//==========================================================================================================
	//ATIVOS_BACKLOG/VIOLADOS

	public void getRequestBacklog() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/incident_sla?sysparm_query=inc_stateIN1%2C2%2C3%2C-5%5Einc_assignment_groupLIKE_SA%5Etaskslatable_slaNOT%20LIKEAcknowledged%5Etaskslatable_has_breached%3Dtrue");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_outros\\tb_backlog.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	//==========================================================================================================
	//ATIVOS
	public void getRequestAtivos() throws HttpException, IOException {
		String cliente = txtCliente.getText();
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(new HttpHost(txtEndereço.getText())),
				new UsernamePasswordCredentials(txtLogin.getText(), txtSenha.getText()));
		CloseableHttpClient httpclient = HttpClients.custom()
				.setDefaultCredentialsProvider(credsProvider)
				.build();

		try {
			HttpGet httpget = new HttpGet("https://agco.service-now.com/api/now/table/task?sysparm_query=numberSTARTSWITHINC%5EORnumberSTARTSWITHTASK%5Eactive%3Dtrue%5EstateIN1%2C2%2C-5%2C-4%2C-3%2C-2%2C-1%2C0%2C-6%2C11%2C-7%2C-8%2C12%5Eassignment_groupLIKE_SA");

			httpget.setHeader("Accept", "application/json");
			System.out.println("Executing request " + httpget.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpget);

			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				String responseBody = EntityUtils.toString(response.getEntity());
				System.out.println(responseBody);
				//-------------------------------------------------------------------
				FileWriter writeFile = null;            
				try{
					writeFile = new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\tb_outros\\tb_ativos.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(((Object) responseBody).toString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				//-------------------------------------------------------------------
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

	private String fileToString(File file) {
		String jsonFile = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				jsonFile+=line;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonFile;
	}

	public void WriteInFile(String str) {
		String cliente = txtCliente.getText();
		String nomeFinal = txtNomeArquivoFinal.getText();
		try {

			BufferedWriter out = new BufferedWriter( 
					new FileWriter("C:\\Sistema_API_BI_"+cliente+"\\bases_json\\bases_consolidadas\\tb_"+nomeFinal+".json", true)); 
			out.write(str); 
			out.close(); 
		}
		catch (IOException e) { 
			System.out.println("exception occoured" + e); 
		}

	}
}
