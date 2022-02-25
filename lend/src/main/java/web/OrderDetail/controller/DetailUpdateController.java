package web.OrderDetail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.OrderDetail.service.OrderService;
import web.OrderDetail.vo.OrderDetailVO;

@RestController
public class DetailUpdateController {
    @Autowired
    private OrderService os;
    @RequestMapping(path = {"/Cusotmer/Orderd/Detail/update"})
    public String update(@RequestBody(required = false) OrderDetailVO vo, HttpSession session){
        if(session.getAttribute("cuatomerAccount") != null){
            return os.update(vo);
        }
        return "must login";
    }
}
