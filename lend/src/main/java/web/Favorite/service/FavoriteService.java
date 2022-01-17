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
    public FavoriteVO addFavorite(Integer customerId, Integer productId){
        FavoriteVO fVo = new FavoriteVO();
        fVo.setCustomerId(customerId);
        fVo.setProductId(productId);
        dao.insert(fVo);
        return fVo;
    }
    public FavoriteVO deleFavorite(Integer customerId, Integer productId){
        FavoriteVO fVo = new FavoriteVO();
        fVo.setCustomerId(customerId);
        fVo.setProductId(productId);
        dao.delete(customerId, productId);
        return fVo;
    }
    public ArrayList<Integer> selectByCustomerId(Integer customerId){
        return dao.selectByCustomerId(customerId);
    }
}
