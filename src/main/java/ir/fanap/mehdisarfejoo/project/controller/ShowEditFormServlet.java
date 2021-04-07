package ir.fanap.mehdisarfejoo.project.controller;

import ir.fanap.mehdisarfejoo.project.service.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowEditFormServlet", urlPatterns = "/editForm")
public class ShowEditFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PhoneService service = new PhoneService(request, response);
        service.showEditForm();
    }
}
