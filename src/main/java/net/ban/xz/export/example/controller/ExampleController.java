package net.ban.xz.export.example.controller;


import net.ban.xz.export.example.service.UserService;
import net.ban.xz.export.util.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class ExampleController {


    @Autowired
    private UserService userService;


    @GetMapping("/export")
    public void exportUserList(HttpServletResponse response, HttpServletRequest request){
        try {
            ServletUtil util = new ServletUtil("用户账号列表.xls", request, response);
            util.poiExcelServlet();
            userService.exportUser(util.getOut());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
