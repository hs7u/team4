package ProjectInterfaces;

import java.util.ArrayList;

public interface ProductInterface<ProductVO> {
    public void insert(ProductVO pVo);
    public void update(ProductVO pVo);
    public void delete(Integer productId);
    public void sold(Integer productId, Integer sold);
    public void changeStatus(Integer productId, Byte statusCode);
    public ProductVO selectByProductId(Integer productId);
    public byte[] selectPhotoByProductId(Integer productId);
    public ArrayList<ProductVO> getAllProduct();
}
