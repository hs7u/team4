package ProjectInterfaces;

public interface ProductInterface<ProductVO> {
    public void insert(ProductVO pVo);
    public void update(ProductVO pVo);
    public void delete(Integer product_id);
    public void sold(Integer product_id, Integer sold);
    public void changeStatus(Integer product_id, Byte status_code);
    public ProductVO selectByProductName(String product_name);
}
