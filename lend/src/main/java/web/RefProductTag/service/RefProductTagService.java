package web.RefProductTag.service;

import java.util.ArrayList;

import ProjectInterfaces.Ref_ProductTagInterface;
import web.Ref_ProductTag.dao.Ref_ProductTagDAO;
import web.Ref_ProductTag.vo.Ref_ProductTagVO;

public class RefProductTagService {
    private RefProductTagInterface<Ref_ProductTagVO> dao;
    public RefProductTagService(){
        dao = new Ref_ProductTagDAO();
    }
    public Ref_ProductTagVO addTagRef(Integer productCategoryCode, Integer productId){
        Ref_ProductTagVO rVo = new Ref_ProductTagVO();
        rVo.setProductCategoryCode(productCategoryCode);
        rVo.setProductId(productId);
        dao.insert(rVo);
        return rVo;
    }
    public Ref_ProductTagVO updateTagRef(Integer serialNumber, Integer productCategoryCode, Integer productId){
        Ref_ProductTagVO rVo = new Ref_ProductTagVO();
        rVo.setSerialNumber(serialNumber);
        rVo.setProductCategoryCode(productCategoryCode);
        rVo.setProductId(productId);
        dao.update(rVo);
        return rVo;
    }
    public ArrayList<Integer> selectByProductId(Integer productId){
           return dao.selectByProductId(productId);
    }
}
