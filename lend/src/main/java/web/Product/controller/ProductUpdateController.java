package web.Product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import web.CustomerOrders.service.CustomerOrdersService;
import web.OrderDetail.service.OrderService;
import web.Product.service.ProductService;
import web.Product.vo.ProductVO;

@RestController
public class ProductUpdateController {
    @Autowired
    private ProductService ps;
    @Autowired
    private OrderService os;
    @Autowired
    private CustomerOrdersService cos;
    @PostMapping(path = {"/Product/updateProduct"})
    public String updateProduct(@RequestBody(required = false) ProductVO vo, HttpServletRequest request){
        ProductVO check = ps.getOneProduct(vo.getProductId());
        if(ps.updateProduct(vo, check)){
            request.removeAttribute("currentProduct");
            return "success";
        }
        return "fail";
    }
    @GetMapping(path = {"/Product/updateProduct"})
    public void transform(HttpServletRequest request, HttpServletResponse response, Integer productId) throws ServletException, IOException {
        request.setAttribute("currentProduct", ps.getOneProduct(productId));
        String url = "/Product/update_product_input_test.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
    @GetMapping(path = {"/Product/updateProduct/{param1}"})
    public void delete(@PathVariable("param1") Integer productId, HttpServletResponse response) throws IOException {
        os.deleteWithProduct(productId);
        cos.deleteOrderByProductId(productId);
        ps.deleteProduct(productId);
        response.sendRedirect("/lend/Product/listAllProduct_test.jsp");
    }
}
