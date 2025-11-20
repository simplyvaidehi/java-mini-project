import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DatabaseSetupServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "");

            Statement stmt = con.createStatement();

            String st = "CREATE TABLE IF NOT EXISTS emppppp ("
                    + "id INT PRIMARY KEY, "
                    + "name VARCHAR(20), "
                    + "desig VARCHAR(20), "
                    + "salary INT)";

            stmt.executeUpdate(st);

            out.println("<h3>Table Created Successfully!</h3>");

            stmt.close();
            con.close();
        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }

        out.close();
    }
}
