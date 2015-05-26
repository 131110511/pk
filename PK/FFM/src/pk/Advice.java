package pk;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import java.awt.Color;

import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Advice extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1076734693738578659L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Advice frame = new Advice();
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
	public Advice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7CFB\u7EDF\u5EFA\u8BAE");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(246, 22, 123, 46);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u60A8\u603B\u6536\u5165\u4E3A\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 15));
		label.setBounds(138, 87, 123, 36);
		contentPane.add(label);
		
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
			} catch (Exception e) {
				
				System.out.println(e);
			}
			// 2、连接数据库
			try {
				conn = DriverManager.getConnection(DBURL);
			} catch (Exception e) {
				System.out.println(e);
			}
			// 3、操作数据库
			// 通过Connection对象实例化Statement对象
			try {
				stmt = conn.createStatement();
				// 为sql变量赋值
				// 插入语句
				sql = "select * from Income";
				r = stmt.executeQuery(sql);
				double totalIncome=0.0;
				while (r.next()) {
					 totalIncome+= r.getDouble(4);	
				}
		
				sql = "select * from Pay";
				r = stmt.executeQuery(sql);
				double totalPay=0.0;
				while (r.next()) {
					 totalPay+= r.getDouble(4);	
				}
				String in= Double.toString(totalIncome);
				String out= Double.toString(totalPay);
			
		JLabel label_1 = new JLabel(in);
		label_1.setBackground(new Color(240, 255, 240));
		label_1.setBounds(251, 87, 118, 36);
		contentPane.add(label_1);
		
		
		JLabel label_2 = new JLabel("\u60A8\u603B\u652F\u51FA\u4E3A\uFF1A");
		label_2.setFont(new Font("宋体", Font.BOLD, 15));
		label_2.setBounds(138, 145, 105, 32);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel(out);
		lblNewLabel_1.setBounds(251, 145, 123, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7CFB\u7EDF\u5EFA\u8BAE\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(139, 209, 81, 25);
		contentPane.add(lblNewLabel_2);
		
		double cha=totalIncome-totalPay;
		{
			if(cha>=10000)
		{
				String result="恭喜您有了丰富的积蓄，请继续保持！";
				JLabel lblNewLabel_3 = new JLabel(result);
				lblNewLabel_3.setBounds(251, 205, 280, 30);
				contentPane.add(lblNewLabel_3);
		}
			else if(cha<10000&&cha>=100)
			{
				String result="继续客观，仍需努力奥！";
				JLabel lblNewLabel_3 = new JLabel(result);
				lblNewLabel_3.setBounds(251, 205, 280, 30);
				contentPane.add(lblNewLabel_3);
			}
			else if(cha<100&&cha>=0)
			{
				String result="花钱容易，挣钱不易，切花且珍惜啊！";
				JLabel lblNewLabel_3 = new JLabel(result);
				lblNewLabel_3.setBounds(251, 205, 280, 30);
				contentPane.add(lblNewLabel_3);
			}
			else 
			{
				String result="您已经进入贫穷欠债阶段，请改变现状！！";
				JLabel lblNewLabel_3 = new JLabel(result);
				lblNewLabel_3.setBounds(251, 205, 280, 30);
				contentPane.add(lblNewLabel_3);
			}
			
			}
			} catch (Exception e) {
				System.out.println(e);
			}
			// 4、关闭数据库
			try {
				// 关闭操作
				stmt.close();
				// 关闭连接
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runMW();
			}
		});
		btnNewButton.setBounds(246, 277, 93, 36);
		contentPane.add(btnNewButton);
	}
	public void runMW() {
		try {
			MainWindow frame = new MainWindow();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
