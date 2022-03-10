package web.CourseTimeable.dao;

/* import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; */
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

// import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import ProjectInterfaces.CourseTimeableInterface;
import web.CourseTimeable.vo.CourseTimeableVO;

@Repository
public class CourseTimeableDAO implements CourseTimeableInterface<CourseTimeableVO>{
    // @Autowired
    // private SessionFactory sf;
    @PersistenceContext
    private Session s;
    public Session getSession() {
		// return sf.getCurrentSession();
		return s;
	}
    // public CourseTimeableDAO(Session s){
    //     this.s = s;
    // }
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
                getSession().save(ctvo);
        
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
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaUpdate<CourseTimeableVO> cu = cb.createCriteriaUpdate(CourseTimeableVO.class);
        Root<CourseTimeableVO> root = cu.from(CourseTimeableVO.class);
        cu = cu.set(root.get("courseId"), ctvo.getCourseId())
               .set(root.get("courseDate"), ctvo.getCourseDate())
               .set(root.get("signUpStartdate"), ctvo.getSignUpStartdate())
               .set(root.get("signUpDeadline"), ctvo.getSignUpDeadline())
               .where(cb.equal(root.get("courseTimeableId"), ctvo.getCourseTimeableId()));
        getSession().createQuery(cu).executeUpdate();

        // Hibernate
        /* CourseTimeableVO schedule = getSession().get(CourseTimeableVO.class, ctvo.getCourseTimeableId());
        if(schedule != null){
            schedule.setCourseTimeableId(ctvo.getCourseTimeableId());
            schedule.setCourseId(ctvo.getCourseId());
            schedule.setCourseDate(ctvo.getCourseDate());
            schedule.setSignUpStartdate(ctvo.getSignUpStartdate());
            schedule.setSignUpDeadline(ctvo.getSignUpDeadline());
            getSession().save(schedule);
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
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaDelete<CourseTimeableVO> cd = cb.createCriteriaDelete(CourseTimeableVO.class);
        Root<CourseTimeableVO> root = cd.from(CourseTimeableVO.class);
        cd = cd.where(cb.equal(root.get("courseTimeableId"), courseTimeableId));
        getSession().createQuery(cd).executeUpdate();
        // Hibernate
       /*  CourseTimeableVO ctvo = getSession().get(CourseTimeableVO.class, courseTimeableId);
        if(ctvo != null){
            getSession().delete(ctvo);
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
    public ArrayList<CourseTimeableVO> selectByCourseId(Integer courseId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CourseTimeableVO> cq = cb.createQuery(CourseTimeableVO.class);
        Root<CourseTimeableVO> root = cq.from(CourseTimeableVO.class);
        cq = cq.where(cb.equal(root.get("courseId"), courseId)).select(root);
        return new ArrayList<CourseTimeableVO>(getSession().createQuery(cq).getResultList());
        // Hibernate HQL
        /* if(courseId != null){
            List<Timestamp> result = getSession().createQuery("select course_date from Course_Timeable where course_id = :id", Timestamp.class)
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
    public CourseTimeableVO selectByTimeableId(Integer courseTimeableId){
        // JPA CriteriaQuery
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<CourseTimeableVO> cq = cb.createQuery(CourseTimeableVO.class);
        Root<CourseTimeableVO> root = cq.from(CourseTimeableVO.class);
        cq = cq.where(cb.equal(root.get("courseTimeableId"), courseTimeableId)).select(root);
        return getSession().createQuery(cq).getSingleResult();
    }
}
