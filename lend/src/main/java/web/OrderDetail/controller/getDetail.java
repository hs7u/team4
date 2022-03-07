package web.OrderDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.OrderDetail.service.OrderService;
import web.OrderDetail.vo.OrderDetailVO;

@RestController
public class getDetail  {
    @Autowired
	private OrderService osc;
    @RequestMapping(path = {"/Customer/orderDetail/{param}"}, method = RequestMethod.GET)
	protected ResponseEntity<?> allDetail(@PathVariable("param") Integer orderId){
		return new ResponseEntity<List<OrderDetailVO> >(osc.getAllDetail(orderId), HttpStatus.OK);
	}
}
