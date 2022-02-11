package web.Product.service;

import java.util.ArrayList;

import org.hibernate.Session;

import ProjectInterfaces.ProductInterface;
import web.Product.dao.ProductDAO;
import web.Product.vo.ProductVO;

public class ProductService {
    private ProductInterface<ProductVO> dao;
    public ProductService(Session session){
        dao = new ProductDAO(session);
    }
    public ProductVO addProduct(Integer productCategoryCode, Integer productPrice, String productName,byte[] productImage,
            String productDescription, Integer productInventory, Byte customization, Integer customerProductPrice){
        java.sql.Timestamp releasedTime = new java.sql.Timestamp(System.currentTimeMillis());
        ProductVO pVo = new ProductVO();
        pVo.setProductId(hashCode(productName, productDescription));
        pVo.setProductCategoryCode(productCategoryCode);
        pVo.setProductPrice(productPrice);
        pVo.setProductName(productName);
        pVo.setProductImage(productImage);
        pVo.setProductDescription(productDescription);
        pVo.setProductInventory(productInventory);
        pVo.setReleasedTime(releasedTime);
        pVo.setCustomization(customization);
        pVo.setCustomerProductPrice(customerProductPrice);
        dao.insert(pVo);    
        return pVo;
    }
    public ProductVO updateProduct(Integer ProductId, Integer productCategoryCode, Integer productPrice, String productName,byte[] productImage,
            String productDescription, Integer productInventory, Byte customization, Integer customerProductPrice, Byte productStatus) {
        ProductVO pVo = new ProductVO();
        pVo.setProductId(ProductId);
        pVo.setProductCategoryCode(productCategoryCode);
        pVo.setProductPrice(productPrice);
        pVo.setProductName(productName);
        pVo.setProductImage(productImage);
        pVo.setProductDescription(productDescription);
        pVo.setProductInventory(productInventory);
        pVo.setCustomization(customization);
        pVo.setCustomerProductPrice(customerProductPrice);
        pVo.setProductStatus(productStatus);
        dao.update(pVo);
        return pVo;    
    }
    public void updateSold(Integer productId, Integer sold) {
        dao.sold(productId, sold);
    }
    public void updateStatus(Integer productId, Byte statusCode) {
        dao.changeStatus(productId, statusCode);
    }
    public ProductVO getOneProduct(Integer productId){
        return dao.selectByProductId(productId);
    }
    public ArrayList<ProductVO> getAll() {
        return dao.getAllProduct();
    }
    public void deleteProduct(Integer productId){
        dao.delete(productId);
    }
    public byte[] getImage(Integer productId) {
        return dao.selectPhotoByProductId(productId);
    }
    public int hashCode(String productName, String productDescription) {
        final int prime = 31;
		int result = 1;
		result = result * prime + (productName == null ? 0 : (productName).hashCode()); 
		result = result * prime + (productDescription == null ? 0 : (productDescription).hashCode()); 
		
		return result;
    }
}
