package web.Favorite.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.FavoriteInterface;
import web.Favorite.vo.FavoriteVO;

@Service
@Transactional
public class FavoriteService {
    @Autowired
    private FavoriteInterface<FavoriteVO> dao;
    // private FavoriteDAO dao;
    // public FavoriteService(Session session){
    //     dao = new FavoriteDAO(session);
    // }
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
