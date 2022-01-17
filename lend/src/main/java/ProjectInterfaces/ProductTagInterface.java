package ProjectInterfaces;

public interface ProductTagInterface<ProductTagVO> {
    public void insert(ProductTagVO pVo);
    public void update(ProductTagVO pVo);
    public ProductTagVO selectOneTag(Integer productCategoryCode);
}
