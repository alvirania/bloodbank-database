package bbms;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BBMS {
    
    public static void q1() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("------------------------");
            System.out.println("List of Universal Donors");
            System.out.println("------------------------");
            //Execute Query
            stmt = c.createStatement();
            String sql = "SELECT firstName || ' ' ||lastName AS UniversalDonors "
                       + "FROM Donor "
                       + "WHERE bloodType = 'O-'; ";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                String univDonors = rs.getString("UniversalDonors");
                System.out.println(univDonors);
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    }
    
    public static void q2() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("Opened Database Successfully!");
            System.out.println("-----------------------------------------------------------");
            System.out.println("List of all Plasma donations made at Mount Sinai Blood Bank");
            System.out.println("-----------------------------------------------------------");
            //Execute Query
            stmt = c.createStatement();
            //2 - list all plasma donations made to Mt. Sinai Blood Bank
            String sql = "SELECT donorID, sampletype, date " + 
                         "FROM DonationSample, BloodBank " +
                         "WHERE DonationSample.locationID = BloodBank.locationID " + 
                         "AND BloodBank.Name = 'Mount Sinai Blood Bank' " +
                         "AND DonationSample.sampletype = 'PLASMA' " + 
                         "ORDER BY date ASC;";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                int donorID = rs.getInt("donorID");
                String sample = rs.getString("sampletype");
                String dateStr = rs.getString("date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date donation_date = sdf.parse(dateStr);
                System.out.println("DonorID: " + donorID);
                System.out.println("Sample Type: " + sample);
                System.out.println("Date: " + donation_date + "\n");
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    }
    
    public static void q3() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("Opened Database Successfully!");
            System.out.println("-----------------------------------------------------");
            System.out.println("List of Donors who donated at Canadian Blood Services");
            System.out.println("-----------------------------------------------------");
            //Execute Query
            stmt = c.createStatement();
            //2 - list all plasma donations made to Mt. Sinai Blood Bank
            String sql = "SELECT Donor.firstName, Donor.lastName, DonationSample.date, DonationSample.sampletype " + 
                         "FROM Donor " +
                         "JOIN DonationSample ON Donor.donorID = DonationSample.donorID " + 
                         "JOIN BloodBank ON DonationSample.locationID = BloodBank.locationID " +
                         "WHERE BloodBank.name = 'Canadian Blood Services' " + 
                         "GROUP BY Donor.firstName, Donor.lastName;";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                String fn = rs.getString("firstName");
                String ln = rs.getString("lastName");
                String sample = rs.getString("sampletype");
                String dateStr = rs.getString("date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date donation_date = sdf.parse(dateStr);
                System.out.println("Name: " + fn + " " + ln);
                System.out.println("Sample Type: " + sample);
                System.out.println("Date: " + donation_date + "\n");
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    }
    
    public static void q4() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("Opened Database Successfully!");
            System.out.println("---------------------------------------------------------");
            System.out.println("List of Recipients registered at Toronto General Hospital");
            System.out.println("---------------------------------------------------------");
            //Execute Query
            stmt = c.createStatement();
            String sql = "SELECT Hospital.HospitalName, Hospital.clinicalDept, Recipient.fullname, Recipient.bloodType " + 
                         "FROM Hospital " +
                         "JOIN Recipient ON Hospital.hospitalID = Recipient.hospitalID " + 
                         "WHERE Hospital.hospitalName = 'Toronto General'; ";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                String name = rs.getString("fullname");
                String sample = rs.getString("bloodType");
                String hn = rs.getString("hospitalName");
                String dept = rs.getString("clinicalDept");
                System.out.println("Name: " + name);
                System.out.println("Blood Type: " + sample);
                System.out.println("Hospital: " + hn);
                System.out.println("Clinical Dept: " + dept + "\n");
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    }
    
    public static void q5() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("Opened Database Successfully!");
            System.out.println("------------------------------------------------------");
            System.out.println("Hospitals that take donations from Sunnybrook Lifebank");
            System.out.println("------------------------------------------------------");
            //Execute Query
            stmt = c.createStatement();
            String sql = "SELECT Bloodbank.Name, Hospital.hospitalID, Hospital.hospitalName, Hospital.clinicalDept " + 
                         "FROM Bloodbank " +
                         "JOIN Hospital ON Bloodbank.locationID = Hospital.locationID " + 
                         "WHERE Bloodbank.Name = 'Sunnybrook Lifebank'; ";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                String bb = rs.getString("Name");
                int id = rs.getInt("hospitalID");
                String hn = rs.getString("hospitalName");
                String dept = rs.getString("clinicalDept");
                System.out.println("Hospital: " + hn);
                System.out.println("Clinical Dept: " + dept );
                System.out.println("Location ID: " + id + "\n");
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    } 

    public static void q6() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("Opened Database Successfully!");
            System.out.println("------------------------------------");
            System.out.println("Donors that can donate to Mary Smith");
            System.out.println("------------------------------------");
            //Execute Query
            stmt = c.createStatement();
            String sql = "SELECT Donor.firstName, Donor.lastName, Donor.bloodType, Recipient.bloodType AS rbt " + 
                         "FROM Donor " +
                         "INNER JOIN CanDonateTo ON Donor.donorID = CanDonateTo.donor_id " + 
                         "INNER JOIN Recipient ON CanDonateTo.recipient_id = Recipient.recipientID " + 
                         "WHERE Recipient.fullname = 'Mary Smith';";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                String dbt = rs.getString("bloodType");
                String fn = rs.getString("firstName");
                String ln = rs.getString("lastName");
                String rbt = rs.getString("rbt");
                System.out.println("Donor Name " + fn + " " + ln );
                System.out.println("Donor Blood Type: " + dbt );
                System.out.println("Blood Type of Recipient: " + rbt + "\n");
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    }
    
    public static void q7() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("Opened Database Successfully!");
            System.out.println("-------------------------------------------");
            System.out.println("List the donation history of Shahrose Javed");
            System.out.println("-------------------------------------------");
            //Execute Query
            stmt = c.createStatement();
            //2 - list all plasma donations made to Mt. Sinai Blood Bank
            String sql = "SELECT Donor.firstName, Donor.lastName, DonationSample.date, DonationSample.sampletype, BloodBank.Name " + 
                         "FROM DonationSample " +
                         "INNER JOIN Donor ON DonationSample.donorID = Donor.donorID " + 
                         "INNER JOIN BloodBank ON DonationSample.locationID = BloodBank.locationID " +
                         "WHERE Donor.firstName = 'Shahrose' AND Donor.lastName = 'Javed'; " + 
                         "ORDER BY DonationSample.date DESC; ";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                String fn = rs.getString("firstName");
                String ln = rs.getString("lastName");
                String sample = rs.getString("sampletype");
                String dateStr = rs.getString("date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date donation_date = sdf.parse(dateStr);
                String bb = rs.getString("Name");
                System.out.println("Name: " + fn + " " + ln);
                System.out.println("Sample Type: " + sample);
                System.out.println("Date: " + donation_date);
                System.out.println("Blood bank: " + bb + "\n");
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    }
    
    public static void q8() {
        Connection c = null;
        Statement stmt = null;
        try {
            //Database Connection
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:bloodbank2.db");
            System.out.println("Opened Database Successfully!");
            System.out.println("-----------------------------------------------------------");
            System.out.println("List of all Plasma donations made at Mount Sinai Blood Bank");
            System.out.println("-----------------------------------------------------------");
            //Execute Query
            stmt = c.createStatement();
            //2 - list all plasma donations made to Mt. Sinai Blood Bank
            String sql = "SELECT Donor.firstName, Donor.lastName, Donor.donorID, BloodBank.Name, DonationSample.sampletype, DonationSample.date " + 
                         "FROM DonationSample " +
                         "INNER JOIN Donor ON DonationSample.donorID = Donor.donorID " + 
                         "INNER JOIN BloodBank ON DonationSample.locationID = BloodBank.locationID " +
                         "WHERE DonationSample.sampleType = 'BLOOD' " + 
                         "ORDER BY Donor.donorID ASC;";
            ResultSet rs = stmt.executeQuery(sql);
            //Print data from dataset
            while (rs.next()) {
                String fn = rs.getString("firstName");
                String ln = rs.getString("lastName");
                int donorID = rs.getInt("donorID");
                String sample = rs.getString("sampletype");
                String bb = rs.getString("Name");
                String dateStr = rs.getString("date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date donation_date = sdf.parse(dateStr);
                System.out.println("Name: " + fn + " " + ln);
                System.out.println("DonorID: " + donorID);
                System.out.println("Sample Type: " + sample);
                System.out.println("Blood bank: " + bb);
                System.out.println("Date: " + donation_date + "\n");
            }
            //clear query and close database
            rs.close();
            stmt.close();
            c.close();
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("-------QUERY COMPLETED-------");
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        
        System.out.println("----BLOOD BANK MANAGEMENT SYSTEM----");
        do {
            System.out.print("Please enter the following numbers for each option\n" +
                    "1 - list all universal donors (donors with O- blood type)\n" +
                    "2 - list all plasma donations made to Mount Sinai Blood Bank\n" +
                    "3 - list the name of donors who made a donation to Canadian Blood Services.\n" + 
                    "4 - list the recipients receiving care at Toronto General Hospital\n" + 
                    "5 - list the the hospitals that take donations from Sunnbrook Lifebank\n" +
                    "6 - list the donors that can donate to Mary Smith (blood type - A+)\n" +
                    "7 - list the donation history of Shahrose Javed\n" +
                    "8 - list all blood donations across all bloodbanks\n" +
                    /**"9 - \n" +
                    "10 - \n" +**/
                    "0 - Exit Program\n" +
                    "Enter your Option: ");
            option = sc.nextInt();
            switch(option) {
                case 1:
                    q1();
                    break;
                case 2:
                    q2();
                    break;
                case 3:
                    q3();
                    break;
                case 4:
                    q4();
                    break;
                case 5:
                    q5();
                    break;
                case 6:
                    q6();
                    break;
                case 7:
                    q7();
                    break;
                case 8:
                    q8();
                    break;
            }
        }
        while (option !=0);
        
        
    }
    
}
