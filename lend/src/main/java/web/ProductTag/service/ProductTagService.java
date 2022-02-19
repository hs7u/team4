package web.ProductTag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.ProductTagInterface;
import web.ProductTag.vo.ProductTagVO;

@Service
@Transactional
public class ProductTagService {
    @Autowired
    private ProductTagInterface<ProductTagVO> dao;
    // private ProductTagDAO dao;
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
