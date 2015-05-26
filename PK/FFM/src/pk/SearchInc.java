package pk;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class SearchInc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4934031994124675072L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchInc frame = new SearchInc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	/**
	 * Create the frame.
	 */
	public SearchInc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6536\u5165\u4FE1\u606F\u60C5\u51B5");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(249, 10, 160, 61);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 82, 619, 239);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		 String[] header={
				"\u59D3\u540D", "\u65E5\u671F", "\u6536\u5165\u91D1\u989D", "\u6536\u5165\u6765\u6E90", "\u5907\u6CE8"
			};
		 DefaultTableModel md = new DefaultTableModel(header,0);
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
				while(r.next()){
					Vector<String> v = new Vector<String>();
					v.addElement(r.getString(2));
					v.addElement(r.getString(3));
					v.addElement(r.getString(4));
					v.addElement(r.getString(5));
					v.addElement(r.getString(6));
					md.addRow(v);
				}
		table.setModel(md
				/*new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"\u59D3\u540D", "\u65E5\u671F", "\u6536\u5165\u91D1\u989D", "\u6536\u5165\u6765\u6E90", "\u5907\u6CE8"
			}
		)*/
		);
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

		
			
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(127);
		table.getColumnModel().getColumn(2).setPreferredWidth(102);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(160);
		table.setBackground(UIManager.getColor("Button.disabledShadow"));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runMW();
			}
		});
		btnNewButton.setBounds(257, 341, 93, 32);
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
