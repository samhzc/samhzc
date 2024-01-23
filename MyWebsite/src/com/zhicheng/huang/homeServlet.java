package com.zhicheng.huang;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Verification")
public class homeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String referer = req.getHeader("referer");
        if(referer != null){
            if(referer.contains("MyWebsite")){
                String accessCode = req.getParameter("accessCode");
                System.out.println("post");
                System.out.println(accessCode);
                if(accessCode.equals("samhuang")){
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/HomePage.html");
                    dispatcher.forward(req,resp);
                }
                else {
                    RequestDispatcher noAccess_dispatcher = req.getRequestDispatcher("/AccessCodeIncorrect.html");
                    noAccess_dispatcher.forward(req,resp);
                }
            }
            else {
                RequestDispatcher noAccess_dispatcher = req.getRequestDispatcher("/InvalidAccess.html");
                noAccess_dispatcher.forward(req,resp);
            }
        }
        else {
            RequestDispatcher noAccess_dispatcher = req.getRequestDispatcher("/InvalidAccess.html");
            noAccess_dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
