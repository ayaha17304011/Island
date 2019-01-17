package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserBean;

public class GetUserNameDao{
    public String getUserName(String uid){
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String name = null;
        
        try{
            cn = OraConnectionManager.getInstance().getConnection();
            String sql = "select username from as_user where userid=?";
            st = cn.prepareStatement(sql);
            st.setString(1, uid);
            rs = st.executeQuery();
            rs.next();
            name = rs.getString(1);
        }catch(SQLException e){
            OraConnectionManager.getInstance().rollback();
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }if(st != null){
                    st.close();
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return name;
    }
}