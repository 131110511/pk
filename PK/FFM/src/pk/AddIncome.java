package pk;

import java.sql.*;
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
//import java.sql.ResultSet;

public class AddIncome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4626930852081974164L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddIncome frame = new AddIncome();
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
	public AddIncome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u6536\u5165\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(181, 34, 130, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_1.setBounds(107, 96, 54, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u65F6\u95F4");
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(107, 146, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6536\u5165\u91D1\u989D");
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(76, 190, 65, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6765\u6E90");
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(107, 236, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5907\u6CE8");
		label_3.setFont(new Font("宋体", Font.BOLD, 14));
		label_3.setBounds(107, 284, 54, 15);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(152, 98, 120, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 143, 159, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//存入数据库添加的信息
				String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
				// 定义数据库连接地址
				String DBURL = "jdbc:odbc:FFM";
				// 定义数据库连接对象，属于java.sql包中的接口
				Connection conn = null;
				// 定义Statement对象，用于操作数据库
				Statement stmt = null;
				// 定义一字符串变量，用于保存SQL语句
				String sql2 = null;
				// 定义一个结果集以存放检索的结果
				//ResultSet r2 = null;
				// 1、加载驱动程序
				try {
					Class.forName(DBDRIVER);
				} catch (Exception a) {
					System.out.println(a);
				}
				// 2、连接数据库
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception a) {
					System.out.println(a);
				}
				try {
					stmt = conn.createStatement();
					sql2 = "insert into Income(userName,income_date,income_amount,reason,remark) values('"
							+ textField.getText()
							+ "','"
							+ textField_1.getText()
							+ "','"
							+ textField_2.getText()
							+ "','"
							+ textField_3.getText()
							+ "','"
							+ textField_4.getText()
							+ "' )";
					stmt.executeUpdate(sql2);

				} catch (Exception a) {
					System.out.println(a);
				}
				// 4、关闭数据库
				try {
					// 关闭操作
					stmt.close();
					// 关闭连接
					conn.close();
				} catch (Exception a) {
					System.out.println(a);
				}
			
				
				dispose();
				runSucceAdd();
			}
		});
		button.setBounds(107, 349, 93, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runMW();
			}
		});
		button_1.setBounds(301, 349, 84, 26);
		contentPane.add(button_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 187, 103, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(152, 233, 273, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(152, 281, 273, 21);
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
