package com.eg.action;

import com.webservice.personservice.IPersonService;
import com.webservice.personserviceimpl.PersonServiceImpl;

import java.io.IOException;

/**
 * Created by zhujn on 2019/9/11.
 */
public class PersonServlet extends javax.servlet.http.HttpServlet {

   IPersonService personService
           = new PersonServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       request.setAttribute("person",personService.findPerson(1));
        request.getRequestDispatcher("hello.jsp")
                .forward(request,response);
    }
}
