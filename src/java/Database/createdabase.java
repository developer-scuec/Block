package Database;

import java.sql.Connection;
import java.sql.Statement;

public class createdabase {
	public static void main(String[] args) {
		ConnectDatabase cd = new ConnectDatabase();
		Connection conn = cd.getConnection();
		String sql = null;
		try {
			sql = "CREATE TABLE register("
					+"id int auto_increment primary key ,"
					+ "username VARCHAR(30) NOT NULL,"
					+ "password varchar(30) NOT NULL)ENGINE=InnoDB DEFAULT CHARSET=utf8";
			Statement st = conn.createStatement();
			System.out.println(sql);
			boolean b=st.execute(sql);
			if(b) {
				System.out.println("数据表创建失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			sql="create table goods("
//					+"id int auto_increment primary key,"
//					+"publisher varchar (50),"
//					+"title varchar(50),"
//					+"price int,"
//					+"description text,"
//					+"img_url text,"
//					+"address varchar(60),"
//					+"phone varchar(30),"
//					+"pay varchar(30)"
//		+")ENGINE=InnoDB DEFAULT CHARSET=utf8";
//			System.out.println(sql);
//			Statement st=conn.createStatement();
//			int line=st.executeUpdate(sql);
//			if(line>0){
//				System.out.println("success");
//			}
//
//		}catch (Exception e){
//			e.printStackTrace();
//		}

	}

}
