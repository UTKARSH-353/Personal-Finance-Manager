import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/personalFinanceManager")
public class PersonalFinanceManagerServlet extends HttpServlet {

    // Simple in-memory mock database (In-memory storage for users)
    private static List<User> users = new ArrayList<>();
    private static User loggedInUser = null;

    // Handle GET request (display registration or profile page)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (loggedInUser == null) {
            // If the user is not logged in, show the registration form
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request, response);
        } else {
            // If logged in, show user profile page
            request.setAttribute("user", loggedInUser); // Set logged in user data
            RequestDispatcher dispatcher = request.getRequestDispatcher("/userProfile.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Handle POST request (handle registration, login, and logout)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            // Register user
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            // Create a new user and add it to the mock database
            User newUser = new User(username, password, email);
            users.add(newUser);
            loggedInUser = newUser;  // Auto-login after registration

            response.sendRedirect("personalFinanceManager");

        } else if ("login".equals(action)) {
            // Simple login (validation)
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            for (User user : users) {
                if (user.getUsername().equals(username) && user.password.equals(password)) {
                    loggedInUser = user;
                    response.sendRedirect("personalFinanceManager");
                    return;
                }
            }
            // Invalid credentials
            response.getWriter().println("<html><body><h3>Invalid login credentials!</h3></body></html>");
        } else if ("logout".equals(action)) {
            // Logout the user
            loggedInUser = null;
            response.sendRedirect("personalFinanceManager");
        }
    }
}
