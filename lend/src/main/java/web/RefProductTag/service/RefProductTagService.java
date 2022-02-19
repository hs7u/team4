package web.RefProductTag.service;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.RefProductTagInterface;
import web.RefProductTag.dao.RefProductTagDAO;
import web.RefProductTag.vo.RefProductTagVO;

@Service
@Transactional
public class RefProductTagService {
    @Autowired
    private RefProductTagDAO dao;
    // private RefProductTagInterface<RefProductTagVO> dao;
    // public RefProductTagService(Session session){
    //     dao = new RefProductTagDAO(session);
    // }
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
