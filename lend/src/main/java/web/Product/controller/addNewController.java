package web.Product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import web.Product.service.ProductService;
import web.Product.vo.ProductVO;

@RestController
public class addNewController {
    @Autowired
    private ProductService ps;
    @RequestMapping(path = {"/Product/addNewProduct"}, method = RequestMethod.POST)
    public String insert(@RequestBody(required = false) ProductVO vo) {
        
        
        return "";
    }
}
