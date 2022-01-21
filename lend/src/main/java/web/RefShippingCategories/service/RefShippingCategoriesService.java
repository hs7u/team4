package web.RefShippingCategories.service;

import ProjectInterfaces.RefShippingCategoriesInterface;
import web.RefShippingCategories.dao.RefShippingCategoriesDAO;
import web.RefShippingCategories.vo.RefShippingCategoriesVO;

public class RefShippingCategoriesService {
	private RefShippingCategoriesInterface<RefShippingCategoriesVO> dao;
	public RefShippingCategoriesService() {
		dao = new RefShippingCategoriesDAO();
	}
	 public RefShippingCategoriesVO addRefShippingCategories(Integer shippingMethodCode, String shippingCategoryDescription) {
		 RefShippingCategoriesVO rvo = new RefShippingCategoriesVO();
	        rvo.setShippingMethodCode(shippingMethodCode);
	        rvo.setShippingCategoryDescription(shippingCategoryDescription);
	        dao.insert(rvo);
	        return rvo;
	    }
	    public RefShippingCategoriesVO updateRefShippingCategories(Integer shippingMethodCode, String shippingCategoryDescription){
	    	RefShippingCategoriesVO rvo = new RefShippingCategoriesVO();
	    	rvo.setShippingMethodCode(shippingMethodCode);
	        rvo.setShippingCategoryDescription(shippingCategoryDescription);
	        dao.insert(rvo);
	        return rvo;
	    }
	    public RefShippingCategoriesVO selectByshippingMethodCode(Integer shippingMethodCode) {
	        return dao.selectByShippingMethodCode(shippingMethodCode);
	    }
}
