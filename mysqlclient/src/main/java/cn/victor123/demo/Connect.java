package cn.victor123.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connect {


  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序
      //Class.forName("org.gjt.mm.mysql.Driver");
      System.out.println("Success loading Mysql Driver!");
    } catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
      Connection connect = DriverManager.getConnection(
          "jdbc:mysql://172.23.7.0:3306/demo", "opal", "f6daee460fc578e68f45a801de6e13de");
//          "jdbc:mysql://172.20.33.8:3306/opal_data_share_demo", "opal", "09f6c72c-d288-11e8-b8fa-f4e9d49f9720");
      //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * from dataset;");
      //user 为你表的名称
      while (rs.next()) {
        System.out.println(rs.getString("id"));
      }
    } catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }
}

