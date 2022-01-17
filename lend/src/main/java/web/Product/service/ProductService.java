package web.Product.service;

import ProjectInterfaces.ProductInterface;
import web.Product.dao.ProductDAO;
import web.Product.vo.ProductVO;

public class ProductService {
    private ProductInterface<ProductVO> dao;
    public ProductService(){
        dao = new ProductDAO();
    }
    public ProductVO addProduct(Integer product_category_code, Integer product_price, String product_name,byte[] product_image,
            String product_description, Integer product_inventory, Byte customization, Integer customer_product_price){
            java.sql.Timestamp released_time = new java.sql.Timestamp(System.currentTimeMillis());
            ProductVO pVo = new ProductVO();
        pVo.setProduct_id(hashCode(product_name, product_description));
        pVo.setProduct_category_code(product_category_code);
        pVo.setProduct_price(product_price);
        pVo.setProduct_name(product_name);
        pVo.setProduct_image(product_image);
        pVo.setProduct_description(product_description);
        pVo.setProduct_inventory(product_inventory);
        pVo.setReleased_time(released_time);
        pVo.setCustomization(customization);
        pVo.setCustomer_product_price(customer_product_price);
        dao.insert(pVo);    
        return pVo;
    }
    public ProductVO updateProduct(Integer Product_id, Integer product_category_code, Integer product_price, String product_name,byte[] product_image,
            String product_description, Integer product_inventory, Byte customization, Integer customer_product_price) {
        ProductVO pVo = new ProductVO();
        pVo.setProduct_id(Product_id);
        pVo.setProduct_category_code(product_category_code);
        pVo.setProduct_price(product_price);
        pVo.setProduct_name(product_name);
        pVo.setProduct_image(product_image);
        pVo.setProduct_description(product_description);
        pVo.setProduct_inventory(product_inventory);
        pVo.setCustomization(customization);
        pVo.setCustomer_product_price(customer_product_price);
        dao.update(pVo);
        return pVo;    
    }
    public void updateSold(Integer product_id, Integer sold) {
        dao.sold(product_id, sold);
    }
    public void updateStatus(Integer product_id, Byte status_code) {
        dao.changeStatus(product_id, status_code);
    }
    public int hashCode(String product_name, String product_description) {
        final int prime = 31;
		int result = 1;
		result = result * prime + (product_name == null ? 0 : (product_name).hashCode()); 
		result = result * prime + (product_description == null ? 0 : (product_description).hashCode()); 
		
		return result;
    }
}
