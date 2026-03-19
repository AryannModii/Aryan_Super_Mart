import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class VendorProductOrderCRUD {

    public static void insert(Connection con, int cpo_id, int product_id, int qty, int price, int billno) throws Exception{

        PreparedStatement ps= con.prepareStatement("insert into public.customer_product_order(vpo_id,product_id, product_qty, vendor_billno) values (?,?,?,?)");

        ps.setInt(1,cpo_id);
        ps.setInt(2,product_id);
        ps.setInt(3,qty);

        ps.executeUpdate();
        ProductCRUD.increaseStock(con,product_id,qty);
        System.out.println("Inserted.");
    }

    public static void display(Connection con) throws Exception{
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery("select * from public.vendor_product_order");

        while(rs.next()){
            System.out.println("VPO Id: "+ rs.getInt(1));
            System.out.println("Product Id: "+ rs.getInt(2));
            System.out.println("Qty: "+rs.getInt(3));
            System.out.println("Price: "+ rs.getInt(4));
            System.out.println("Bill No: "+ rs.getInt(5));

        }
        rs.close();
    }

    public static void displayByBillno(Connection con, int billno) throws Exception{

        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from public.vendor_product_order where vendor_billno="+billno);

        while(rs.next()){
            System.out.println("CPO Id: "+ rs.getInt(1));
            System.out.println("Product Id: "+ rs.getInt(2));
            System.out.println("Qty: "+rs.getInt(3));
            System.out.println("Price: "+ rs.getInt(4));
            System.out.println("Bill No: "+ rs.getInt(5));

        }
        rs.close();

    }

    public static void delete(Connection con, int cpo_id) throws Exception{
        PreparedStatement ps= con.prepareStatement("delete from customer.vendor_product_order where vpo_id="+cpo_id);
        System.out.println("Deleted.");
    }

}
