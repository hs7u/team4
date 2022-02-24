package web.Admin.controller;

import static web.CommonUtil.StaticUtil.GSON;

import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Admin.vo.AdminVO;
import web.Course.service.CourseService;
import web.Customer.service.CustomerService;
import web.CustomerOrders.service.CustomerOrdersService;

@RestController
public class BoardController {
    @Autowired
    private CustomerService cs;
    @Autowired
    private CourseService csc;
    @Autowired
    private CustomerOrdersService cos;
    @RequestMapping(path = {"/Admin/dashBoard"}, method = RequestMethod.POST)
    public String dashBoardInfo(@RequestBody String action, HttpSession session) {
        JsonObject jsonObject = GSON.fromJson(action, JsonObject.class);
        switch (jsonObject.get("action").getAsString()) {
            case "customer":
                return GSON.toJson(cs.countCustomer());
            case "course":
                return GSON.toJson(csc.countCourse());
            case "order":
                return GSON.toJson(cos.countOrder());
            case "income":
                return GSON.toJson(getIncomeCount());
            case "accountInfo":
                return GSON.toJson((AdminVO)session.getAttribute("info"));
            case "customerList":
                return GSON.toJson(cs.getAllCustomer());
            case "courseList":
                return GSON.toJson(csc.getALL());
        }
        return null;
    }
	private int getIncomeCount() {
		// AdminService as = new AdminService(session);
		return 1;
	}
}
