package ProjectInterfaces;

import java.util.ArrayList;

public interface FavoriteInterface<FavoriteVO> {
    public void insert(FavoriteVO fVo);
    public void delete(Integer customer_id, Integer product_id);
    public ArrayList<Integer> selectByCustomerId(Integer customer_id);
}
