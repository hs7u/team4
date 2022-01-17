package ProjectInterfaces;

import java.util.ArrayList;

public interface RefProductTagInterface<RefProductTagVO> {
    public void insert(RefProductTagVO rVo);
    public void update(RefProductTagVO rVo);
    public ArrayList<Integer> selectByProductId(Integer productId);
}
