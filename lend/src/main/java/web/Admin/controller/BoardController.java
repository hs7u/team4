package web.Admin.controller;

import static web.CommonUtil.StaticUtil.GSON;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Admin.vo.AdminVO;
import web.Course.service.CourseService;
import web.Course.vo.CourseVO;
import web.Customer.service.CustomerService;
import web.Customer.vo.CustomerVO;
import web.CustomerOrders.service.CustomerOrdersService;
import web.CustomerOrders.vo.CustomerOrdersVO;

@RestController
public class BoardController {
    @Autowired
    private CustomerService cs;
    @Autowired
    private CourseService csc;
    @Autowired
    private CustomerOrdersService cos;
    @RequestMapping(path = {"/Admin/dashBoard"}, method = RequestMethod.POST)
    public ResponseEntity<?> dashBoardInfo(@RequestBody String action, HttpSession session) {
        JsonObject jsonObject = GSON.fromJson(action, JsonObject.class);
        switch (jsonObject.get("action").getAsString()) {
            case "customer":
                return new ResponseEntity<Long>(cs.countCustomer(), HttpStatus.OK);
            case "course":
                return new ResponseEntity<Long>(csc.countCourse(), HttpStatus.OK);
            case "order":
                return new ResponseEntity<Long>(cos.countOrder(), HttpStatus.OK);
            case "income":
                return new ResponseEntity<Integer>(getIncomeCount(), HttpStatus.OK);
            case "accountInfo":
                return new ResponseEntity<AdminVO>((AdminVO)session.getAttribute("info"), HttpStatus.OK);
            case "customerList":
                return new ResponseEntity<List<CustomerVO>>(cs.getAllCustomer(), HttpStatus.OK);
            case "courseList":
                return new ResponseEntity<List<CourseVO>>(csc.getALL(), HttpStatus.OK);
            case "orderList":
            	return new ResponseEntity<List<CustomerOrdersVO>>(cos.getAll(), HttpStatus.OK);
        }
        return null;
    }
	private int getIncomeCount() {
		// AdminService as = new AdminService(session);
		return 1;
	}
}
