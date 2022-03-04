package web.Admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Admin.service.AdminService;
import web.Admin.vo.AdminVO;

@RestController
public class RegistController {
    @Autowired
    private AdminService as;
    @RequestMapping(path = {"/Admin/regist"}, method = RequestMethod.POST)
    public String regist(@RequestBody AdminVO vo, HttpSession session, HttpServletResponse response) throws IOException {
        if(session.getAttribute("account") == null){
            AdminVO regist = as.getOneManager(vo);
            if(regist == null){
                return as.newManager(vo);
            }
        }
        response.sendRedirect("/Admin/AdminDashBoard_v2.html");
        return null;
    }
}
