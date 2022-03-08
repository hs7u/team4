package ProjectInterfaces;

import java.io.Serializable;
import java.util.ArrayList;

public interface ProductInterface<ProductVO> {
	public Serializable insert(ProductVO pVo);

	public Boolean update(ProductVO pVo);

	public void delete(Integer productId);

	public void sold(Integer productId, Integer sold);

	public void changeStatus(Integer productId, Byte statusCode);

	public ProductVO selectByProductId(Integer productId);

	public byte[] selectPhotoByProductId(Integer productId);

	public ArrayList<ProductVO> getAllProduct();

	public ArrayList<ProductVO> selectProductByCategory(Integer productCategoryCode, String orderByCondition);
}
