package ru.job4j.crudservlet;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

import java.io.IOException;

public class AuthServletTest {

    private AuthServlet testServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;

    @Before
    public void setUp() {
        this.testServlet = new AuthServlet();
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
        this.dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    public void ifSignInByNonExistentUserThenServletForwardRequest() throws ServletException, IOException {
        when(this.request.getParameter("action")).thenReturn("signin");
        when(this.request.getParameter("login")).thenReturn("nonExistentUser");
        when(this.request.getParameter("password")).thenReturn("invalidPassword");
        when(this.request.getRequestDispatcher("/WEB-INF/views/auth.jsp")).thenReturn(this.dispatcher);
        testServlet.doPost(this.request, this.response);
        verify(this.request).setAttribute("error", "Неправильный логин или пароль");
        verify(this.dispatcher).forward(this.request, this.response);
    }

    @Test
    public void ifSignOutThenServletSendRedirectAndInvalidateSession() throws IOException {
        HttpSession session = mock(HttpSession.class);
        when(this.request.getParameter("action")).thenReturn("signout");
        when(this.request.getSession()).thenReturn(session);
        testServlet.doPost(this.request, this.response);
        verify(this.response).sendRedirect(this.request.getContextPath() + "/signin");
        verify(session).invalidate();
    }
}