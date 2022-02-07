package web.Admin.service;

import java.util.ArrayList;

import org.hibernate.Session;

import ProjectInterfaces.AdminInterface;
import web.Admin.dao.AdminDAO;
import web.Admin.vo.AdminVO;

public class AdminService {
    private AdminInterface<AdminVO> dao;
    public AdminService(Session session){
        dao = new AdminDAO(session);
    }
    public void newManager(String adminAccount, String adminPassword, String permission){
        AdminVO aVo = new AdminVO();
        aVo.setAdminAccount(adminAccount);
        aVo.setAdminPassword(adminPassword);
        aVo.setPermission(permission);
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
    public ArrayList<AdminVO> allManager(){
        return dao.allManager();
    }
}
