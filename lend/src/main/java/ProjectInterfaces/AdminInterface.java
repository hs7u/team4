package ProjectInterfaces;

import java.util.ArrayList;

public interface AdminInterface<AdminVO> {
    public void insert(AdminVO aVo);
    public void update(AdminVO aVo);
    public void delete(Integer adminId);
    public ArrayList<AdminVO> allManager();
}
