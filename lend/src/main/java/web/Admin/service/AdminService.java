package web.Admin.service;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjectInterfaces.AdminInterface;
import web.Admin.dao.AdminDAO;
import web.Admin.vo.AdminVO;

@Service
public class AdminService {
    @Autowired
    private AdminDAO dao;
    // private AdminInterface<AdminVO> dao;
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
    public AdminVO getOneManager(String adminAccount, String adminPassword) {
        return dao.getOneManager(adminAccount, adminPassword);
    }
    public ArrayList<AdminVO> allManager(){
        return dao.allManager();
    }
}
