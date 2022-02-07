package web.CourseTimeable.dao;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; */
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

// import javax.sql.DataSource;

import org.hibernate.Session;

import ProjectInterfaces.CourseTimeableInterface;
import web.CourseTimeable.vo.CourseTimeableVO;

public class CourseTimeableDAO implements CourseTimeableInterface<CourseTimeableVO>{
    private Session s;
    public CourseTimeableDAO(Session s){
        this.s = s;
    }
    /* private static final String INSERT ="INSERT INTO `TEAM4`.`Course_Timeable`"
    +"(`course_id`,`course_date`)"
    +"VALUES"
    +"(?,?);";
    private static final String UPDATE ="UPDATE `TEAM4`.`Course_Timeable`"
    +"SET"
    +"`course_timeable_id` = ?,`course_id` = ?,`course_date` = ?"
    +"WHERE `course_timeable_id` = ?;";
    private static final String DELETE ="DELETE FROM `TEAM4`.`Course_Timeable` WHERE `course_timele_id` = ?;";
    private static final String selectByCourseId ="SELECT `course_date` FROM TEAM4.Course_Timeable WHERE `course_id` = ?;"; */
    public void insert(CourseTimeableVO ctvo){
        // Hibernate
        if(ctvo != null && ctvo.getCourseTimeableId() != null){
            CourseTimeableVO schedule = this.s.get(CourseTimeableVO.class, ctvo.getCourseTimeableId());
            if(schedule == null){
                this.s.save(ctvo);
            }
        }
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, ctvo.getCourseId());
            ps.setTimestamp(2, ctvo.getCourseDate());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } */
    }        
    public void update(CourseTimeableVO ctvo){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaUpdate<CourseTimeableVO> cu = cb.createCriteriaUpdate(CourseTimeableVO.class);
        Root<CourseTimeableVO> root = cu.from(CourseTimeableVO.class);
        cu = cu.set(root.get("course_id"), ctvo.getCourseId())
               .set(root.get("course_date"), ctvo.getCourseDate())
               .set(root.get("signUp_startdate"), ctvo.getSignUpStartdate())
               .set(root.get("signUp_deadline"), ctvo.getSignUpDeadline())
               .where(cb.equal(root.get("course_timeable_id"), ctvo.getCourseTimeableId()));
        this.s.createQuery(cu).executeUpdate();

        // Hibernate
        /* CourseTimeableVO schedule = this.s.get(CourseTimeableVO.class, ctvo.getCourseTimeableId());
        if(schedule != null){
            schedule.setCourseTimeableId(ctvo.getCourseTimeableId());
            schedule.setCourseId(ctvo.getCourseId());
            schedule.setCourseDate(ctvo.getCourseDate());
            schedule.setSignUpStartdate(ctvo.getSignUpStartdate());
            schedule.setSignUpDeadline(ctvo.getSignUpDeadline());
            this.s.save(schedule);
        } */
        // DateSource Jdbc
        /* try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, ctvo.getCourseTimeableId());
            ps.setInt(2, ctvo.getCourseId());
            ps.setTimestamp(3, ctvo.getCourseDate());
            ps.setInt(4, ctvo.getCourseTimeableId());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        } */
    }    
    public void delete(Integer courseTimeableId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaDelete<CourseTimeableVO> cd = cb.createCriteriaDelete(CourseTimeableVO.class);
        Root<CourseTimeableVO> root = cd.from(CourseTimeableVO.class);
        cd = cd.where(cb.equal(root.get("course_timeable_id"), courseTimeableId));
        this.s.createQuery(cd).executeUpdate();
        // Hibernate
       /*  CourseTimeableVO ctvo = this.s.get(CourseTimeableVO.class, courseTimeableId);
        if(ctvo != null){
            this.s.delete(ctvo);
        } */
        // DateSource Jdbc
        /* Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, courseTimeableId);
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
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.err);
                }
            }
        } */
    }    
    public ArrayList<Timestamp> selectByCourseId(Integer courseId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = this.s.getCriteriaBuilder();
        CriteriaQuery<Timestamp> cq = cb.createQuery(Timestamp.class);
        Root<Timestamp> root = cq.from(Timestamp.class);
        cq = cq.where(cb.equal(root.get("course_id"), courseId)).select(root.get("course_id"));
        return new ArrayList<Timestamp>(this.s.createQuery(cq).getResultList());
        // Hibernate HQL
        /* if(courseId != null){
            List<Timestamp> result = this.s.createQuery("select course_date from Course_Timeable where course_id = :id", Timestamp.class)
                                                        .setParameter("id", courseId).list();
            return new ArrayList<Timestamp>(result);
        }
        return null; */
        // DateSource Jdbc
        /* ArrayList<Timestamp> list = new ArrayList<Timestamp>();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(selectByCourseId)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getTimestamp("course_date"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
					+ se.getMessage());
        }
        return list; */
    }
}
