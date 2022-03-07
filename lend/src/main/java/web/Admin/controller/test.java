package web.Admin.controller;

import static web.CommonUtil.projectUtil.writePojo2Json;

import javax.servlet.http.HttpServletResponse;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// import web.Product.service.ProductService;
import web.Product.vo.ProductVO;

@RestController
public class test {
    // @Autowired
    // private ProductService ps;

    @RequestMapping(path = {"/Product/mvc"}, method = RequestMethod.POST)
    public ProductVO jsonTest(@RequestBody(required = false) ProductVO vo,HttpServletResponse res) {
    	System.out.println(vo); 
    	return vo;
    }
}
