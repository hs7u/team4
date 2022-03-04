package ProjectInterfaces;

import java.io.Serializable;
import java.util.ArrayList;

public interface AdminInterface<AdminVO> {
    public Serializable insert(AdminVO aVo);
    public void update(AdminVO aVo);
    public void delete(Integer adminId);
    public AdminVO getOneManager(String adminAccount, String adminPassword);
    public ArrayList<AdminVO> allManager();
}
