package ir.fanap.mehdisarfejoo.project.service;

import ir.fanap.mehdisarfejoo.project.dao.PhoneDAO;
import ir.fanap.mehdisarfejoo.project.entity.device.Phone;
import ir.fanap.mehdisarfejoo.project.factory.ObjectFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PhoneService {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ObjectFactory factory;
    private PhoneDAO phoneDAO;

    public PhoneService(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;
        this.response = response;
        factory = new ObjectFactory();
        phoneDAO = new PhoneDAO();
    }

    public void create() throws ServletException, IOException {

        String number = request.getParameter("number");
        String simCardOperator = request.getParameter("simCard");
        String phoneType = request.getParameter("device");

        Phone myPhone;

        // Before:
        // myPhone = new SmartPhone(new HamraheAvalSIMCard());

        // Now:
        // bejaye code bala, inja IOC(Inversion Of Control) darim:
        myPhone = factory.getBean(phoneType, simCardOperator);
        myPhone.getSimCard().setNumber(number);

        Phone phone = phoneDAO.create(myPhone);

        HttpSession session = request.getSession();
        session.setAttribute("thePhone", phone);

        String path = "/showSimcardInfo";
        dispatch(path);
    }

    public void addCharge() throws ServletException, IOException {

        int amount = Integer.parseInt(request.getParameter("amount"));

        HttpSession session = request.getSession(false);
        Phone thePhone = (Phone) session.getAttribute("thePhone");

        double realAmount = getAmountBasedOnOption(amount);

        thePhone.getSimCard().setBalance(thePhone.getSimCard().getBalance() + realAmount);

        phoneDAO.update(thePhone);

        session.setAttribute("thePhone", thePhone);

        String message = "Your SIMCard Has Been Charged " + realAmount + " Rial.";

        request.setAttribute("message", message);

        String path = "frontend/simcard_info.jsp";
        dispatch(path);
    }

    public void login() throws ServletException, IOException {

        String number = request.getParameter("number");
        Phone phoneFoundByNumber = phoneDAO.findByNumber(number);

        String path;

        if (phoneFoundByNumber == null) {

            String message = "Login Failed. Wrong Number.";

            request.setAttribute("message2", message);

            path = "frontend/message.jsp";
        } else {

            HttpSession session = request.getSession();
            session.setAttribute("thePhone", phoneFoundByNumber);

            path = "frontend/simcard_info.jsp";
        }

        dispatch(path);
    }

    public double getAmountBasedOnOption(int option) {

        switch (option) {
            case 1:
                option = 10_000;
                return option;
            case 2:
                option = 20_000;
                return option;
            case 3:
                option = 50_000;
                return option;
        }
        return 10_000;
    }

    public void logout() throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

        String message = "You have successfully logged out!";
        request.setAttribute("message2", message);
        String path = "frontend/message.jsp";

        dispatch(path);
    }


    public void edit() throws ServletException, IOException {

        String number = request.getParameter("number");
        String simCardOperator = request.getParameter("simCard");
        String phoneType = request.getParameter("device");

        HttpSession session = request.getSession();
        Phone thePhone = (Phone) session.getAttribute("thePhone");

        thePhone.getSimCard().setNumber(number);
        thePhone.setType(phoneType);

        phoneDAO.update(thePhone);

        session.setAttribute("thePhone", thePhone);

        String path = "frontend/simcard_info.jsp";
        dispatch(path);
    }

    public void delete() throws ServletException, IOException {

        HttpSession session = request.getSession();
        Phone thePhone = (Phone) session.getAttribute("thePhone");

        phoneDAO.delete(thePhone.getId());

        logout();
    }

    public void showRegisterForm() throws ServletException, IOException {

        String path = "frontend/register_form.jsp";
        dispatch(path);
    }

    public void showInfo() throws ServletException, IOException {

        String path = "frontend/simcard_info.jsp";
        dispatch(path);
    }

    public void viewChargeList() throws ServletException, IOException {

        String path = "frontend/charge_simcard.jsp";
        dispatch(path);
    }

    public void showLoginForm() throws ServletException, IOException {
        String path = "frontend/login_form.jsp";
        dispatch(path);
    }

    public void showEditForm() throws ServletException, IOException {

        String path = "frontend/edit_form.jsp";

        dispatch(path);
    }

    private void dispatch(String path) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
