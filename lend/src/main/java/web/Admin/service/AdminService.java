package web.Admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ProjectInterfaces.AdminInterface;
import web.Admin.vo.AdminVO;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminInterface<AdminVO> dao;
    // private AdminDAO dao;
    // public AdminService(Session session){
    //     dao = new AdminDAO(session);
    // }
    public void newManager(AdminVO aVo){
        dao.insert(aVo);
    }
    public void updateManager(Integer adminId, String adminAccount, String adminPassword, String permission){
        AdminVO aVo = new AdminVO();
        aVo.setAdminId(adminId);
        aVo.setAdminAccount(adminAccount);
        aVo.setAdminPassword(adminPassword);
        aVo.setPermission(permission);
        dao.update(aVo);
    }
    public void deleteManager(Integer adminId){
        dao.delete(adminId);
    }
    public AdminVO getOneManager(AdminVO vo) {
        return dao.getOneManager(vo.getAdminAccount(), vo.getAdminPassword());
    }
    public ArrayList<AdminVO> allManager(){
        return dao.allManager();
    }
}
