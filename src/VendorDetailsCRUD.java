import java.sql.*;

public class VendorDetailsCRUD {

    public static void insert(Connection con,int id, String name, String address, String phno) throws Exception{

        PreparedStatement ps=
                con.prepareStatement("insert into public.vendor values (?,?,?,?)");

        ps.setInt(1,id);
        ps.setString(2, name);
        ps.setString(3, address);
        ps.setString(4,phno);

        ps.executeUpdate();
        System.out.println("Inserted.");

    }

    public static void display(Connection con) throws Exception{

        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery("select * from public.vendor");

        while (rs.next()){

            System.out.println("Id: "+ rs.getInt(1));
            System.out.println("Name: "+ rs.getString(2));
            System.out.println("Address: "+ rs.getString(3));
            System.out.println("Ph No: "+ rs.getString(4));

        }
        rs.close();

    }

    public static void displayById(Connection con, int id) throws  Exception{

        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery("select * from public.vendor where vendor_id="+id);

        while(rs.next()){

            System.out.println("Id: "+rs.getInt(1));
            System.out.println("Name: "+ rs.getString(2));
            System.out.println("Address: "+ rs.getString(3));
            System.out.println("Ph No: "+ rs.getString(4));
        }
        rs.close();
    }

    public static void delete(Connection con, int id) throws Exception{

        PreparedStatement ps= con.prepareStatement("delete from public.vendor where vendor_id=?");
        ps.setInt(1,id);
        ps.executeUpdate();
        System.out.println("Deleted.");
    }

}

