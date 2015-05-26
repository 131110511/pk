package pk;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;//数据库
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7075969166767119824L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u6CE8\u518C");
		lblNewLabel.setFont(new Font("宋体", Font.ITALIC, 25));
		lblNewLabel.setBounds(162, 20, 126, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(71, 85, 99, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BF7\u8F93\u5165\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(71, 144, 99, 27);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(162, 91, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		char[] miyao=passwordField_1.getPassword();
		String password = new String(miyao);
		char[] mima=passwordField.getPassword();
		String key= new String(mima);
		//	System.out.println(miyao);
			{	
			if(password.equals("131110511"))
				{		//密码存入用户信息数据表
				// 定义数据库驱动程序
				String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
				// 定义数据库连接地址
				String DBURL = "jdbc:odbc:FFM";
				// 定义数据库连接对象，属于java.sql包中的接口
				Connection conn = null;
				// 定义Statement对象，用于操作数据库
				Statement stmt = null;
				// 定义一字符串变量，用于保存SQL语句
				String sql = null;
				// 定义一个结果集以存放检索的结果
				//ResultSet r = null;
				// 1、加载驱动程序
				try {
					Class.forName(DBDRIVER);
				} catch (Exception f) {
					System.out.println(f);
				}
				// 2、连接数据库
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception f) {
					System.out.println(f);
				}
				// 3、操作数据库
				// 通过Connection对象实例化Statement对象
				
				try {
					stmt = conn.createStatement();
					String user=textField.getText();
					sql = "insert into User(user,password) values('"+user+"','"+key+"')";
					stmt.executeUpdate(sql);
				} catch (Exception f) {
					System.out.println(f);
				}
				// 4、关闭数据库
				try {
					// 关闭操作
					stmt.close();
					// 关闭连接
					conn.close();
				} catch (Exception f) {
					System.out.println(f);
				}
			
				dispose();				
				runSucce();
				}
				else{
					dispose();
					runWrong();
				}
			}
			}
		});
		button.setBounds(71, 272, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runMA();
			}
		});
		button_1.setBounds(253, 272, 93, 23);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u94A5\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(71, 206, 93, 21);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 147, 116, 21);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(162, 206, 116, 21);
		contentPane.add(passwordField_1);
	}
	
	public void runWrong() {
		try {
			ResWrong frame = new ResWrong();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runSucce() {
		try {
			SucceReg frame = new SucceReg();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runMA() {
		try {
			MAIN frame = new MAIN();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
