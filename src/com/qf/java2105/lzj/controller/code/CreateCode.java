package com.qf.java2105.lzj.controller.code;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author lzj
 * @Date 2021/9/14
 */
@WebServlet("/createCode")
public class CreateCode extends HttpServlet {

        @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidateCode vc = new ValidateCode(200,30,4,10);
        String code = vc.getCode();
        request.getSession().setAttribute("code",code);
        vc.write(response.getOutputStream());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
