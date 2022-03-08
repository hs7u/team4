package web.Product.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.ProductInterface;
import web.Product.vo.ProductVO;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductInterface<ProductVO> dao;

	// private ProductDAO dao;
	// public ProductService(Session session){
	// dao = new ProductDAO(session);
	// }
	public String addProduct(ProductVO pVo) {
		java.sql.Timestamp releasedTime = new java.sql.Timestamp(System.currentTimeMillis());
		StringBuilder errorMsg = new StringBuilder();
		if (pVo.getProductPrice() == null) {
			errorMsg.append("商品價格: 請勿空白" + System.lineSeparator());
		}
		if (pVo.getProductName().trim().isEmpty()) {
			errorMsg.append("商品名稱: 請勿空白" + System.lineSeparator());
		}
		if (pVo.getProductImage() == null) {
			errorMsg.append("請上傳商品圖片" + System.lineSeparator());
		}
		if (pVo.getProductDescription().trim().isEmpty()) {
			errorMsg.append("商品描述: 請勿空白" + System.lineSeparator());
		}
		if (pVo.getProductInventory() == null) {
			errorMsg.append("商品庫存: 請勿空白" + System.lineSeparator());
		}
		if (pVo.getCustomerProductPrice() == null) {
			errorMsg.append("客制價格: 請勿空白" + System.lineSeparator());
		}
		if (errorMsg.length() > 0) {
			return errorMsg.toString();
		}
		pVo.setReleasedTime(releasedTime);
		Integer id = (Integer) dao.insert(pVo);
		if (id != null) {
			return "success";
		}
		return "fail";
	}

	public Boolean updateProduct(ProductVO vo, ProductVO check) {
		if (check != null) {
			if (vo.getProductName().trim().isEmpty())
				vo.setProductName(check.getProductName());
			if (vo.getProductPrice() == null)
				vo.setProductPrice(check.getProductPrice());
			if (vo.getProductImage() == null)
				vo.setProductImage(check.getProductImage());
			if (vo.getProductDescription().trim().isEmpty())
				vo.setProductDescription(check.getProductDescription());
			if (vo.getProductInventory() == null)
				vo.setProductInventory(check.getProductInventory());
			if (vo.getCustomerProductPrice() == null)
				vo.setCustomerProductPrice(check.getCustomerProductPrice());
			return dao.update(vo);
		}
		return false;
	}

	public void updateSold(Integer productId, Integer sold) {
		dao.sold(productId, sold);
	}

	public void updateStatus(Integer productId, Byte statusCode) {
		dao.changeStatus(productId, statusCode);
	}

	public ProductVO getOneProduct(Integer productId) {
		return dao.selectByProductId(productId);
	}

	public ArrayList<ProductVO> getAll() {
		return dao.getAllProduct();
	}

	public ArrayList<ProductVO> selectProductByCategory(Integer productCategoryCode, String orderByCondition) {
		return dao.selectProductByCategory(productCategoryCode, orderByCondition);
	}

	public void deleteProduct(Integer productId) {
		dao.delete(productId);
	}

	public byte[] getImage(Integer productId) {
		return dao.selectPhotoByProductId(productId);
	}
}
