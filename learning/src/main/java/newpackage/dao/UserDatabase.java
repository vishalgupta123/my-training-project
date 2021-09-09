package newpackage.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import newpackage.bean.User;

public class UserDatabase {
    Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    
    //for register user 
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into userdetails (id,name,address,email,password,phoneno) values(?,?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getId());
           pt.setString(2, user.getName());
           pt.setString(3, user.getAddress());
           pt.setString(4, user.getEmail());
           pt.setString(5, user.getPassword());
           pt.setLong(6, user.getPhoneno());
           
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
   
}