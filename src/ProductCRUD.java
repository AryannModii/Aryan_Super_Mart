import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductCRUD {

    public static void insert(Connection con, int product_id, String name, int rate, int qty) throws Exception {

        PreparedStatement ps = con.prepareStatement("insert into public.product values (?,?,?,?)");
        ps.setInt(1, product_id);
        ps.setString(2, name);
        ps.setInt(3, rate);
        ps.setInt(4, qty);

        ps.executeUpdate();
        System.out.println("Inserted.");
    }

    public static void display(Connection con) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select product_id,product_name from public.product");

        while (rs.next()) {
            System.out.println("Product Id: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
        }
        rs.close();

    }

    public static void displayById(Connection con, int prod_id) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select product_id, product_name from public.product where product_id=" + prod_id);

        while (rs.next()) {
            System.out.println("Product Id: " + rs.getInt(1));
            System.out.println("Product Name: " + rs.getString(2));
        }
    }

    public static void delete(Connection con, int prod_id) throws Exception {

        PreparedStatement ps = con.prepareStatement("delete from public.product where product_id=" + prod_id);
        ps.setInt(1, prod_id);
        ps.executeUpdate();
        System.out.println("Deleted.");

    }

    public static void increaseStock(Connection con, int prod_id, int qty) throws Exception {

        PreparedStatement ps = con.prepareStatement("update public.product set product_qty=product_qty+" + qty + " where product_id=" + prod_id);
        ps.executeUpdate();
    }

    public static void decreaseStock(Connection con, int prod_id, int qty) throws Exception {

        PreparedStatement ps = con.prepareStatement("update public.product set product_qty=product_qty-" + qty + " where product_id=" + prod_id);
        ps.executeUpdate();
    }

    public static int getRate(Connection con, int prod_id) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select product_rate from product where product_id=" + prod_id);

        rs.next();
       return rs.getInt(1);

    }
}
//view
//update quantity
