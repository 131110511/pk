package pk;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class AddPay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4659116468292111188L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPay frame = new AddPay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AddPay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u652F\u51FA\u4FE1\u606F");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		lblNewLabel.setBounds(175, 36, 179, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1.setBounds(99, 89, 41, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u65F6\u95F4");
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_2.setBounds(99, 131, 41, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\u652F\u51FA\u91D1\u989D");
		label.setFont(new Font("����", Font.BOLD, 14));
		label.setBounds(73, 182, 67, 32);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u652F\u51FA\u539F\u56E0");
		label_1.setFont(new Font("����", Font.BOLD, 14));
		label_1.setBounds(73, 235, 78, 32);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5907\u6CE8");
		label_2.setFont(new Font("����", Font.BOLD, 14));
		label_2.setBounds(99, 290, 41, 32);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(162, 296, 221, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//д�����ݿ�֧����Ϣ
				
				//�������ݿ���ӵ���Ϣ
				String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
				// �������ݿ����ӵ�ַ
				String DBURL = "jdbc:odbc:FFM";
				// �������ݿ����Ӷ�������java.sql���еĽӿ�
				Connection conn = null;
				// ����Statement�������ڲ������ݿ�
				Statement stmt = null;
				// ����һ�ַ������������ڱ���SQL���
				String sql2 = null;
				// ����һ��������Դ�ż����Ľ��
				//ResultSet r2 = null;
				// 1��������������
				try {
					Class.forName(DBDRIVER);
				} catch (Exception a) {
					
					System.out.println(a);
				}
				// 2���������ݿ�
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception a) {
					System.out.println(a);
				}
				try {
					stmt = conn.createStatement();
					sql2 = "insert into Pay(userName,pay_date,pay_amount,reason,remark) values('"
							+ textField_4.getText()
							+ "','"
							+ textField_3.getText()
							+ "','"
							+ textField_2.getText()
							+ "','"
							+ textField_1.getText()
							+ "','"
							+ textField.getText()
							+ "' )";
					stmt.executeUpdate(sql2);

				} catch (Exception a) {
					System.out.println(a);
				}
				// 4���ر����ݿ�
				try {
					// �رղ���
					stmt.close();
					// �ر�����
					conn.close();
				} catch (Exception a) {
					System.out.println(a);
				}
			
				dispose();
				runSucceAdd();
			}
		});
		btnNewButton.setBounds(73, 354, 93, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runMW();
			}
		});
		btnNewButton_1.setBounds(290, 354, 85, 32);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 241, 221, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(162, 188, 85, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(161, 138, 166, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		 
		
		textField_4 = new JTextField();
		textField_4.setBounds(161, 95, 86, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
	public void runMW() {
		try {
			MainWindow frame = new MainWindow();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runSucceAdd() {
		try {
			SucceAdd frame = new SucceAdd();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
