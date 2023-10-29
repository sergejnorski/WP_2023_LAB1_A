package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "TicketOrderServlet", value = "/ticketOrder")
public class TicketOrderServlet extends HttpServlet {

    public final SpringTemplateEngine springTemplateEngine;

    public TicketOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);
        WebContext context =  new WebContext(webExchange);

        context.setVariable("movieTitle", request.getParameter("title"));
        context.setVariable("numTickets",request.getParameter("tickets"));
        context.setVariable("clientName",request.getRemoteUser());
        context.setVariable("clientIP",request.getRemoteAddr());

        springTemplateEngine.process("orderConfirmation.html", context, response.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
