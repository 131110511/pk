package pk;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6172792314391695505L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u5BB6\u5EAD\u8D22\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.ITALIC, 30));
		lblNewLabel.setBounds(136, 25, 388, 61);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\u6DFB\u52A0\u6536\u5165");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runAddInc();
			}
		});
		button.setBounds(53, 123, 93, 44);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u6536\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runSearchIn();
			}
		});
		btnNewButton.setBounds(279, 123, 93, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("\u6DFB\u52A0\u652F\u51FA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runAddP();
			}
		});
		btnNewButton_3.setBounds(53, 218, 93, 44);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u67E5\u8BE2\u652F\u51FA");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runSearchPay();
				
			}
		});
		btnNewButton_4.setBounds(279, 218, 93, 44);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(489, 327, 113, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("\u6536\u652F\u6574\u4F53\u4FE1\u606F");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runTotalSit();
			}
		});
		btnNewButton_6.setBounds(489, 123, 113, 44);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("\u7CFB\u7EDF\u5EFA\u8BAE");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runAdvice();
			}
		});
		btnNewButton_7.setBounds(489, 218, 113, 44);
		contentPane.add(btnNewButton_7);
	}
	public void runAddInc() {
		try {
			AddIncome frame = new AddIncome();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runAddP() {
		try {
			AddPay frame = new AddPay();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runSearchIn() {
		try {
			SearchInc frame = new SearchInc();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runSearchPay() {
		try {
			SearchPay frame = new SearchPay();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runTotalSit() {
		try {
			TotalSituation frame = new TotalSituation();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void runAdvice() {
		try {
			Advice frame = new Advice();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
