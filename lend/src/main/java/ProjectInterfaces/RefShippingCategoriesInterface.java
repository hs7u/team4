package ProjectInterfaces;

public interface RefShippingCategoriesInterface<RefShippingCategoriesVO> {
	public void insert(RefShippingCategoriesVO rVO);
	public void update(RefShippingCategoriesVO rVO);
	public RefShippingCategoriesVO selectByShippingMethodCode(Integer shippingMethodCode);
}
