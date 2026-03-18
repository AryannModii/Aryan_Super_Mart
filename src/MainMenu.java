import javax.xml.transform.Source;
import java.sql.Connection;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws Exception {

        Connection con = DBConnectivity.getPostgresConnection();
        Scanner scanner = new Scanner(System.in);

        int mainmenuopt = 0;

        do {
            System.out.println("\t\t\tAryan Super Mart");
            System.out.println("\t 1.Vendor Details");
            System.out.println("\t 2.Customer Details");
            System.out.println("\t 3.Customer Bill/Order");
            System.out.println("\t 4.Vendor Bill/Order");
            System.out.println("\t 5.Products");
            System.out.println("\t 6.Exit");

            System.out.println("Enter your choice: ");
            mainmenuopt = scanner.nextInt();

            switch (mainmenuopt) {

                case 1:
                    int vendordetailsopt = 0;
                    do {
                        System.out.println("\t\t Vendor Details: ");
                        System.out.println("\t 1. New Vendor Entry");
                        System.out.println("\t 2. View All");
                        System.out.println("\t 3. Search By Id");
                        System.out.println("\t 4. Delete Vendor");
                        System.out.println("\t 5.Exit");

                        System.out.println("Enter your choice: ");
                        vendordetailsopt = scanner.nextInt();

                        switch (vendordetailsopt) {

                            case 1:
                                String opt = " ";
                                do {


                                    System.out.println("Vendor Id: ");
                                    int vendorId = scanner.nextInt();
                                    System.out.println("Vendor Name: ");
                                    String vendorName = scanner.next();
                                    System.out.println("Address: ");
                                    String vendorAddress = scanner.next();
                                    System.out.println("Phone Number: ");
                                    String vendorPhno = scanner.next();

                                    VendorDetailsCRUD.insert(con, vendorId, vendorName, vendorAddress, vendorPhno);

                                    System.out.println("Enter y to add another entry or any other key to leave.");
                                    opt = scanner.next();
                                } while (opt.equalsIgnoreCase("y"));
                                break;

                            case 2:
                                VendorDetailsCRUD.display(con);
                                break;

                            case 3:
                                System.out.println("Enter Id to search: ");
                                int search_id = scanner.nextInt();
                                VendorDetailsCRUD.displayById(con, search_id);

                                break;

                            case 4:
                                System.out.println("Enter Id to Delete: ");
                                int id = scanner.nextInt();
                                VendorDetailsCRUD.delete(con, id);
                                break;
                        }

                    } while (vendordetailsopt != 5);

                case 2:
                    int customerdetailsopt = 0;
                    do {
                        System.out.println("\t\t Customer Details: ");
                        System.out.println("\t 1. New Customer Entry");
                        System.out.println("\t 2. View All");
                        System.out.println("\t 3. Search By Id");
                        System.out.println("\t 4. Delete Customer");
                        System.out.println("\t 5.Exit");

                        System.out.println("Enter your choice: ");
                        customerdetailsopt = scanner.nextInt();

                        switch (customerdetailsopt) {

                            case 1:
                                String opt = " ";
                                do {


                                    System.out.println("Customer Id: ");
                                    int custId = scanner.nextInt();
                                    System.out.println("Cust Name: ");
                                    String custName = scanner.next();
                                    System.out.println("Address: ");
                                    String custAddress = scanner.next();
                                    System.out.println("Phone Number: ");
                                    String custPhno = scanner.next();

                                    CustomerDetailsCRUD.insert(con, custId, custName, custAddress, custPhno);

                                    System.out.println("Enter y to add another entry or any other key to leave.");
                                    opt = scanner.next();
                                } while (opt.equalsIgnoreCase("y"));
                                break;

                            case 2:
                                CustomerDetailsCRUD.display(con);
                                break;

                            case 3:
                                System.out.println("Enter Id to search: ");
                                int search_id = scanner.nextInt();
                                CustomerDetailsCRUD.displayById(con, search_id);

                                break;

                            case 4:
                                System.out.println("Enter Id to Delete: ");
                                int id = scanner.nextInt();
                                CustomerDetailsCRUD.delete(con, id);
                        }

                    } while (customerdetailsopt != 5);

                case 3:
                    int customerorderopt=0;

                    do {
                        System.out.println("\t\t Customer Order: ");
                        System.out.println("\t 1.Add Bill");
                        System.out.println("\t 2.View All");
                        System.out.println("\t 3.Search by Bill Id ");
                        System.out.println("\t 4.Search by Customer Id: ");
                        System.out.println("\t 5.Delete");
                        System.out.println("\t 6.Exit");

                        System.out.println("Enter your choice: ");
                        customerorderopt= scanner.nextInt();

                        switch (customerorderopt){


                        }

                    }while(customerorderopt!=6);

            }

        } while (mainmenuopt != 6);
    }
}
