package web.RefShippingCategories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.RefShippingCategoriesInterface;
import web.RefShippingCategories.vo.RefShippingCategoriesVO;

@Service
@Transactional
public class RefShippingCategoriesService {
	@Autowired
	private RefShippingCategoriesInterface<RefShippingCategoriesVO> dao;
	// private RefShippingCategoriesDAO dao;
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
