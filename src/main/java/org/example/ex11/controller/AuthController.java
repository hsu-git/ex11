package org.example.ex11.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

@WebServlet("/auth")
public class AuthController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // lucky_number는 이미 세션에 저장되어 있을 수 있으므로, null 체크 후 초기화
        if (session.getAttribute("lucky_number") == null) {
            Random rand = new Random();
            int luckyNumber = rand.nextInt(100);
            session.setAttribute("lucky_number", luckyNumber);
        }

        // 로그인 여부 체크
        if (session.getAttribute("is_login") != null && (boolean) session.getAttribute("is_login")) {
            req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/auth.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("pw");

        // 입력값이 null이거나 빈 값일 수 있기 때문에 null 체크 추가
        if (id != null && password != null && id.equals("session") && password.equals("cookie")) {
            HttpSession session = req.getSession();
            session.setAttribute("is_login", true);
        }

        // POST 요청 처리 후 현재 URL로 리다이렉션
        resp.sendRedirect(req.getRequestURI());
    }
}