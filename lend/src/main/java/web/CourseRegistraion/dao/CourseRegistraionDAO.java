package web.CourseRegistraion.dao;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; */
import java.util.ArrayList;

/* import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException; */
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
// import javax.sql.DataSource;

import org.hibernate.Session;

import ProjectInterfaces.CourseRegistraionInterface;
import web.CourseRegistraion.vo.CourseRegistraionVO;

public class CourseRegistraionDAO implements CourseRegistraionInterface<CourseRegistraionVO> {
    private Session s;
    public CourseRegistraionDAO(Session s){
        this.s = s;
    }
    /* private static final String INSERT = "INSERT INTO `TEAM4`.`Course_Registraion`"
    +"(`registration_id`,`customer_id`,`course_id`,`course_timeble_id`,`numOfPeople`)"
    +"VALUES"
    +"(?,?,?,?,?);";
    // private static final String UPDATE = "";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Course_Registraion` WHERE `registration_id` = ?;";
    private static final String GET_ONE_STM = "SELECT * FROM TEAM4.Course_Registraion WHERE `customer_id` = ? AND `course_timeble_id` = ?;";
    private static final String GET_ALL_CU = "SELECT * FROM TEAM4.Course_Registraion WHERE `customer_id` = ?;";
    private static final String GET_ALL_TI = "SELECT * FROM TEAM4.Course_Registraion WHERE `course_timeble_id` = ?;"; */
    public void insert(CourseRegistraionVO crVo){
        // Hibernate
        if(crVo != null){
            CourseRegistraionVO newCr = this.s.get(CourseRegistraionVO.class, crVo.getCourseId());
            if(newCr == null){
                this.s.save(crVo);
            }
        }
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, crVo.getRegistrationId());
            ps.setInt(2, crVo.getCustomerId());
            ps.setInt(3, crVo.getCourseId());
            ps.setInt(4, crVo.getCourseTimeableId());
            ps.setInt(5, crVo.getNumOfPeople());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }         */
    }
    // public void update(CourseRegistraionVO crVo){
    //     try (Connection con = ds.getConnection();
    //         PreparedStatement ps = con.prepareStatement(UPDATE)) {
            
    //     } catch (SQLException se) {
    //         throw new RuntimeException("A database error occured. "
	// 				+ se.getMessage());
    //     }        
    // }
    public void delete(Integer registrationId){
        // Hibernate
        if(registrationId != null){
            CourseRegistraionVO newCr = this.s.get(CourseRegistraionVO.class, registrationId);
            if(newCr != null){
                this.s.delete(newCr);;
            }
        }
        // DateSource Jdbc
        /* Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, registrationId);
            ps.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
        } catch (SQLException se) {
            if(con != null){
                try {
                    con.rollback();
                } catch (SQLException e) {
                    throw new RuntimeException("rollback error occured. "
					+ e.getMessage());        
                }
            }
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } finally{
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
        } */
    }
    public CourseRegistraionVO selectByCustomerId(Integer customerId, Integer courseTimeableId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<CourseRegistraionVO> cq = cb.createQuery(CourseRegistraionVO.class);
        Root<CourseRegistraionVO> root = cq.from(CourseRegistraionVO.class);
        cq = cq.where(cb.and(
                            cb.equal(root.get("customer_id"), customerId),
                            cb.equal(root.get("course_timeable_id"), courseTimeableId)
                            )
                    );
        return this.s.createQuery(cq).getSingleResult();
        // DateSource Jdbc
        /* CourseRegistraionVO crVo = new CourseRegistraionVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, customerId);
            ps.setInt(2, courseTimeableId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                crVo.setRegistrationId(rs.getInt("registration_id"));
                crVo.setCustomerId(rs.getInt("customer_id"));
                crVo.setCourseId(rs.getInt("course_id"));
                crVo.setCourseTimeableId(rs.getInt("course_timeble_id"));
                crVo.setNumOfPeople(rs.getInt("numOfPeople"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }            
        return crVo; */
    }
    public ArrayList<CourseRegistraionVO> selectAllCustomerRegister(Integer customerId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<CourseRegistraionVO> cq = cb.createQuery(CourseRegistraionVO.class);
        Root<CourseRegistraionVO> root = cq.from(CourseRegistraionVO.class);
        cq = cq.where(cb.equal(root.get("customer_id"), customerId));
        ArrayList<CourseRegistraionVO> list = new ArrayList<CourseRegistraionVO>();
        for(CourseRegistraionVO crVo : this.s.createQuery(cq).getResultList()){
            list.add(crVo);
        }
        return list;
        // DateSource Jdbc
        /* ArrayList<CourseRegistraionVO> list = new ArrayList<CourseRegistraionVO>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_CU)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CourseRegistraionVO crVo = new CourseRegistraionVO();
                crVo.setRegistrationId(rs.getInt("registration_id"));
                crVo.setCustomerId(rs.getInt("customer_id"));
                crVo.setCourseId(rs.getInt("course_id"));
                crVo.setCourseTimeableId(rs.getInt("course_timeble_id"));
                crVo.setNumOfPeople(rs.getInt("numOfPeople"));
                list.add(crVo);
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }            
        return list; */
    }
    public ArrayList<CourseRegistraionVO> selectByTimeableId(Integer courseTimeableId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<CourseRegistraionVO> cq = cb.createQuery(CourseRegistraionVO.class);
        Root<CourseRegistraionVO> root = cq.from(CourseRegistraionVO.class);
        cq = cq.where(cb.equal(root.get("course_timeable_id"), courseTimeableId));
        ArrayList<CourseRegistraionVO> list = new ArrayList<CourseRegistraionVO>();
        for(CourseRegistraionVO crVo : this.s.createQuery(cq).getResultList()){
            list.add(crVo);
        }
        return list;
        // DateSource Jdbc
        /* ArrayList<CourseRegistraionVO> list = new ArrayList<CourseRegistraionVO>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_TI)) {
            ps.setInt(1, courseTimeableId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CourseRegistraionVO crVo = new CourseRegistraionVO();
                crVo.setRegistrationId(rs.getInt("registration_id"));
                crVo.setCustomerId(rs.getInt("customer_id"));
                crVo.setCourseId(rs.getInt("course_id"));
                crVo.setCourseTimeableId(rs.getInt("course_timeble_id"));
                crVo.setNumOfPeople(rs.getInt("numOfPeople"));
                list.add(crVo);
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }            
        return list; */
    }
}
