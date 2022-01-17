package web.Creditcrad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ProjectInterfaces.CreditcradInterface;
import web.Creditcrad.vo.CreditcradVO;

public class CreditcardDAO implements CreditcradInterface<CreditcradVO>{
    private static DataSource ds = null;
    static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ProjectDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
    private static final String INSERT = "INSERT INTO `TEAM4`.`Creditcard_Info`"
    +"(`creditcard_number`,`customer_id`,`cvv_code`,`expire_year`,`expire_month`,`cardholder_name`)"
    +"VALUES"
    +"(?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE `TEAM4`.`Creditcard_Info`"
    +"SET"
    +"`creditcard_number` = ?,`customer_id` = ?,`cvv_code` = ?,`expire_year` = ?,`expire_month` = ?,`cardholder_name` = ?"
    +"WHERE `customer_id` = ?;";
    private static final String DELETE = "DELETE FROM `TEAM4`.`Creditcard_Info` WHERE `customer_id` = ?;";
    private static final String GET_ONE_STM = "SELECT * FROM TEAM4.Creditcard_Info WHERE `customer_id` = ?;";
    public void insert(CreditcradVO cVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {
            ps.setInt(1, cVo.getCreditcard_number());
            ps.setInt(2, cVo.getCustomer_id());
            ps.setString(3, cVo.getCvv_code());
            ps.setString(4, cVo.getExpire_year());
            ps.setString(5, cVo.getExpire_month());
            ps.setString(6, cVo.getCardholder_name());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void update(CreditcradVO cVo){
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {
            ps.setInt(1, cVo.getCreditcard_number());
            ps.setInt(2, cVo.getCustomer_id());
            ps.setString(3, cVo.getCvv_code());
            ps.setString(4, cVo.getExpire_year());
            ps.setString(5, cVo.getExpire_month());
            ps.setString(6, cVo.getCardholder_name());
            ps.setInt(7, cVo.getCustomer_id());
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
    }
    public void delete(Integer customer_id){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = ds.getConnection();
            con.setAutoCommit(false);
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, customer_id);
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
        }
    }
    public CreditcradVO selectByCustomerId(Integer customer_id){
        CreditcradVO cVo = new CreditcradVO();
        try (Connection con = ds.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ONE_STM)) {
            ps.setInt(1, customer_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cVo.setCreditcard_number(rs.getInt("creditcard_number"));
                cVo.setCardholder_name(rs.getString("cardholder_name"));
                cVo.setCustomer_id(rs.getInt("customer_id"));
                cVo.setCvv_code(rs.getString("cvv_code"));
                cVo.setExpire_year(rs.getString("expire_year"));
                cVo.setExpire_month(rs.getString("expire_month"));
            }
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
            + se.getMessage());
        }
        return cVo;
    }
}
