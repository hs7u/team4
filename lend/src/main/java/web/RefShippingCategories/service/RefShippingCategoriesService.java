package web.RefShippingCategories.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjectInterfaces.RefShippingCategoriesInterface;
import web.RefShippingCategories.dao.RefShippingCategoriesDAO;
import web.RefShippingCategories.vo.RefShippingCategoriesVO;

@Service
public class RefShippingCategoriesService {
	@Autowired
	private RefShippingCategoriesDAO dao;
	// private RefShippingCategoriesInterface<RefShippingCategoriesVO> dao;
	// public RefShippingCategoriesService(Session session) {
	// 	dao = new RefShippingCategoriesDAO(session);
	// }
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
