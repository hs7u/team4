package web.Ref_ProductTag.service;

import java.util.ArrayList;

import ProjectInterfaces.Ref_ProductTagInterface;
import web.Ref_ProductTag.dao.Ref_ProductTagDAO;
import web.Ref_ProductTag.vo.Ref_ProductTagVO;

public class Ref_ProductTagService {
    private Ref_ProductTagInterface<Ref_ProductTagVO> dao;
    public Ref_ProductTagService(){
        dao = new Ref_ProductTagDAO();
    }
    public Ref_ProductTagVO addTagRef(Integer product_category_code, Integer product_id){
        Ref_ProductTagVO rVo = new Ref_ProductTagVO();
        rVo.setProduct_category_code(product_category_code);
        rVo.setProduct_id(product_id);
        dao.insert(rVo);
        return rVo;
    }
    public Ref_ProductTagVO updateTagRef(Integer serial_number, Integer product_category_code, Integer product_id){
        Ref_ProductTagVO rVo = new Ref_ProductTagVO();
        rVo.setSerial_number(serial_number);
        rVo.setProduct_category_code(product_category_code);
        rVo.setProduct_id(product_id);
        dao.update(rVo);
        return rVo;
    }
    public ArrayList<Integer> selectByProductId(Integer product_id){
           return dao.selectByProductId(product_id);
    }
}
