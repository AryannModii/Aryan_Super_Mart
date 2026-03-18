import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;

public class CustomerBillCRUD {

    public static void insert(Connection con, int billno, String date, int cust_id, int discount ) throws Exception{

        PreparedStatement ps= con.prepareStatement("insert into public.customer_bill(customer_billno,customer_billdate,customer_id,customer_discount, customer_tax) values (?,?,?,?,12)");
        ps.setInt(1,billno);
        ps.setString(2,date);
        ps.setInt(3,cust_id);
        ps.setInt(4,discount);

        ps.executeUpdate();
        System.out.println("Inserted.");

    }

    public static void display(Connection con) throws Exception{

        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery("select * from public.customer_bill");
        while(rs.next()){
            System.out.println("Bill No: "+ rs.getInt(1));
            System.out.println("Date: "+ rs.getString(2));

            CustomerDetailsCRUD.displayById(con,rs.getInt(3));

            //System.out.println("Customer Id: "+ rs.getInt(3));
            System.out.println("Discount: "+ rs.getInt(4));
            System.out.println("Tax: "+ rs.getInt(5)+"%");
            System.out.println("Total: "+ rs.getInt(6));


        }
        rs.close();
    }

    public static void displayByBillno(Connection con, int billno ) throws Exception{

        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery("select * from public.customer_bill where customer_billno="+billno);

        while (rs.next()){
            System.out.println("Bill No: "+ rs.getInt(1));
            System.out.println("Date: "+ rs.getString(2));

            CustomerDetailsCRUD.displayById(con,rs.getInt(3));

            //System.out.println("Customer Id: "+ rs.getInt(3));
            System.out.println("Discount: "+ rs.getInt(4));
            System.out.println("Tax: "+ rs.getInt(5)+"%");
            System.out.println("Total: "+ rs.getInt(6));

        }
        rs.close();

    }

    public static void displayByCustomerId(Connection con, int cust_id) throws Exception{

        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from public.customer_bill where customer_id="+cust_id);

        while(rs.next()){
            System.out.println("Bill No: "+ rs.getInt(1));
            System.out.println("Date: "+ rs.getString(2));

            CustomerDetailsCRUD.displayById(con,rs.getInt(3));

            //System.out.println("Customer Id: "+ rs.getInt(3));
            System.out.println("Discount: "+ rs.getInt(4));
            System.out.println("Tax: "+ rs.getInt(5)+"%");
            System.out.println("Total: "+ rs.getInt(6));
        }

    }

    public static void delete(Connection con, int billno) throws Exception{

        PreparedStatement ps= con.prepareStatement("delete from customer.bill where customer_billno="+billno);
        System.out.println("Deleted.");
    }



}
