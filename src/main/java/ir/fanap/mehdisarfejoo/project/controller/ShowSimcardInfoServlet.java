package ir.fanap.mehdisarfejoo.project.controller;

import ir.fanap.mehdisarfejoo.project.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowSimcardInfoServlet", urlPatterns = "/showSimcardInfo")
public class ShowSimcardInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PhoneService service = new PhoneService(request, response);
        service.showInfo();
    }
}
