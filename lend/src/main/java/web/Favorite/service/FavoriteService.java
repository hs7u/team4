package web.Favorite.service;

import java.util.ArrayList;

import ProjectInterfaces.FavoriteInterface;
import web.Favorite.dao.FavoriteDAO;
import web.Favorite.vo.FavoriteVO;

public class FavoriteService {
    private FavoriteInterface<FavoriteVO> dao;
    public FavoriteService(){
        dao = new FavoriteDAO();
    }
    public FavoriteVO addFavorite(Integer customer_id, Integer product_id){
        FavoriteVO fVo = new FavoriteVO();
        fVo.setCustomer_id(customer_id);
        fVo.setProduct_id(product_id);
        dao.insert(fVo);
        return fVo;
    }
    public FavoriteVO deleFavorite(Integer customer_id, Integer product_id){
        FavoriteVO fVo = new FavoriteVO();
        fVo.setCustomer_id(customer_id);
        fVo.setProduct_id(product_id);
        dao.delete(customer_id, product_id);
        return fVo;
    }
    public ArrayList<Integer> selectByCustomerId(Integer customer_id){
        return dao.selectByCustomerId(customer_id);
    }
}
