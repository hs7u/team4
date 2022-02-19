package web.ProductTag.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ProjectInterfaces.ProductTagInterface;
import web.ProductTag.dao.ProductTagDAO;
import web.ProductTag.vo.ProductTagVO;

@Repository
public class ProductTagService {
    @Autowired
    private ProductTagDAO dao;
    // private ProductTagInterface<ProductTagVO> dao;
    // public ProductTagService(Session session){
    //     dao = new ProductTagDAO(session);
    // }
    public ProductTagVO addTag(Integer productCategoryCode, String productTagName){
        ProductTagVO pVo = new ProductTagVO();
        pVo.setProductCategoryCode(productCategoryCode);
        pVo.setProductTagName(productTagName);
        dao.insert(pVo);
        return pVo;
    }
    public ProductTagVO updateTag(Integer productCategoryCode, String productTagName){
        ProductTagVO pVo = new ProductTagVO();
        pVo.setProductCategoryCode(productCategoryCode);
        pVo.setProductTagName(productTagName);
        dao.update(pVo);
        return pVo;
    }
    public ProductTagVO selectByCode(Integer productCategoryCode){
        return dao.selectOneTag(productCategoryCode);
    }
}
