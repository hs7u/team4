package web.OrderDetail.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.OrderDetail.service.OrderService;
import web.OrderDetail.vo.OrderDetailVO;

@RestController
public class addOrderDetailController {
    @Autowired
    private OrderService os;

    @RequestMapping(path = {"/Cusotmer/Orderd/Detail/insert"})
    public String insert(@RequestBody(required = false) OrderDetailVO vo, HttpSession session){
        if(session.getAttribute("cuatomerAccount") != null){
            return os.insert(vo);
        }
        return "must login";
    }
}
