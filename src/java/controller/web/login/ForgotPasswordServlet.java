package controller.web.login;

import DAO.UserDAO;
import java.io.IOException;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Email;
import model.User;

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = {"/ForgotPasswordServlet"})
public class ForgotPasswordServlet extends HttpServlet {

    private static final String FORGOT_PAGE = "view/jsp/home/forgot_password.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FORGOT_PAGE;
        HttpSession session = request.getSession();
        String emailInput = request.getParameter("txtEmail");
        String txtCode = request.getParameter("txtCode");
        String status = request.getParameter("status");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        UserDAO ud = new UserDAO();
        Email handleEmail = new Email();
        String message = "";
        String check = null;
        User user = null;
        String code_str = null;
        String emailsession = null;
        try {
            if ("forgot".equals(status)) {
                request.setAttribute("STATUS", status);
            }
            if (emailInput != null) {
                user = ud.getUserByEmail(emailInput);
                if (user != null) {
                    Random random = new Random();
                    message = "EXIST - valid email, check your email to have reset code";
                    check = "true";
                    status = "confirm";
                    Integer code = 100000 + random.nextInt(900000);
                    code_str = code.toString();
                    String subject = handleEmail.subjectForgotPass();
                    String msgEmail = handleEmail.messageFogot(user.getUserName(), code);
                    handleEmail.sendEmail(subject, msgEmail, emailInput);
                    session.setAttribute("code", code_str);
                } else {
                    message = "NOT EXIST - Invalid email";
                    check = "false";
                }
                emailsession = emailInput;
                session.setAttribute("email", emailsession);
            }
            if (txtCode != null) {
                code_str = (String) session.getAttribute("code");
                if (txtCode.equals(code_str)) {
                    message = "Valid code, enter your new password!";
                    check = "true";
                    status = "enterpass";
                } else {
                    message = "Invalid code, try again!";
                    check = "false";
                    status = "confirm";
                }
            }
            if (password != null && confirm != null) {
                if (password.equals(confirm)) {
                    String email = (String) session.getAttribute("email");
                    user = ud.getUserByEmail(email);
                    if (ud.updatePasswordUser(user, password)) {
                        message = "New password has been updated";
                        check = "true";
                        status = "success";
                    } else {
                        message = "Error, please try again!";
                        check = "false";
                        status = "enterpass";
                    }
                } else {
                    message = "Passwords do not match, please try again!";
                    check = "false";
                    status = "enterpass";
                }
            }
            request.setAttribute("check", check);
            request.setAttribute("message", message);
            request.setAttribute("STATUS", status);
        } catch (Exception ex) {
            log("ForgotPasswordServlet error: " + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Forgot Password Servlet";
    }
}
