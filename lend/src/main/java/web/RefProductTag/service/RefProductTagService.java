package web.RefProductTag.service;

import java.util.ArrayList;

import ProjectInterfaces.RefProductTagInterface;
import web.RefProductTag.dao.RefProductTagDAO;
import web.RefProductTag.vo.RefProductTagVO;

public class RefProductTagService {
    private RefProductTagInterface<RefProductTagVO> dao;
    public RefProductTagService(){
        dao = new RefProductTagDAO();
    }
    public RefProductTagVO addTagRef(Integer productCategoryCode, Integer productId){
        RefProductTagVO rVo = new RefProductTagVO();
        rVo.setProductCategoryCode(productCategoryCode);
        rVo.setProductId(productId);
        dao.insert(rVo);
        return rVo;
    }
    public RefProductTagVO updateTagRef(Integer serialNumber, Integer productCategoryCode, Integer productId){
        RefProductTagVO rVo = new RefProductTagVO();
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
