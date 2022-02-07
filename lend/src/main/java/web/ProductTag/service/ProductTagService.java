package web.ProductTag.service;

import ProjectInterfaces.ProductTagInterface;
import web.ProductTag.dao.ProductTagDAO;
import web.ProductTag.vo.ProductTagVO;

public class ProductTagService {
    private ProductTagInterface<ProductTagVO> dao;
    public ProductTagService(){
        dao = new ProductTagDAO();
    }
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
