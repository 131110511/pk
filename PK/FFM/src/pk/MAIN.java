package pk;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;//数据库
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MAIN extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1318793646740494461L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	//private String userName;
	//private String password;
	private int succe=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MAIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel.setBounds(125, 103, 54, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(125, 149, 54, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BB6\u5EAD\u8D22\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_2.setFont(new Font("宋体", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(125, 24, 267, 42);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(177, 107, 127, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				ResultSet r = null;
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
					// 为sql变量赋值
					// 插入语句
					sql = "select * from User";
					r = stmt.executeQuery(sql);
					char[] key=passwordField.getPassword();
					String password = new String(key);
					while (r.next()) {
						if(textField.getText().equals(r.getString(2))&&password.equals(r.getString(3)))
						{   
							succe=1;
							dispose();
							runMW();
							
						}					
					}
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
				if(succe==0)
				{
					dispose();
					runMAwrong();
				}
			}
			
		
		});
		btnNewButton.setBounds(92, 208, 66, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(293, 208, 66, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6CE8\u518C\u8D26\u53F7");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			runR();
			}
		});
		btnNewButton_2.setBounds(329, 110, 93, 23);
		contentPane.add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 149, 127, 30);
		contentPane.add(passwordField);
	}
	public void dispose(){
		this.setVisible(false);
	}
	public void runR() {
		try {
			Register frame = new Register();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runMW() {
		try {
			MainWindow frame = new MainWindow();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runMAwrong() {
		try {
			MAwrong frame = new MAwrong();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
