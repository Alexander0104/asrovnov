package ru.job4j.crudservlet;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

import java.io.IOException;

public class UsersServletTest {
    private UsersServlet testServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;

    @Before
    public void setUp() {
        this.testServlet = new UsersServlet();
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    public void ifDeleteNotUserThenServletForwardAndSendError() throws ServletException, IOException {
        when(this.request.getParameter("id")).thenReturn("-1");
        when(this.request.getRequestDispatcher("/WEB-INF/views/users.jsp")).thenReturn(this.dispatcher);
        this.testServlet.doPost(this.request, this.response);
        verify(this.dispatcher).forward(this.request, this.response);
        verify(this.request).setAttribute("error", "Пользователь не найден");
    }
}