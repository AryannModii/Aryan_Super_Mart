import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.SQLOutput;
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

                    break;

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

                                break;
                        }


                    } while (customerdetailsopt != 5);

                    break;

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
                            case 1:
                                System.out.println("Enter Bill No.: ");
                                int billno= scanner.nextInt();

                                System.out.println("Enter Date: ");
                                String date= scanner.next();

                                System.out.println("Enter Customer Id: ");
                                int cust_id= scanner.nextInt();

                                System.out.println("Enter Discount (%): ");
                                int discount= scanner.nextInt();

                                CustomerBillCRUD.insert(con,billno,date,cust_id,discount);
                                break;

                            case 2:
                                CustomerBillCRUD.display(con);
                                break;

                            case 3:
                                System.out.println("Enter Bill Id: ");
                                int id= scanner.nextInt();
                                CustomerBillCRUD.displayByBillno(con,id);
                                break;

                            case 4:
                                System.out.println("Enter Customer Id: ");
                                int id2= scanner.nextInt();
                                CustomerBillCRUD.displayByCustomerId(con,id2);
                                break;

                            case 5:
                                System.out.println("Enter Bill Id to delete: ");
                                int id3= scanner.nextInt();
                                CustomerBillCRUD.delete(con,id3);
                                break;
                        }

                    }while(customerorderopt!=6);

                    break;

                case 4:
                    int vendororderopt=0;

                    do {
                        System.out.println("\t\t Vendor Order: ");
                        System.out.println("\t 1.Add Bill");
                        System.out.println("\t 2.View All");
                        System.out.println("\t 3.Search by Bill Id ");
                        System.out.println("\t 4.Search by Vendor Id: ");
                        System.out.println("\t 5.Delete");
                        System.out.println("\t 6.Exit");

                        System.out.println("Enter your choice: ");
                        vendororderopt= scanner.nextInt();

                        switch (vendororderopt){
                            case 1:
                                System.out.println("Enter Bill No.: ");
                                int billno= scanner.nextInt();

                                System.out.println("Enter Date: ");
                                String date= scanner.next();

                                System.out.println("Enter Vendor Id: ");
                                int cust_id= scanner.nextInt();
                                VendorBillCRUD.insert(con,billno,date,cust_id,0);
                                int vpo_id=1;
                                String opt=" ";
                                do {

                                    System.out.println("Enter Product Id: ");
                                    int prod_id= scanner.nextInt();
                                    System.out.println("Enter Quantity: ");
                                    int qty= scanner.nextInt();
                                    VendorProductOrderCRUD.insert(con,vpo_id,prod_id,qty,(ProductCRUD.getRate(con,prod_id)*qty),billno);
                                    VendorBillCRUD.updateTotal(con,billno,(ProductCRUD.getRate(con,prod_id)*qty));
                                    vpo_id++;
                                    System.out.println("Enter y to continue or other key to leave.");
                                    opt= scanner.next();

                                }while(opt.equalsIgnoreCase("y"));

                                System.out.println("Enter Discount (%): ");
                                int discount= scanner.nextInt();



                                VendorBillCRUD.discountAmount(con,discount,billno);


                                break;

                            case 2:
                                VendorBillCRUD.display(con);

                                break;

                            case 3:
                                System.out.println("Enter Bill Id: ");
                                int id= scanner.nextInt();
                                VendorBillCRUD.displayByBillno(con,id);

                                break;

                            case 4:
                                System.out.println("Enter Customer Id: ");
                                int id2= scanner.nextInt();
                                VendorBillCRUD.displayByCustomerId(con,id2);

                                break;

                            case 5:
                                System.out.println("Enter Bill Id to delete: ");
                                int id3= scanner.nextInt();
                                VendorBillCRUD.delete(con,id3);

                                break;
                        }

                    }while(vendororderopt!=6);

                    break;

                case 5:
                    int productopt=0;
                    do {

                        System.out.println("\t\t Products");
                        System.out.println("\t 1.Add Product");
                        System.out.println("\t 2.View All");
                        System.out.println("\t 3.Search by Id");
                        System.out.println("\t 4.Delete");
                        System.out.println("\t 5.Exit");

                        System.out.println("Enter you choice: ");
                        productopt= scanner.nextInt();

                        switch (productopt){

                            case 1:
                                String opt="";
                                do {


                                    System.out.println("Enter Product Id: ");
                                    int prod_id = scanner.nextInt();
                                    System.out.println("Enter Product Name: ");
                                    String name = scanner.next();
                                    System.out.println("Enter Rate: ");
                                    int rate = scanner.nextInt();
                                    System.out.println("Enter Quantity: ");
                                    int qty = scanner.nextInt();

                                    ProductCRUD.insert(con, prod_id, name, rate, qty);

                                    System.out.println("Enter y to add another product or any other key to leave.");
                                    opt = scanner.next();
                                }while(opt.equalsIgnoreCase("y"));

                                break;

                            case 2:
                                ProductCRUD.display(con);
                                break;

                            case 3:
                                int search_id=0;
                                System.out.println("Enter Product Id: ");
                                search_id= scanner.nextInt();
                                ProductCRUD.displayById(con,search_id);
                                break;

                            case 4:
                                int id2=0;
                                System.out.println("Enter Product Id to delete: ");
                                id2= scanner.nextInt();
                                ProductCRUD.delete(con,id2);
                                break;
                        }


                    }while(productopt!=5);

                    break;
            }

        } while (mainmenuopt != 6);
    }
}
