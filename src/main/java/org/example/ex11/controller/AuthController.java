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









//package org.example.ex11.controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.util.Random;
//
//@WebServlet("/auth")
//public class AuthController extends HttpServlet
//{
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Random rand = new Random();
//        int luckyNumber = rand.nextInt(100);
//        HttpSession session = req.getSession();
//        if (session.getAttribute("lucky_number") == null) {
//            session.setAttribute("lucky_number", luckyNumber);
//        }
//        if (session.getAttribute("is_login") != null && (boolean) session.getAttribute("is_login")) {
//            req.getRequestDispatcher("/success.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("/auth.jsp").forward(req, resp);
//        }
//    req.getRequestDispatcher("/WEB-INF/auth.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // forward, redirect
//        // 전화돌리기 -> 02-1111-1111 => 내가 아냐
//        // -> 옆자리야. 그 사람한테 그냥 줘. (forward)
//        // 02-1111-1112번이니까 새로 전화 거세요. (redirect)
//        // 서버 상태 관리 -> 내가 원래에 요청했던 정보는 어떻게 되는 거에요?
//        // 1. DB에 기록을 해버려 -> 모든 걸 DB에 넣으면 서버가 힘들어함. 돈 많이 듦. 느려요.
//        // 2. 세션 -> 임시로 어딘가로 저장해놔요. 그리고 가끔 지워요. (메모지)
//        // 3. 쿠키/브라우저 -> 당신이 기록해요. 전달할 때마다 끼워줘.
//        // -> CSR, SPA
//        // -> 가장 위조가 쉬움
//        if(req.getParameter("id".equals("session") && req.getParameter("password".equals("cookie")) {
//            HttpSession session = req.getSession();
//            session.setAttribute("is_login", true);
//        }
//        resp.sendRedirect(req.getRequestURI());
//    }
//}
