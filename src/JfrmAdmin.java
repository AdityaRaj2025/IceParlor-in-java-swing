import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javafx.scene.control.DatePicker;
import net.proteanit.sql.DbUtils;
//import sun.util.resources.cldr.CalendarData;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.EtchedBorder;
import com.toedter.components.JLocaleChooser;
import java.awt.Window.Type;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JfrmAdmin extends JFrame{
	

	private JPanel contentPane;
	private Container layeredPane;
	protected JTextField txtPurchaseId;
	protected JTextField txtAPDProductId;
	private JTextField txtAPDProductName;
	private JTextField textField_7;
	protected JTextField txtSupplierId;
	private JTextField txtSupplierName;
	private JTextField txtSEmail;
	private JTextField txtPSupplierId;
	private JTextField txtSMobileNo;
	private JTextField txtAPDCategory;
	private JTextField txtAPDCompany;
	private JTextField txtFlavour;
	private JTextField txtUProductId;
	private JTextField txtUProductName;
	private JTextField txtUCategory;
	private JTextField txtUCompany;
	private JTextField txtUFlavour;
	protected JTextField txtPPEProductId;
	private JTextField txtQuantity;
	private JTextField txtInvoiceNo;
	private JTextField txtBatchNo;
	private JTextField txtMRP;
	private JTextField txtAmount;
	private JTextField txtDiscount;
	private JTextField txtDiscountRate;
	private JTextField txtGSTRate;
	private JTextField textDate;
	private JTextField txtPincode;
	private JTextField textField_10;
	private JLabel labelClockN;
	private JTextField txtUSuplierId;
	private JTextField txtUSupplierName;
	private JTextField txtUMobileNo;
	private JTextField txtUEmail;
	private JTextField txtUPinCode;
	private JTextField txtSaleNo;
	private JTextField txtCustomerName;
	private JTextField txtCustomerNumber;
	private JTextField txtSaleDate;
	private JComboBox comboBoxGST;
	private JComboBox cobSupplierName;
	private JComboBox cobPOFlavour;
	private JTable table_1;
	private JTable table;
	private JTable tablePO;
	private JTextField txtAvilable;
	private JTextField txtsMRP;
	private JTextField txtsQuantity;
	private JTextField txtsAmount;
	private JTextField txtsDiscount;
	private JTextField txtsDiscountRate;
	private JTextField txtGSTRatee;
	private JTable tableSale;
	private JTextField txtTotal;
	private JComboBox cobCategory;
	private JTextField txtTimeField;
	private JTextField txtDateField;
	private JTable table_2;
	private JTextField txtGST;
	private JTextField txtTotalAmount;
	private JTextField txtSaleGst;
	private JTable tableStockIn;
	private JTable tableStockOut;
	protected JTextField txtsBatchNo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JfrmAdmin frame = new JfrmAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	//Method for DATE And Time*****************************************
	
	public void showSysTime(final JTextField tf)
	{
	 	final SimpleDateFormat timef = new SimpleDateFormat("HH:mm:ss");
		javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			 String txtTimeField = timef.format(new Date(System.currentTimeMillis()));
			tf.setText(txtTimeField);
		  }
		});
		timer.start();
	}
	public String showTodayDate()
	{
		Date dt = new Date();
		System.out.println(dt.toString());
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy");
		return sdf.format(dt).toString();
	}
	
	//SupplerID Method For Product Master ***********************************************
		private void suppliersId()
	    {
	        try
	        {
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
				String mysql="SELECT SupplierId FROM tblsupplier ORDER BY SupplierId DESC LIMIT 1"; 
	        	PreparedStatement st=con.prepareStatement(mysql);
	        	ResultSet rs=st.executeQuery();
			      if(rs.next())
			      {
			          String rnno=rs.getString("SupplierId");
			          int co=rnno.length();
			          String txt= rnno.substring(0, 2);
			          String num=rnno.substring(2, co);
			          int n=Integer.parseInt(num);
			          n++;
			          String snum=Integer.toString(n);
			          String ftxt=txt+snum;
			          txtSupplierId.setText(ftxt);
			
			      }
			      else
			      {
			    	  txtSupplierId.setText("SI1000");
			      }

	        } 
	        catch (Exception e)
	        {
	        	JOptionPane.showMessageDialog(rootPane, e);
	        }
	    }
	//ProductID Method For Product Master ***********************************************
	private void productId()
    {
        try
        {
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
			String mysql="SELECT ProductId FROM tblproductmaster ORDER BY ProductId DESC LIMIT 1"; 
        	PreparedStatement st=con.prepareStatement(mysql);
        	ResultSet rs=st.executeQuery();
		      if(rs.next())
		      {
		          String rnno=rs.getString("ProductId");
		          int co=rnno.length();
		          String txt= rnno.substring(0, 2);
		          String num=rnno.substring(2, co);
		          int n=Integer.parseInt(num);
		          n++;
		          String snum=Integer.toString(n);
		          String ftxt=txt+snum;
		          txtAPDProductId.setText(ftxt);
		
		      }
		      else
		      {
		    	  txtAPDProductId.setText("PI1000");
		      }

        } 
        catch (Exception e)
        {
        	JOptionPane.showMessageDialog(rootPane, e);
        }
    }
	
	//************OrderId Generate*******************************************************
		public void orderNo()
	    {
	        try
	        {
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
				String mysql="SELECT OrderNo FROM tblPurchaseOrder ORDER BY OrderNo DESC LIMIT 1"; 
	        	PreparedStatement st=con.prepareStatement(mysql);
	        	ResultSet rs=st.executeQuery();
			      if(rs.next())
			      {
			          String rnno=rs.getString("OrderNo");
			          int co=rnno.length();
			          String txt= rnno.substring(0, 2);
			          String num=rnno.substring(2, co);
			          int n=Integer.parseInt(num);
			          n++;
			          String snum=Integer.toString(n);
			          String ftxt=txt+snum;
			        //  txtOrderNo.setText(ftxt);
			
			      }
			      else
			      {
			    	 // txtOrderNo.setText("OI1000");
			      }

	        } 
	        catch (Exception e)
	        {
	        	JOptionPane.showMessageDialog(rootPane, e);
	        }
	    }
		
		//************PurchaseEntryId Generate*******************************************************
				public void purchaseEntryId()
			    {
			        try
			        {
			        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String mysql="SELECT PurchaseId FROM tblPurchaseentry ORDER BY PurchaseId DESC LIMIT 1"; 
			        	PreparedStatement st=con.prepareStatement(mysql);
			        	ResultSet rs=st.executeQuery();
					      if(rs.next())
					      {
					          String rnno=rs.getString("PurchaseId");
					          int co=rnno.length();
					          String txt= rnno.substring(0, 2);
					          String num=rnno.substring(2, co);
					          int n=Integer.parseInt(num);
					          n++;
					          String snum=Integer.toString(n);
					          String ftxt=txt+snum;
					          txtPurchaseId.setText(ftxt);
					
					      }
					      else
					      {
					    	 txtPurchaseId.setText("PE1000");
					      }

			        } 
			        catch (Exception e)
			        {
			        	JOptionPane.showMessageDialog(rootPane, e);
			        }
			    }
				
				//************SaleId Generate*******************************************************
				public void saleNo()
			    {
			        try
			        {
			        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String mysql="SELECT SaleNo FROM tblSale ORDER BY SaleNo DESC LIMIT 1"; 
			        	PreparedStatement st=con.prepareStatement(mysql);
			        	ResultSet rs=st.executeQuery();
					      if(rs.next())
					      {
					          String rnno=rs.getString("SaleNo");
					          int co=rnno.length();
					          String txt= rnno.substring(0, 2);
					          String num=rnno.substring(2, co);
					          int n=Integer.parseInt(num);
					          n++;
					          String snum=Integer.toString(n);
					          String ftxt=txt+snum;
					          txtSaleNo.setText(ftxt);
					
					      }
					      else
					      {
					    	  txtSaleNo.setText("SN1000");
					      }

			        } 
			        catch (Exception e)
			        {
			        	JOptionPane.showMessageDialog(rootPane, e);
			        }
			    }
				
				/* Table  Product Master From*/
				
				public  void Table() {
				try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String query="select * from tblproductmaster";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception e) {
							System.out.print(e);
						}
				}
				
				//*********************** Supplier Table 
				public void SupplierTable() {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String query="select * from tblSupplier";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception e) {
							System.out.print(e);
						}
				}
	

				//*********************** Purchase Entry Table 
				public void PurchaseTable() {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String query="select * from tblpurchaseentry";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception e) {
							System.out.print(e);
						}
				}
				
				//*********************** Sale Entry Table 
				public void saleTable() {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String query="select * from tblsale";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						tableSale.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception e) {
							System.out.print(e);
						}
				}
				
				//*********************** Stock in Table 
				public void StockInTable() {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String query="select * from tblpurchaseentry";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						tableStockIn.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception e) {
							System.out.print(e);
						}
				}
				
				//*********************** Stock Out Table 
				public void StockOutTable() {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
						String query="select * from tblsale";
						Statement stmt=con.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						tableStockOut.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception e) {
							System.out.print(e);
						}
				}
	/**
	 * Create the frame.
	 */
	public JfrmAdmin() {
	
		setType(Type.UTILITY);
		setTitle("ICE CREAM PARLOUR");
		Table();
		SupplierTable();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1390,750);
		
	/*	txtDateField = new JTextField(18);
		txtDateField.setText(showTodayDate());
		getContentPane().add(txtDateField);
		txtDateField.setEditable(false);
		//dateLongField.setForeground(Color.GRAY);
		txtDateField.setFont(new Font("TimesRoman",Font.BOLD,12));*/
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(310, 77, 1060, 634);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		 
		
		
		JPanel pnl1PurchaseOrder = new JPanel();
		pnl1PurchaseOrder.setBackground(Color.WHITE);
		layeredPane.add(pnl1PurchaseOrder, "name_108287807354604");
		pnl1PurchaseOrder.setLayout(null);
		
		JLabel lblPanel = new JLabel("Stock Reports");
		lblPanel.setBounds(429, 11, 176, 37);
		lblPanel.setFont(new Font("Tahoma", Font.BOLD, 19));
		pnl1PurchaseOrder.add(lblPanel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1060, 634);
		panel.setBorder(null);
		pnl1PurchaseOrder.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 382, 1040, 241);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Stock Out", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 25, 1020, 205);
		panel_3.add(scrollPane_3);
		
		tableStockOut = new JTable();
		scrollPane_3.setViewportView(tableStockOut);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(17, 47, 1033, 252);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Stock In", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 28, 1013, 213);
		panel_4.add(scrollPane_2);
		
		tableStockIn = new JTable();
		scrollPane_2.setViewportView(tableStockIn);
		
		JButton btnPurchaseOrderSave = new JButton("Save");
		btnPurchaseOrderSave.setBounds(951, 403, 89, 23);
		panel.add(btnPurchaseOrderSave);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setBounds(951, 460, 89, 23);
		panel.add(btnPrint);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(951, 517, 89, 23);
		panel.add(btnClose);
	
		JPanel pnl2Purchase = new JPanel();
		layeredPane.add(pnl2Purchase, "name_108293499078984");
		pnl2Purchase.setLayout(null);
		
		JLabel lblPurchaseOrder = new JLabel("PURCHASE");
		lblPurchaseOrder.setBounds(450, -1, 122, 37);
		lblPurchaseOrder.setFont(new Font("Tahoma", Font.BOLD, 19));
		pnl2Purchase.add(lblPurchaseOrder);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 33, 1023, 108);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Invoice Info", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnl2Purchase.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Purchase Id");
		label.setBounds(86, 25, 117, 28);
		panel_1.add(label);
		label.setFont(UIManager.getFont("Label.font"));
		
		txtPurchaseId = new JTextField();
		txtPurchaseId.setEditable(false);
		txtPurchaseId.setBounds(65, 67, 105, 24);
		panel_1.add(txtPurchaseId);
		txtPurchaseId.setColumns(10);
		
		JLabel label_1 = new JLabel("Supplier Id");
		label_1.setBounds(358, 27, 117, 28);
		panel_1.add(label_1);
		label_1.setFont(UIManager.getFont("Label.font"));
		
		txtPSupplierId = new JTextField();
		txtPSupplierId.setBounds(323, 71, 138, 20);
		panel_1.add(txtPSupplierId);
		txtPSupplierId.setColumns(10);
		
		JLabel lblInvoiceNo = new JLabel("Invoice No");
		lblInvoiceNo.setBounds(655, 32, 68, 14);
		panel_1.add(lblInvoiceNo);
		
		txtInvoiceNo = new JTextField();
		txtInvoiceNo.setColumns(10);
		txtInvoiceNo.setBounds(619, 67, 151, 24);
		panel_1.add(txtInvoiceNo);
		
		JLabel lblPurchaseDate = new JLabel("Purchase Date");
		lblPurchaseDate.setBounds(846, 32, 95, 14);
		panel_1.add(lblPurchaseDate);
		
		JDateChooser datePurchaseDate = new JDateChooser();
		datePurchaseDate.setBounds(835, 67, 95, 20);
		panel_1.add(datePurchaseDate);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 152, 1023, 108);
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Purchase Product Entry", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		pnl2Purchase.add(panel_6);
		
		JLabel label_23 = new JLabel("Product Name");
		label_23.setBounds(40, 35, 98, 14);
		panel_6.add(label_23);
		
		JComboBox cobPPEProductName = new JComboBox();
		cobPPEProductName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblproductmaster";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			        	cobPPEProductName.addItem(rs.getString("ProductName"));
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		cobPPEProductName.setBounds(10, 72, 127, 22);
		panel_6.add(cobPPEProductName);
		
		txtPPEProductId = new JTextField();
		txtPPEProductId.setEditable(false);
		txtPPEProductId.setColumns(10);
		txtPPEProductId.setBounds(171, 73, 86, 20);
		panel_6.add(txtPPEProductId);
		
		JLabel label_24 = new JLabel("Product Id");
		label_24.setBounds(183, 35, 72, 14);
		panel_6.add(label_24);
		
		JLabel label_25 = new JLabel("Company");
		label_25.setBounds(472, 35, 46, 14);
		panel_6.add(label_25);
		
		JComboBox cobPPECompany = new JComboBox();
		cobPPECompany.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblproductmaster";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			        	cobPPECompany.addItem(rs.getString("Company"));
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		cobPPECompany.setBounds(439, 72, 127, 22);
		panel_6.add(cobPPECompany);
		
		JLabel label_27 = new JLabel("Category");
		label_27.setBounds(327, 36, 46, 14);
		panel_6.add(label_27);
		
		JComboBox cobPPECategory = new JComboBox();
		cobPPECategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblproductmaster";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			        	cobPPECategory.addItem(rs.getString("Category"));
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		cobPPECategory.setBounds(287, 72, 127, 22);
		panel_6.add(cobPPECategory);
		
		JLabel lblBatchNo = new JLabel("Batch No");
		lblBatchNo.setBounds(796, 35, 46, 14);
		panel_6.add(lblBatchNo);
		
		txtBatchNo = new JTextField();
		txtBatchNo.setColumns(10);
		txtBatchNo.setBounds(748, 70, 151, 24);
		panel_6.add(txtBatchNo);
		
		JLabel lblExpDate = new JLabel("Exp Date");
		lblExpDate.setBounds(938, 35, 46, 14);
		panel_6.add(lblExpDate);
		
		JDateChooser dateExpDate = new JDateChooser();
		dateExpDate.setBounds(909, 70, 95, 24);
		panel_6.add(dateExpDate);
		
		JLabel lblFlavour = new JLabel("Flavour");
		lblFlavour.setBounds(629, 30, 46, 14);
		panel_6.add(lblFlavour);
		
		JComboBox cobPPEFlavour = new JComboBox();
		cobPPEFlavour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblproductmaster";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			        	cobPPEFlavour.addItem(rs.getString("Flavour"));
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		cobPPEFlavour.setBounds(596, 72, 127, 22);
		panel_6.add(cobPPEFlavour);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 271, 1039, 108);
		panel_7.setBorder(new TitledBorder(null, "Amounts", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnl2Purchase.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblMrp = new JLabel("MRP");
		lblMrp.setBounds(68, 21, 46, 14);
		panel_7.add(lblMrp);
		
		txtMRP = new JTextField();
		txtMRP.setBounds(38, 56, 92, 24);
		panel_7.add(txtMRP);
		txtMRP.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(341, 21, 46, 14);
		panel_7.add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setEditable(false);
		txtAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		txtAmount.setBounds(293, 56, 129, 24);
		panel_7.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblDiscount = new JLabel("Discount%");
		lblDiscount.setBounds(497, 21, 72, 14);
		panel_7.add(lblDiscount);
		
		txtDiscount = new JTextField();
		txtDiscount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
		});
		txtDiscount.setBounds(474, 56, 106, 24);
		panel_7.add(txtDiscount);
		txtDiscount.setColumns(10);
		
		txtDiscountRate = new JTextField();
		txtDiscountRate.setEditable(false);
		txtDiscountRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				float rate= Float.parseFloat(txtAmount.getText())*(Float.parseFloat(txtDiscount.getText()))/100;
				String r=String.valueOf(rate);
				System.out.println(r);
				txtDiscountRate.setText(r);
			}
		});
		txtDiscountRate.setBounds(612, 56, 106, 24);
		panel_7.add(txtDiscountRate);
		txtDiscountRate.setColumns(10);
		
		JLabel lblDiscountRate = new JLabel("Discount Rate");
		lblDiscountRate.setBounds(626, 21, 72, 14);
		panel_7.add(lblDiscountRate);
		
		JLabel label_26 = new JLabel("Quantity");
		label_26.setBounds(186, 21, 46, 14);
		panel_7.add(label_26);
		//***********************************************************Addition of quantity**************************************************************************
		txtQuantity = new JTextField();
		txtQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				float add=Float.parseFloat(txtMRP.getText())*Float.parseFloat(txtQuantity.getText());
				
				String s=String.valueOf(add); 
				System.out.println(s);
			txtAmount.setText((s));
			}
		});
		txtQuantity.setBounds(170, 58, 86, 20);
		panel_7.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblGst = new JLabel("GST%");
		lblGst.setBounds(764, 21, 46, 14);
		panel_7.add(lblGst);
		
		txtGSTRate = new JTextField();
		txtGSTRate.setEditable(false);
		txtGSTRate.setColumns(10);
		txtGSTRate.setBounds(845, 58, 86, 20);
		panel_7.add(txtGSTRate);
		
		JLabel lblGstRate = new JLabel("GST Rate");
		lblGstRate.setBounds(859, 21, 72, 14);
		panel_7.add(lblGstRate);
		
		txtGST = new JTextField();
		txtGST.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float gst = (Float.parseFloat(txtGST.getText())*Float.parseFloat(txtAmount.getText())/100);
				System.out.println(gst);
				String s=String.valueOf(gst); 
				System.out.println(s);
			txtGSTRate.setText((s));
				
			}
		});
		txtGST.setColumns(10);
		txtGST.setBounds(745, 58, 86, 20);
		panel_7.add(txtGST);
		
		JLabel lblTotalPayableAmount = new JLabel("Total Payable Amount");
		lblTotalPayableAmount.setBounds(923, 21, 106, 14);
		panel_7.add(lblTotalPayableAmount);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float add=Float.parseFloat(txtAmount.getText())-Float.parseFloat(txtDiscountRate.getText());
				String s=String.valueOf(add); 
				System.out.println(s);
				txtTotalAmount.setText((s));
			}
		});
		txtTotalAmount.setColumns(10);
		txtTotalAmount.setBounds(941, 48, 86, 41);
		panel_7.add(txtTotalAmount);
		
		textDate = new JTextField();
		textDate.setBounds(973, 11, 76, 20);
		textDate.setText("17/36/2019");
		textDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		textDate.setEditable(false);
		textDate.setColumns(10);
		pnl2Purchase.add(textDate);
		
		JLabel label_3 = new JLabel("Date");
		label_3.setBounds(916, 14, 46, 14);
		pnl2Purchase.add(label_3);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(973, 495, 76, 37);
		pnl2Purchase.add(btnReset);
		//******************************Purchase Entry*******************Button Submit****************************************
		JButton btnPurchaseAdd = new JButton("ADD");
		btnPurchaseAdd.addActionListener(new ActionListener() {
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
					String mySql="insert into tblpurchaseentry(PurchaseId,SupplierId,InvoiceNo,ProductName,Category,Company,Flavour,BatchNo,MRP,Quantity,Amount,Discount,DiscountRate)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(mySql);
					st.setString(1,txtPurchaseId.getText());
					st.setString(2,txtPSupplierId.getText());
					st.setString(3,txtInvoiceNo.getText());
					//st.setString(1,datePurchaseDate.getText());
					
					st.setString(4,cobPPEProductName.getSelectedItem().toString());
					st.setString(5,cobPPECategory.getSelectedItem().toString());
					st.setString(6,cobPPECompany.getSelectedItem().toString());
					st.setString(7,cobPPEFlavour.getSelectedItem().toString());
					st.setString(8,txtBatchNo.getText());
					//st.setNString(1,dateExpDate.getText());
					st.setString(9,txtMRP.getText());
					st.setString(10,txtQuantity.getText());
					st.setString(11,txtAmount.getText());
					st.setString(12,txtDiscount.getText());
					st.setString(13,txtDiscountRate.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Save Sucessfully");
					st.close();
					con.close();
					purchaseEntryId();
					PurchaseTable();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		btnPurchaseAdd.setBounds(973, 426, 76, 37);
		pnl2Purchase.add(btnPurchaseAdd);
		
		JButton btnClosePurchaseEntry = new JButton("Close");
		btnClosePurchaseEntry.setBounds(973, 560, 76, 37);
		pnl2Purchase.add(btnClosePurchaseEntry);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 402, 944, 221);
		pnl2Purchase.add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setColumnHeaderView(table_2);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPurchaseId.setText(" ");
				//txtOrderId.setText(" ");
				txtPSupplierId.setText(" ");
				txtInvoiceNo.setText(" ");
				datePurchaseDate.setSelectableDateRange(null, null);
			}
		});
		
		JPanel pnl3ProductMaster = new JPanel();
		layeredPane.add(pnl3ProductMaster, "name_108296774999803");
		pnl3ProductMaster.setLayout(null);
		
		JLabel lblProductMaster = new JLabel("Product Master");
		lblProductMaster.setBounds(403, 9, 178, 23);
		lblProductMaster.setFont(new Font("Tahoma", Font.BOLD, 19));
		pnl3ProductMaster.add(lblProductMaster);
		
		JLabel label_6 = new JLabel("Date");
		label_6.setBounds(860, 9, 45, 23);
		pnl3ProductMaster.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(934, 10, 116, 20);
		pnl3ProductMaster.add(textField_7);
		textField_7.setText("17/36/2019");
		textField_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 56, 1050, 148);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Product Deatils", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnl3ProductMaster.add(panel_2);
		panel_2.setLayout(null);
		
		txtAPDProductId = new JTextField();
		txtAPDProductId.setEditable(false);
		txtAPDProductId.setBounds(62, 68, 89, 20);
		panel_2.add(txtAPDProductId);
		txtAPDProductId.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setBounds(72, 29, 74, 14);
		panel_2.add(lblProductId);
		lblProductId.setFont(UIManager.getFont("Label.font"));
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(277, 29, 74, 14);
		panel_2.add(lblProductName);
		
		txtAPDProductName = new JTextField();
		txtAPDProductName.setBounds(227, 68, 178, 20);
		panel_2.add(txtAPDProductName);
		txtAPDProductName.setColumns(10);
		
		JLabel label_15 = new JLabel("Category");
		label_15.setBounds(502, 30, 46, 14);
		panel_2.add(label_15);
		
		txtAPDCategory = new JTextField();
		txtAPDCategory.setBounds(442, 68, 178, 20);
		panel_2.add(txtAPDCategory);
		txtAPDCategory.setColumns(10);
		
		txtAPDCompany = new JTextField();
		txtAPDCompany.setBounds(648, 68, 178, 20);
		panel_2.add(txtAPDCompany);
		txtAPDCompany.setColumns(10);
		
		JLabel label_9 = new JLabel("Company");
		label_9.setBounds(708, 29, 46, 14);
		panel_2.add(label_9);
		
		JLabel label_16 = new JLabel("Flavour");
		label_16.setBounds(907, 29, 74, 14);
		panel_2.add(label_16);
		
		txtFlavour = new JTextField();
		txtFlavour.setBounds(852, 68, 178, 20);
		panel_2.add(txtFlavour);
		txtFlavour.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		
		btnSave.addActionListener(new ActionListener() {
			
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
					String mySql="insert into tblproductmaster(ProductId,ProductName,Category,Company,Flavour)values(?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(mySql);
					st.setString(1,txtAPDProductId.getText());
					st.setString(2,txtAPDProductName.getText());
					st.setString(3,txtAPDCategory.getText());
					st.setString(4,txtAPDCompany.getText());
					st.setString(5,txtFlavour.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Save Sucessfully");
					st.close();
					con.close();
					productId();
					Table();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		btnSave.setBounds(924, 99, 89, 38);
		panel_2.add(btnSave);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 458, 1050, 148);
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Edit Product Deatils", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		pnl3ProductMaster.add(panel_5);
		
		txtUProductId = new JTextField();
		txtUProductId.setColumns(10);
		txtUProductId.setBounds(32, 68, 139, 20);
		panel_5.add(txtUProductId);
		
		JLabel label_18 = new JLabel("Product Id");
		label_18.setFont(UIManager.getFont("Label.font"));
		label_18.setBounds(72, 29, 74, 14);
		panel_5.add(label_18);
		
		JLabel label_19 = new JLabel("Product Name");
		label_19.setBounds(277, 29, 74, 14);
		panel_5.add(label_19);
		
		txtUProductName = new JTextField();
		txtUProductName.setColumns(10);
		txtUProductName.setBounds(227, 68, 178, 20);
		panel_5.add(txtUProductName);
		
		JLabel label_20 = new JLabel("Category");
		label_20.setBounds(502, 30, 46, 14);
		panel_5.add(label_20);
		
		txtUCategory = new JTextField();
		txtUCategory.setColumns(10);
		txtUCategory.setBounds(442, 68, 178, 20);
		panel_5.add(txtUCategory);
		
		txtUCompany = new JTextField();
		txtUCompany.setColumns(10);
		txtUCompany.setBounds(648, 68, 178, 20);
		panel_5.add(txtUCompany);
		
		JLabel label_21 = new JLabel("Company");
		label_21.setBounds(708, 29, 46, 14);
		panel_5.add(label_21);
		
		JLabel label_22 = new JLabel("Flavour");
		label_22.setBounds(907, 29, 74, 14);
		panel_5.add(label_22);
		
		txtUFlavour = new JTextField();
		txtUFlavour.setColumns(10);
		txtUFlavour.setBounds(852, 68, 178, 20);
		panel_5.add(txtUFlavour);
		
		JButton btnUUpdate = new JButton("UPDATE");
		btnUUpdate.addActionListener(new ActionListener() {
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
					String mySql="Update tblproductmaster set ProductId='"+txtUProductId.getText()+"', ProductName='"+txtUProductName.getText()+"',Category='"+txtUCategory.getText()+"',Company='"+txtUCompany.getText()+"',Flavour='"+txtUFlavour.getText()+"' where ProductId='"+txtUProductId.getText()+"' ";
					PreparedStatement st=con.prepareStatement(mySql);
					/*st.setString(1,txtAdminId.getText());
					st.setString(2,txtAdminName.getText());
					String value=cbxGender.getSelectedItem().toString();
					st.setString(3,value);
					st.setString(4,textEmail.getText());
					st.setString(5,textMobileNo.getText());
					st.setString(6,textHostelName.getText());
					st.setString(7,textAddress.getText());*/
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Update Sucessfully");
					st.close();
					con.close();
					//adminId();
					Table();
					//SupplierTable();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		btnUUpdate.setBounds(924, 114, 89, 23);
		panel_5.add(btnUUpdate);
		//Product Master Search Button*******************************************************************************************************
		JButton btnUSearch = new JButton("Search");
		btnUSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement st=null;
				ResultSet rs=null;
				
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
					        String sql = "SELECT ProductId,ProductName,Category,Company,Flavour from tblproductmaster where ProductId=?";
					        st=con.prepareStatement(sql);
					        st.setString(1,txtUProductId.getText());
					        rs = st.executeQuery();
					    if(rs.next())
					    { 
					    	String Id=rs.getString("ProductId");
					    	txtUProductId.setText(Id);
					    	String name=rs.getString("ProductName");
					    	txtUProductName.setText(name);
					    	String eid=rs.getString("Category");
					    	txtUCategory.setText(eid);
					    	String mn=rs.getString("Company");
					    	txtUCompany.setText(mn);
					    	String hn=rs.getString("Flavour");
					    	txtUFlavour.setText(hn);
					    	
					    }
				} catch (SQLException es )
				{
			    	JOptionPane.showMessageDialog(null, es);
			    }
			}

			
		});
		btnUSearch.setBounds(72, 99, 99, 31);
		panel_5.add(btnUSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 226, 1040, 221);
		pnl3ProductMaster.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel pnl4SupplierCreate = new JPanel();
		layeredPane.add(pnl4SupplierCreate, "name_108304483083311");
		pnl4SupplierCreate.setLayout(null);
		
		JLabel lblSupplierCreate = new JLabel("Supplier Create");
		lblSupplierCreate.setBounds(459, 11, 180, 37);
		lblSupplierCreate.setFont(new Font("Tahoma", Font.BOLD, 19));
		pnl4SupplierCreate.add(lblSupplierCreate);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 42, 1040, 109);
		panel_8.setBorder(new TitledBorder(null, "Supplier Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnl4SupplierCreate.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblSupplierId_1 = new JLabel("Supplier Id");
		lblSupplierId_1.setBounds(45, 11, 117, 28);
		panel_8.add(lblSupplierId_1);
		lblSupplierId_1.setFont(UIManager.getFont("Label.font"));
		
		txtSupplierId = new JTextField();
		txtSupplierId.setEditable(false);
		txtSupplierId.setBounds(24, 50, 95, 24);
		panel_8.add(txtSupplierId);
		txtSupplierId.setColumns(10);
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setBounds(206, 11, 117, 28);
		panel_8.add(lblSupplierName);
		lblSupplierName.setFont(UIManager.getFont("Label.font"));
		
		txtSupplierName = new JTextField();
		txtSupplierName.setBounds(172, 50, 151, 24);
		panel_8.add(txtSupplierName);
		txtSupplierName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(376, 18, 76, 14);
		panel_8.add(lblDateOfBirth);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(815, 18, 46, 14);
		panel_8.add(lblEmail);
		
		JLabel label_2 = new JLabel("Mobile No");
		label_2.setBounds(575, 11, 76, 28);
		panel_8.add(label_2);
		label_2.setFont(UIManager.getFont("Label.font"));
		
		txtSMobileNo = new JTextField();
		txtSMobileNo.setBounds(527, 50, 151, 24);
		panel_8.add(txtSMobileNo);
		txtSMobileNo.setColumns(10);
		
		txtSEmail = new JTextField();
		txtSEmail.setBounds(725, 52, 219, 20);
		panel_8.add(txtSEmail);
		txtSEmail.setColumns(10);
		
		JDateChooser dateSDOB = new JDateChooser();
		dateSDOB.setBounds(333, 50, 156, 24);
		panel_8.add(dateSDOB);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 162, 1040, 97);
		panel_9.setBorder(new TitledBorder(null, "Address", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnl4SupplierCreate.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(69, 11, 46, 14);
		panel_9.add(lblCity);
		
		JComboBox cmbSCity = new JComboBox();
		cmbSCity.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "F", "G"}));
		cmbSCity.setBounds(10, 52, 126, 22);
		panel_9.add(cmbSCity);
		
		JLabel lblPincode = new JLabel("Pincode");
		lblPincode.setBounds(192, 11, 46, 14);
		panel_9.add(lblPincode);
		
		txtPincode = new JTextField();
		txtPincode.setBounds(165, 53, 86, 20);
		panel_9.add(txtPincode);
		txtPincode.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(339, 11, 46, 14);
		panel_9.add(lblState);
		
		JComboBox cmbSState = new JComboBox();
		cmbSState.setModel(new DefaultComboBoxModel(new String[] {"X", "Y", "Z", "P", "Q", "R"}));
		cmbSState.setBounds(282, 52, 151, 22);
		panel_9.add(cmbSState);
		
		JTextArea txaSStreet = new JTextArea();
		txaSStreet.setBounds(470, 32, 151, 54);
		panel_9.add(txaSStreet);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(523, 11, 46, 14);
		panel_9.add(lblStreet);
		//Suppliers Details Save Button Code*****************************************************
		JButton btnSSave = new JButton("Save");
		btnSSave.addActionListener(new ActionListener() {
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
					String mySql="insert into tblsupplier(SupplierId,SupplierName,MobileNo,EmailId,City,Pincode,State,Street)values(?,?,?,?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(mySql);
					st.setString(1,txtSupplierId.getText());
					st.setString(2,txtSupplierName.getText());
					//st.setDate(3,dateSDOB.getDate());
					// st.setDate(3,convertUtilDateToSqlDate(dateSDOB.getDate()));
					/* Date dateValue = null;
				        try {
				            dateValue = date.parse(rs.getString("DateOfJoin"));
				        } catch (Exception ex) {
				            JOptionPane.showMessageDialog(null, ex);
				        }
				        dateSDOB.setDate(dateValue); */
					st.setString(3,txtSMobileNo.getText());
					st.setString(4,txtSEmail.getText());
					String value=cmbSCity.getSelectedItem().toString();
					st.setString(5,value);
					String svalue=cmbSState.getSelectedItem().toString();
					st.setString(6,svalue);
					st.setString(7,txtPincode.getText());
					st.setString(8,txaSStreet.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Save Sucessfully");
					st.close();
					con.close();
					suppliersId();
					SupplierTable();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		btnSSave.setBounds(672, 52, 89, 23);
		panel_9.add(btnSSave);
		
		JLabel label_7 = new JLabel("Date");
		label_7.setBounds(917, 14, 46, 14);
		pnl4SupplierCreate.add(label_7);
		
		textField_10 = new JTextField();
		textField_10.setBounds(957, 11, 76, 20);
		pnl4SupplierCreate.add(textField_10);
		textField_10.setText("17/36/2019");
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(10, 412, 1040, 109);
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update Supplier Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		pnl4SupplierCreate.add(panel_10);
		
		JLabel label_29 = new JLabel("Supplier Id");
		label_29.setFont(UIManager.getFont("Label.font"));
		label_29.setBounds(45, 11, 117, 28);
		panel_10.add(label_29);
		
		txtUSuplierId = new JTextField();
		txtUSuplierId.setEditable(false);
		txtUSuplierId.setColumns(10);
		txtUSuplierId.setBounds(24, 50, 95, 24);
		panel_10.add(txtUSuplierId);
		
		JLabel label_30 = new JLabel("Supplier Name");
		label_30.setFont(UIManager.getFont("Label.font"));
		label_30.setBounds(206, 11, 117, 28);
		panel_10.add(label_30);
		
		txtUSupplierName = new JTextField();
		txtUSupplierName.setColumns(10);
		txtUSupplierName.setBounds(172, 50, 151, 24);
		panel_10.add(txtUSupplierName);
		
		JLabel label_31 = new JLabel("Date of Birth");
		label_31.setBounds(376, 18, 76, 14);
		panel_10.add(label_31);
		
		JLabel label_32 = new JLabel("Email");
		label_32.setBounds(815, 18, 46, 14);
		panel_10.add(label_32);
		
		JLabel label_33 = new JLabel("Mobile No");
		label_33.setFont(UIManager.getFont("Label.font"));
		label_33.setBounds(575, 11, 76, 28);
		panel_10.add(label_33);
		
		txtUMobileNo = new JTextField();
		txtUMobileNo.setColumns(10);
		txtUMobileNo.setBounds(527, 50, 151, 24);
		panel_10.add(txtUMobileNo);
		
		txtUEmail = new JTextField();
		txtUEmail.setColumns(10);
		txtUEmail.setBounds(725, 52, 219, 20);
		panel_10.add(txtUEmail);
		
		JDateChooser txtUDOB = new JDateChooser();
		txtUDOB.setBounds(333, 50, 156, 24);
		panel_10.add(txtUDOB);
		
		JButton btnSSearch = new JButton("Search");
		btnSSearch.setBounds(107, 16, 89, 23);
		panel_10.add(btnSSearch);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(10, 526, 1040, 97);
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Update Address", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		pnl4SupplierCreate.add(panel_11);
		
		JLabel label_34 = new JLabel("City");
		label_34.setBounds(69, 11, 46, 14);
		panel_11.add(label_34);
		
		JComboBox cmbUCity = new JComboBox();
		cmbUCity.setBounds(10, 52, 126, 22);
		panel_11.add(cmbUCity);
		
		JLabel label_35 = new JLabel("Pincode");
		label_35.setBounds(192, 11, 46, 14);
		panel_11.add(label_35);
		
		txtUPinCode = new JTextField();
		txtUPinCode.setColumns(10);
		txtUPinCode.setBounds(165, 53, 86, 20);
		panel_11.add(txtUPinCode);
		
		JLabel label_36 = new JLabel("State");
		label_36.setBounds(339, 11, 46, 14);
		panel_11.add(label_36);
		
		JComboBox cmbUState = new JComboBox();
		cmbUState.setBounds(282, 52, 151, 22);
		panel_11.add(cmbUState);
		
		JTextArea txtUStreet = new JTextArea();
		txtUStreet.setBounds(470, 32, 151, 54);
		panel_11.add(txtUStreet);
		
		JLabel label_37 = new JLabel("Street");
		label_37.setBounds(523, 11, 46, 14);
		panel_11.add(label_37);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(672, 52, 89, 23);
		panel_11.add(btnUpdate);
		
		JScrollPane tableP = new JScrollPane();
		tableP.setBounds(10, 270, 1040, 131);
		pnl4SupplierCreate.add(tableP);
		
		table_1 = new JTable();
		tableP.setViewportView(table_1);
		
		JPanel pnl5Sale = new JPanel();
		layeredPane.add(pnl5Sale, "name_108308624962039");
		pnl5Sale.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(10, 43, 1040, 74);
		panel_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sale Invoice Info ", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnl5Sale.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblSaleNo = new JLabel("Sale No");
		lblSaleNo.setBounds(21, 33, 46, 14);
		panel_12.add(lblSaleNo);
		
		txtSaleNo = new JTextField();
		txtSaleNo.setEditable(false);
		txtSaleNo.setBounds(89, 30, 86, 20);
		panel_12.add(txtSaleNo);
		txtSaleNo.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(240, 33, 95, 14);
		panel_12.add(lblCustomerName);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(336, 30, 175, 20);
		panel_12.add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(557, 33, 46, 14);
		panel_12.add(lblMobileNo);
		
		txtCustomerNumber = new JTextField();
		txtCustomerNumber.setBounds(626, 30, 119, 20);
		panel_12.add(txtCustomerNumber);
		txtCustomerNumber.setColumns(10);
		
		JLabel lblSaleDate = new JLabel("Sale Date");
		lblSaleDate.setBounds(782, 33, 60, 14);
		panel_12.add(lblSaleDate);
		
		txtSaleDate = new JTextField();
		txtSaleDate.setBounds(852, 30, 95, 20);
		panel_12.add(txtSaleDate);
		txtSaleDate.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(10, 128, 1040, 108);
		panel_13.setBorder(new TitledBorder(null, "Sale Product", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnl5Sale.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel label_38 = new JLabel("Product Name");
		label_38.setBounds(40, 26, 98, 14);
		panel_13.add(label_38);
		
		JComboBox txtsSProductName = new JComboBox();
		txtsSProductName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblpurchaseentry";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			       
			        	txtsSProductName.addItem(rs.getString("ProductName"));
			        
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
			
		});
		txtsSProductName.setBounds(10, 63, 127, 22);
		panel_13.add(txtsSProductName);
		
		JLabel label_40 = new JLabel("Category");
		label_40.setBounds(604, 27, 46, 14);
		panel_13.add(label_40);
		
		JComboBox cbxsCategory = new JComboBox();
		cbxsCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblpurchaseentry";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			       
			        	cbxsCategory.addItem(rs.getString("Category"));
			        
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		cbxsCategory.setBounds(564, 63, 127, 22);
		panel_13.add(cbxsCategory);
		
		JLabel label_41 = new JLabel("Company");
		label_41.setBounds(766, 26, 46, 14);
		panel_13.add(label_41);
		
		JComboBox cbxsComapny = new JComboBox();
		cbxsComapny.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblpurchaseentry";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			       
			        	cbxsComapny.addItem(rs.getString("Company"));
			        
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		cbxsComapny.setBounds(737, 63, 127, 22);
		panel_13.add(cbxsComapny);
		
		JLabel label_42 = new JLabel("Flavour");
		label_42.setBounds(936, 26, 46, 14);
		panel_13.add(label_42);
		
		JComboBox cbxsFlavour = new JComboBox();
		cbxsFlavour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblpurchaseentry";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			       
			        	cbxsFlavour.addItem(rs.getString("Flavour"));
			        
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		cbxsFlavour.setBounds(903, 68, 127, 22);
		panel_13.add(cbxsFlavour);
		
		JLabel lblAvilableStock = new JLabel("Avilable Stock");
		lblAvilableStock.setBounds(422, 26, 79, 14);
		panel_13.add(lblAvilableStock);
		
		txtAvilable = new JTextField();
		txtAvilable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="update tblpurchaseentry set Quantity=Quantity -'"+txtAvilable.getText()+"' where BatchNo=?";
			        ResultSet rs = stmt.executeQuery(query);
			       /* while (rs.next())
			        {
			       
			        	txtAvilable.setText(rs.getString("AvilableStock"));
			        
			        }*/

			/*	} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Not fetch");
				}*/
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblpurchaseentry where BatchNo values=?";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			       
			        	txtAvilable.setText(rs.getString("AvilableStock"));
			        
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		txtAvilable.setEditable(false);
		txtAvilable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblpurchaseentry where BatchNo=?";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			       
			        	txtAvilable.setText(rs.getString("AvilableStock"));
			        
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		txtAvilable.setColumns(10);
		txtAvilable.setBounds(385, 61, 151, 24);
		panel_13.add(txtAvilable);
		
		txtsBatchNo = new JTextField();
		txtsBatchNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
				String query = "UPDATE tblpurchaseentry SET Quantity = Quantity - 1 WHERE BatchNo = ? and Quantity > 0";
				   PreparedStatement pstmt = conn.prepareStatement(query);
				  
				  pstmt.setInt (1,Integer.parseInt(txtAvilable.getText());
				   pstmt.executeUpdate();*/
			}
		});
		txtsBatchNo.setBounds(187, 62, 151, 24);
		panel_13.add(txtsBatchNo);
		txtsBatchNo.setColumns(10);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setBounds(235, 26, 79, 14);
		panel_13.add(lblBatch);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(10, 259, 1050, 102);
		panel_14.setBorder(new TitledBorder(null, "Amount", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		pnl5Sale.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel label_45 = new JLabel("MRP");
		label_45.setBounds(40, 15, 46, 14);
		panel_14.add(label_45);
		
		txtsMRP = new JTextField();
		txtsMRP.setColumns(10);
		txtsMRP.setBounds(10, 50, 92, 24);
		panel_14.add(txtsMRP);
		
		txtsQuantity = new JTextField();
		txtsQuantity.setColumns(10);
		txtsQuantity.setBounds(142, 52, 86, 20);
		panel_14.add(txtsQuantity);
		
		JLabel label_46 = new JLabel("Quantity");
		label_46.setBounds(158, 15, 46, 14);
		panel_14.add(label_46);
		
		JLabel label_47 = new JLabel("Amount");
		label_47.setBounds(313, 15, 46, 14);
		panel_14.add(label_47);
		
		txtsAmount = new JTextField();
		txtsAmount.setEditable(false);
		txtsAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				float add=Float.parseFloat(txtsMRP.getText())*Float.parseFloat(txtsQuantity.getText());
				String s=String.valueOf(add); 
				System.out.println(s);
				txtsAmount.setText((s));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ dbiceparlor","root","Root@311vb.net");
					Statement stmt=con.createStatement();
					String query="select * from tblpurchaseentry where BatchNo=?";
			        ResultSet rs = stmt.executeQuery(query);
			        while (rs.next())
			        {
			       
			        	txtAvilable.setText(rs.getString("AvilableStock"));
			        
			        }

				} 
				catch (Exception e1)
				{
					e1.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error Data not fatched");
				}
			}
		});
		txtsAmount.setColumns(10);
		txtsAmount.setBounds(265, 50, 129, 24);
		panel_14.add(txtsAmount);
		
		JLabel label_48 = new JLabel("Discount%");
		label_48.setBounds(469, 15, 72, 14);
		panel_14.add(label_48);
		
		txtsDiscount = new JTextField();
		txtsDiscount.setColumns(10);
		txtsDiscount.setBounds(455, 50, 106, 24);
		panel_14.add(txtsDiscount);
		
		JLabel label_49 = new JLabel("Discount Rate");
		label_49.setBounds(617, 15, 72, 14);
		panel_14.add(label_49);
		
		txtsDiscountRate = new JTextField();
		txtsDiscountRate.setEditable(false);
		txtsDiscountRate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float rate= Float.parseFloat(txtsAmount.getText())*(Float.parseFloat(txtsDiscount.getText()))/100;
				String r=String.valueOf(rate);
				System.out.println(r);
				txtsDiscountRate.setText(r);
			}
		});
		txtsDiscountRate.setColumns(10);
		txtsDiscountRate.setBounds(603, 50, 106, 24);
		panel_14.add(txtsDiscountRate);
		
		JLabel label_50 = new JLabel("GST%");
		label_50.setBounds(755, 15, 46, 14);
		panel_14.add(label_50);
		
		txtGSTRatee = new JTextField();
		txtGSTRatee.setEditable(false);
		txtGSTRatee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float gst = (Float.parseFloat(txtSaleGst.getText())*Float.parseFloat(txtsAmount.getText())/100);
				System.out.println(gst);
				String s=String.valueOf(gst); 
				System.out.println(s);
				txtGSTRatee.setText((s));
			}
		});
		txtGSTRatee.setColumns(10);
		txtGSTRatee.setBounds(836, 52, 86, 20);
		panel_14.add(txtGSTRatee);
		
		JLabel label_51 = new JLabel("GST Rate");
		label_51.setBounds(850, 15, 72, 14);
		panel_14.add(label_51);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(960, 15, 46, 14);
		panel_14.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float add=Float.parseFloat(txtsAmount.getText())-Float.parseFloat(txtsDiscountRate.getText());
				String s=String.valueOf(add); 
				System.out.println(s);
				txtTotal.setText((s));
			}
		});
		txtTotal.setBounds(943, 52, 86, 39);
		panel_14.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtSaleGst = new JTextField();
		txtSaleGst.setColumns(10);
		txtSaleGst.setBounds(729, 52, 86, 20);
		panel_14.add(txtSaleGst);
		
		JScrollPane scrollPaneSale = new JScrollPane();
		scrollPaneSale.setBounds(10, 401, 922, 222);
		pnl5Sale.add(scrollPaneSale);
		
		tableSale = new JTable();
		scrollPaneSale.setColumnHeaderView(tableSale);
		//******************************************************SALE BUTTON SAVE CODE*********************************************
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.addActionListener(new ActionListener() {
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
					String mySql="insert into tblsale(SaleNo,CustomerName,CustMobNo,ProductName,Category,Company,Flavour,MRP,AvailableStock,Quantity,Amount,Discount,DiscountRate,GST,TotalGSTAmount,TotalAmount,BatchNo)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement st=con.prepareStatement(mySql);
					st.setString(1,txtSaleNo.getText());
					st.setString(2,txtCustomerName.getText());
					st.setString(3,txtCustomerNumber.getText());
					st.setString(4,txtsSProductName.getSelectedItem().toString());
					
					st.setString(5,cbxsCategory.getSelectedItem().toString());
					st.setString(6,cbxsComapny.getSelectedItem().toString());
					st.setString(7,cbxsFlavour.getSelectedItem().toString());
					st.setString(8,txtsMRP.getText());
					st.setString(9,txtAvilable.getText());
					st.setString(10,txtsQuantity.getText());
					st.setString(11,txtsAmount.getText());
					st.setString(12,txtsDiscount.getText());
					st.setString(13,txtsDiscountRate.getText());
					st.setString(14,txtSaleGst.getText());
					st.setString(15,txtGSTRatee.getText());
					st.setString(16, txtTotal.getText());
					st.setString(17,txtsBatchNo.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Save Sucessfully");
					st.close();
					con.close();
					saleNo();
					saleTable();
				}
				catch( Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Some Errors");
					System.out.println(e2);
				}
			}
		});
		btnSave_1.setBounds(961, 462, 89, 40);
		pnl5Sale.add(btnSave_1);
		
		JButton btnPrint_1 = new JButton("Print");
		btnPrint_1.setBounds(961, 513, 89, 40);
		pnl5Sale.add(btnPrint_1);
		
		JButton btnClose_1 = new JButton("Close");
		btnClose_1.setBounds(961, 564, 89, 40);
		pnl5Sale.add(btnClose_1);
		
		JLabel lblSale = new JLabel("SALE");
		lblSale.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSale.setBounds(454, 11, 180, 37);
		pnl5Sale.add(lblSale);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Cream.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-30, -2, 342, 713);
		contentPane.add(lblNewLabel);
		
		JPanel panelBtnsMenu = new JPanel();
		panelBtnsMenu.setBounds(310, -2, 1060, 78);
		contentPane.add(panelBtnsMenu);
		panelBtnsMenu.setBackground(SystemColor.menu);
		panelBtnsMenu.setLayout(null);
		
		JButton btnPurchaseOrder = new JButton("Stock");
		btnPurchaseOrder.setBounds(302, 21, 136, 46);
		panelBtnsMenu.add(btnPurchaseOrder);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(448, 21, 136, 46);
		panelBtnsMenu.add(btnPurchase);
		
		JButton btnProductMaster = new JButton("Product Master");
		btnProductMaster.setBounds(10, 21, 136, 46);
		panelBtnsMenu.add(btnProductMaster);
		
		JButton btnSupplierCreate = new JButton("Supplier Create");
		btnSupplierCreate.setBounds(156, 21, 136, 46);
		panelBtnsMenu.add(btnSupplierCreate);
		
		JButton btnSale = new JButton("Sale");
		btnSale.setBounds(594, 21, 136, 46);
		panelBtnsMenu.add(btnSale);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(961, 11, 89, 23);
		panelBtnsMenu.add(btnLogout);
		
		txtTimeField = new JTextField();
		txtTimeField.setBounds(944, 33, 106, 20);
		showSysTime(txtTimeField);
		txtTimeField.setFont(new Font("TimesRoman",Font.BOLD,12));
		txtTimeField.setEditable(false);
		panelBtnsMenu.add(txtTimeField);
		txtTimeField.setColumns(10);
		
		txtDateField = new JTextField();
		txtDateField.setText(showTodayDate());
		txtDateField.setColumns(10);
		txtDateField.setBounds(944, 55, 106, 23);
		txtDateField.setEditable(false);
		//dateLongField.setForeground(Color.GRAY);
		txtDateField.setFont(new Font("TimesRoman",Font.BOLD,12));
		
		panelBtnsMenu.add(txtDateField);
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleNo();
				layeredPane.removeAll();
				layeredPane.add(pnl5Sale);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSupplierCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suppliersId();
				SupplierTable();
				layeredPane.removeAll();
				layeredPane.add(pnl4SupplierCreate);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnProductMaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productId();
				Table();
				layeredPane.removeAll();
				layeredPane.add(pnl3ProductMaster);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(pnl2Purchase);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnPurchaseOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				StockOutTable();
				StockInTable();
				//SupplierCombox();
				layeredPane.removeAll();
				layeredPane.add(pnl1PurchaseOrder);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		JButton btnHorizontalLine = new JButton("-");
		btnHorizontalLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHorizontalLine.setBackground(Color.GREEN);
		btnHorizontalLine.setBounds(310, 71, 1060, 5);
		contentPane.add(btnHorizontalLine);
		
		JButton BtnSideLine = new JButton("I");
		BtnSideLine.setBounds(307, -2, 5, 713);
		contentPane.add(BtnSideLine);
		BtnSideLine.setBackground(Color.GREEN);
		
		suppliersId();
		productId();
		saleNo();
		orderNo();
		purchaseEntryId();
		PurchaseTable();
		saleTable();
		StockOutTable();
		StockInTable();
	}
}
