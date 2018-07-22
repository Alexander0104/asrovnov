package ru.job4j.crudservlet;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserCreateServletTest {

    private UserCreateServlet testServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;
    private ValidateService validator = ValidateService.getInstance();

    @Before
    public void setUp() {
        this.testServlet = new UserCreateServlet();
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    public void ifCreateUserWithInvalidParametersThenServletReturnErrorText() throws ServletException, IOException {
        String userName = "testInvalidInputUser";
        when(this.request.getParameter("name")).thenReturn(userName);
        when(this.request.getRequestDispatcher("/WEB-INF/views/create_user.jsp")).thenReturn(this.dispatcher);
        this.testServlet.doPost(this.request, this.response);
        verify(this.request).setAttribute("error", "Неправильные данные, повторите попытку.");
        verify(this.dispatcher).forward(this.request, this.response);
        for (User usr : this.validator.findAll()) {
            assertNotEquals(usr.getName(), userName);
        }
    }
}