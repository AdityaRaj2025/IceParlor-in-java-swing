import java.awt.EventQueue;
import com.mysql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class frmLogin {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JLabel lblClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin window = new frmLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmLogin() {
		initialize();
		clock();
	}
	
	/***Clock Code*****************/

	public void clock()
	{
		Thread clock =new Thread()
		{
			public void run()
			{
					try
					{
						for(;;)
						{
								Calendar cal=new GregorianCalendar();
								int day=cal.get(Calendar.DAY_OF_MONTH);
								int month=cal.get(Calendar.MONTH);
								int year=cal.get(Calendar.YEAR);
								
								int second=cal.get(Calendar.SECOND);
								int minute=cal.get(Calendar.MINUTE);
								int hour=cal.get(Calendar.HOUR);
								int st=cal.get(Calendar.AM);
								
								lblClock.setText("Time  "+hour+":"+minute+":"+second+"\n    Date  "+year+"-"+month+"-"+day);
								sleep(1000);
						}	
					}
					catch(InterruptedException es)
					{
						es.printStackTrace();
					}
			}
		};
		clock.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		clock();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(new Color(189, 183, 107));
		frame.setBounds(100, 100, 1390,750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), null, null, null));
		panel.setBounds(312, -2, 1058, 713);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBorder(new TitledBorder(null, "LOGIN", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(333, 238, 374, 238);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 33, 75, 19);
		panel_1.add(lblUsername);
		lblUsername.setForeground(SystemColor.textHighlight);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtUserName = new JTextField();
		txtUserName.setBounds(156, 34, 137, 20);
		panel_1.add(txtUserName);
		txtUserName.setForeground(Color.DARK_GRAY);
		txtUserName.setOpaque(false);
		txtUserName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 96, 100, 29);
		panel_1.add(lblPassword);
		lblPassword.setForeground(SystemColor.textHighlight);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(156, 102, 137, 20);
		panel_1.add(txtPassword);
		txtPassword.setForeground(Color.DARK_GRAY);
		txtPassword.setOpaque(false);
		txtPassword.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.WHITE, null, null, null));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(114, 190, 116, 37);
		panel_1.add(btnLogin);
		btnLogin.setForeground(SystemColor.activeCaption);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					
					String sql="Select * from login where UserId='"+txtUserName.getText()+"'and Password='"+txtPassword.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Sucessfully...");
						frame.dispose();
						JfrmAdmin obj = new JfrmAdmin();
						obj.setVisible(true);

					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect User Id and Password..!");
					}
					con.close();		
				}
				catch( Exception e2)
				{
				
					System.out.println(e2);
				}
			}
		});
		btnLogin.setBackground(new Color(50, 205, 50));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(248, 190, 116, 37);
		panel_1.add(btnClose);
		btnClose.setForeground(Color.RED);
		btnClose.setBackground(new Color(50, 205, 50));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("");
		Image Pic = new ImageIcon(this.getClass().getResource("/Cream.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(Pic));
		//lblNewLabel.setBounds(-30, -2, 342, 713);
		//contentPane.add(lblNewLabel);
		lblNewLabel.setBounds(-30, -2, 342, 713);
		frame.getContentPane().add(lblNewLabel);
		clock();
	   
	}
}