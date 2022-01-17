package ProjectInterfaces;

public interface ProductInterface<ProductVO> {
    public void insert(ProductVO pVo);
    public void update(ProductVO pVo);
    public void delete(Integer productId);
    public void sold(Integer productId, Integer sold);
    public void changeStatus(Integer productId, Byte status_code);
    public ProductVO selectByProductName(String product_name);
}
