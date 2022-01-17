package ProjectInterfaces;

import java.util.ArrayList;

public interface FavoriteInterface<FavoriteVO> {
    public void insert(FavoriteVO fVo);
    public void delete(Integer customerId, Integer productId);
    public ArrayList<Integer> selectByCustomerId(Integer customerId);
}
