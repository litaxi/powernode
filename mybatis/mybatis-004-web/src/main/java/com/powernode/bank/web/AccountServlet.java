package com.powernode.bank.web;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TrensferException;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author wataxi
 * @Date 2023/9/23 13:23
 * @Version 1.0
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        try {
            accountService.Transfer(fromActno, toActno, money);
            response.sendRedirect(request.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath() + "/error1.html");
            throw new RuntimeException(e);
        } catch (TrensferException e) {
            response.sendRedirect(request.getContextPath() + "/error2.html");
            throw new RuntimeException(e);
        }

    }
}
