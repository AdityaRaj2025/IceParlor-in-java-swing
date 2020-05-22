import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ProductMaster extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMaster frame = new ProductMaster();
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
	public ProductMaster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1390,750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Product Deatils", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(0, 24, 1050, 148);
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(62, 68, 89, 20);
		panel.add(textField);
		
		JLabel label = new JLabel("Product Id");
		label.setFont(UIManager.getFont("Label.font"));
		label.setBounds(72, 29, 74, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Product Name");
		label_1.setBounds(277, 29, 74, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(227, 68, 178, 20);
		panel.add(textField_1);
		
		JLabel label_2 = new JLabel("Category");
		label_2.setBounds(502, 30, 46, 14);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(442, 68, 178, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(648, 68, 178, 20);
		panel.add(textField_3);
		
		JLabel label_3 = new JLabel("Company");
		label_3.setBounds(708, 29, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Flavour");
		label_4.setBounds(907, 29, 74, 14);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(852, 68, 178, 20);
		panel.add(textField_4);
		
		JButton button = new JButton("SAVE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					}
					catch(ClassNotFoundException ce)
					{
						JOptionPane.showMessageDialog(null,"Loding Driver Failed");
					}
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					String mySql="insert into testx(ProductId,ProductName,Category,Company,Flavour)values(?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(mySql);
					st.setString(1,textField.getText());
					st.setString(2,textField_1.getText());
					st.setString(3,textField_2.getText());
					st.setString(4,textField_3.getText());
					st.setString(5,textField_4.getText());
					//float gvalue=(Float)comboBoxGST.getSelectedItem();
					//st.setFloat(6,gvalue);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Save Sucessfully");
					st.close();
					con.close();
					//productId();
					//Table();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		button.setBounds(924, 99, 89, 38);
		panel.add(button);
		
		JLabel label_5 = new JLabel("GST%");
		label_5.setBounds(32, 119, 46, 14);
		panel.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(72, 114, 103, 22);
		panel.add(comboBox);
	}

}
