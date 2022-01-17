package web.ProductTag.service;

import ProjectInterfaces.ProductTagInterface;
import web.ProductTag.dao.ProductTagDAO;
import web.ProductTag.vo.ProductTagVO;

public class ProductTagService {
    private ProductTagInterface<ProductTagVO> dao;
    public ProductTagService(){
        dao = new ProductTagDAO();
    }
    public ProductTagVO addTag(Integer product_category_code, String product_label_name){
        ProductTagVO pVo = new ProductTagVO();
        pVo.setProduct_category_code(product_category_code);
        pVo.setProduct_label_name(product_label_name);
        dao.insert(pVo);
        return pVo;
    }
    public ProductTagVO updateTag(Integer product_category_code, String product_label_name){
        ProductTagVO pVo = new ProductTagVO();
        pVo.setProduct_category_code(product_category_code);
        pVo.setProduct_label_name(product_label_name);
        dao.update(pVo);
        return pVo;
    }
    public ProductTagVO selectByCode(Integer product_category_code){
        return dao.selectOneTag(product_category_code);
    }
}
