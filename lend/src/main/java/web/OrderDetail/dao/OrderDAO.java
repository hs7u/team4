package web.OrderDetail.dao;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ProjectInterfaces.OrderInteface;
import web.OrderDetail.vo.OrderDetailVO;

@Repository
public class OrderDAO implements OrderInteface<OrderDetailVO>{
    @PersistenceContext
    private Session session;
    public void insert(OrderDetailVO vo){
        this.session.save(vo);
    }
    public void update(OrderDetailVO vo){
        CriteriaBuilder cb = this.session.getCriteriaBuilder();
        CriteriaUpdate<OrderDetailVO> cu = cb.createCriteriaUpdate(OrderDetailVO.class);
        Root<OrderDetailVO> root = cu.from(OrderDetailVO.class);
        cu = cu.set(root.get("productId"), vo.getProductId())
               .set(root.get("productPrice"), vo.getProductPrice())
               .set(root.get("productQuantity"), vo.getProductQuantity())
               .where(cb.equal(root.get("orderDetailsId"), vo.getOrderDetailsId()));
        this.session.createQuery(cu).executeUpdate();
    }
    public void delete(Integer orderDetailsId){
        CriteriaBuilder cb = this.session.getCriteriaBuilder();
        CriteriaDelete<OrderDetailVO> cd = cb.createCriteriaDelete(OrderDetailVO.class);
        Root<OrderDetailVO> root = cd.from(OrderDetailVO.class);
        cd = cd.where(cb.equal(root.get("orderDetailsId"), orderDetailsId));
        this.session.createQuery(cd).executeUpdate();
    }
    public OrderDetailVO getOneDetail(Integer orderDetailsId){
        CriteriaBuilder cb = this.session.getCriteriaBuilder();
        CriteriaQuery<OrderDetailVO> cq = cb.createQuery(OrderDetailVO.class);
        Root<OrderDetailVO> root = cq.from(OrderDetailVO.class);
        cq = cq.where(cb.equal(root.get("orderDetailsId"), orderDetailsId));
        return this.session.createQuery(cq).getSingleResult();
    }
    public List<OrderDetailVO> getAllDetail(Integer orderId){
        CriteriaBuilder cb = this.session.getCriteriaBuilder();
        CriteriaQuery<OrderDetailVO> cq = cb.createQuery(OrderDetailVO.class);
        Root<OrderDetailVO> root = cq.from(OrderDetailVO.class);
        cq = cq.where(cb.equal(root.get("orderId"), orderId));
        return this.session.createQuery(cq).getResultList();
    }
}
