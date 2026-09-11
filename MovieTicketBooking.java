import java.sql.*;
import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/movie_booking";
        String username = "root";
        String password = "root"; // Change according to your MySQL password

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database Connected Successfully!");

            System.out.print("Enter Customer Name: ");
            String customer = sc.nextLine();

            System.out.print("Enter Movie Name: ");
            String movie = sc.nextLine();

            System.out.print("Enter Seat Number: ");
            String seat = sc.nextLine();

            System.out.print("Enter Number of Tickets: ");
            int tickets = sc.nextInt();

            String insert = "INSERT INTO bookings(customer_name,movie_name,seat_no,ticket_count) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(insert);

            ps.setString(1, customer);
            ps.setString(2, movie);
            ps.setString(3, seat);
            ps.setInt(4, tickets);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Ticket Booked Successfully!");

            System.out.println("\nBooked Tickets");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM bookings");

            while(rs.next()) {

                System.out.println("-------------------------");
                System.out.println("Booking ID : " + rs.getInt("booking_id"));
                System.out.println("Customer : " + rs.getString("customer_name"));
                System.out.println("Movie : " + rs.getString("movie_name"));
                System.out.println("Seat No : " + rs.getString("seat_no"));
                System.out.println("Tickets : " + rs.getInt("ticket_count"));
            }

            rs.close();
            st.close();
            ps.close();
            con.close();

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}CREATE DATABASE movie_booking;

USE movie_booking;

CREATE TABLE bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(50),
    movie_name VARCHAR(50),
    seat_no VARCHAR(10),
    ticket_count INT
);

