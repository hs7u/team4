package web.Admin.dao;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import ProjectInterfaces.AdminInterface;
import web.Admin.vo.AdminVO;

public class AdminDAO implements AdminInterface<AdminVO>{
    private Session s;
    public AdminDAO(Session s){
        this.s = s;
    }
    @Override
    public void insert(AdminVO aVo) {
        // Hibernate
        if(aVo != null){
            AdminVO check = this.s.get(AdminVO.class, aVo.getAdminId());
            if(check == null){
                this.s.save(aVo);
            }
        }
    }
    @Override
    public void update(AdminVO aVo) {
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaUpdate<AdminVO> cu = cb.createCriteriaUpdate(AdminVO.class);
        Root<AdminVO> root = cu.from(AdminVO.class);
        cu = cu.set(root.get("admin_account"), aVo.getAdminAccount())
               .set(root.get("admin_password"), aVo.getAdminPassword())
               .set(root.get("permission"), aVo.getPermission())
               .where(cb.equal(root.get("admin_id"), aVo.getAdminId()));
        this.s.createQuery(cu).getSingleResult();
        // Hibernate
        /* if(aVo != null){
            AdminVO check = this.s.get(AdminVO.class, aVo.getAdminId());
            if(check != null){
                check.setAdminAccount(aVo.getAdminAccount());
                check.setAdminPassword(aVo.getAdminPassword());
                check.setPermission(aVo.getPermission());
                this.s.save(aVo);
            }
        } */
    }
    @Override
    public void delete(Integer adminId) {
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaDelete<AdminVO> cd = cb.createCriteriaDelete(AdminVO.class);
        Root<AdminVO> root = cd.from(AdminVO.class);
        cd = cd.where(cb.equal(root.get("admin_id"), adminId));
        this.s.createQuery(cd).executeUpdate();
        // Hibernate
        /* if(adminId != null){
            AdminVO check = this.s.get(AdminVO.class, adminId);
            if(check != null){
                this.s.delete(check);
            }
        } */
    }
    @Override
    public ArrayList<AdminVO> allManager() {
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<AdminVO> cq = cb.createQuery(AdminVO.class);
        Root<AdminVO> root = cq.from(AdminVO.class);
        cq = cq.where(cb.isNotNull(root.get("admin_id")));
        ArrayList<AdminVO> list = new ArrayList<AdminVO>();
        for(AdminVO result : this.s.createQuery(cq).getResultList()){
            list.add(result);
        }
        return list;
    }
}

