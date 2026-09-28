import java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "Ajmeera4769"
            );

            System.out.println("Connected Successfully!");
            Statement st = con.createStatement();
            String sql="insert into studentbi(id,name,marks)" +
                    "values(?,?,?)";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,101);
            ps.setString(2,"alice");
            ps.setInt(3,45);
            ps.executeUpdate();
            ResultSet rs = st.executeQuery("select * from studentbi");
            while(rs.next()){
                System.out.println(rs.getInt("id")+"|"+rs.getString("name")+"|"+rs.getInt("marks"));
            }
            con.close();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}