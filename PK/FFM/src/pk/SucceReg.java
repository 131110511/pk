package pk;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SucceReg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4128127405055217292L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 /* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SucceReg frame = new SucceReg();
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
	public SucceReg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6CE8\u518C\u6210\u529F\uFF01");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		lblNewLabel.setBounds(150, 55, 191, 48);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				runMA();
			}
		});
		button.setBounds(148, 165, 93, 23);
		contentPane.add(button);
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
