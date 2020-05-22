/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class MyMethods extends JfrmAdmin  {
	 void suppliersId()
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
}
*/