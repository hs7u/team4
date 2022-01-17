package ProjectInterfaces;

import java.util.ArrayList;

public interface Ref_ProductTagInterface<Ref_ProductTagVO> {
    public void insert(Ref_ProductTagVO rVo);
    public void update(Ref_ProductTagVO rVo);
    public ArrayList<Integer> selectByProductId(Integer product_id);
}
