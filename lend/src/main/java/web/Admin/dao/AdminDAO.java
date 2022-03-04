package web.Admin.dao;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ProjectInterfaces.AdminInterface;
import web.Admin.vo.AdminVO;

@Repository
public class AdminDAO implements AdminInterface<AdminVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    // public AdminDAO(Session s){
    //     getSession() = s;
    // }
    public Session getSession() {
		// return sf.getCurrentSession();
        return s;
	} 
    @Override
    public Serializable insert(AdminVO aVo) {
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AdminVO> root = cq.from(AdminVO.class);
        cq = cq.select(cb.count(root)).where(cb.equal(root.get("adminAccount"), aVo.getAdminAccount()));
        long result = getSession().createQuery(cq).getSingleResult();
        if(result == 0){
            return getSession().save(aVo);
        }
        return null;
        // Hibernate
        // return getSession().save(aVo);
    }
    @Override
    public void update(AdminVO aVo) {
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<AdminVO> cu = cb.createCriteriaUpdate(AdminVO.class);
        Root<AdminVO> root = cu.from(AdminVO.class);
        cu = cu.set(root.get("adminAccount"), aVo.getAdminAccount())
               .set(root.get("adminPassword"), aVo.getAdminPassword())
               .set(root.get("permission"), aVo.getPermission())
               .where(cb.equal(root.get("adminId"), aVo.getAdminId()));
        getSession().createQuery(cu).getSingleResult();
        // Hibernate
        /* if(aVo != null){
            AdminVO check = getSession().get(AdminVO.class, aVo.getAdminId());
            if(check != null){
                check.setAdminAccount(aVo.getAdminAccount());
                check.setAdminPassword(aVo.getAdminPassword());
                check.setPermission(aVo.getPermission());
                getSession().save(aVo);
            }
        } */
    }
    @Override
    public void delete(Integer adminId) {
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaDelete<AdminVO> cd = cb.createCriteriaDelete(AdminVO.class);
        Root<AdminVO> root = cd.from(AdminVO.class);
        cd = cd.where(cb.equal(root.get("adminId"), adminId));
        getSession().createQuery(cd).executeUpdate();
        // Hibernate
        /* if(adminId != null){
            AdminVO check = getSession().get(AdminVO.class, adminId);
            if(check != null){
                getSession().delete(check);
            }
        } */
    }
    public AdminVO getOneManager(String adminAccount, String adminPassword) {
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<AdminVO> cq = cb.createQuery(AdminVO.class);
        Root<AdminVO> root = cq.from(AdminVO.class);
        cq = cq.select(root).where(cb.and(cb.equal(root.get("adminAccount"), adminAccount),
                                          cb.equal(root.get("adminPassword"), adminPassword)
                                        )
                                    );
        try {
            return getSession().createQuery(cq).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<AdminVO> allManager() {
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<AdminVO> cq = cb.createQuery(AdminVO.class);
        Root<AdminVO> root = cq.from(AdminVO.class);
        cq = cq.where(cb.isNotNull(root.get("adminId")));
        ArrayList<AdminVO> list = new ArrayList<AdminVO>();
        for(AdminVO result : getSession().createQuery(cq).getResultList()){
            list.add(result);
        }
        return list;
    }
}

