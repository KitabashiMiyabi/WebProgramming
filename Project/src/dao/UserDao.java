package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	  /**
     * ログインIDとパスワードに紐づくユーザ情報を返す
     * @param loginId
     * @param password
     * @return
     */
    public User findByLoginInfo(String loginId, String password) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, loginId);
            pStmt.setString(2, password);
            ResultSet rs = pStmt.executeQuery();

             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
            if (!rs.next()) {
                return null;
            }

            String loginIdData = rs.getString("login_id");
            String nameData = rs.getString("name");
            return new User(loginIdData, nameData);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }
    public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            // TODO: 未実装：管理者以外を取得するようSQLを変更する
            String sql = "SELECT * FROM user";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                Date birthDate = rs.getDate("birth_date");
                String password = rs.getString("password");
                String createDate = rs.getString("create_date");
                String updateDate = rs.getString("update_date");
                User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;

    }


    public void signup (String loginId, String password,String name,String birthDate)throws SQLException {
    	  Connection conn = null;
    	  conn = DBManager.getConnection();

    	  try {
              String sql = "INSERT INTO user (login_id, password, name, birth_date, create_date, update_date) VALUES (?, ?, ?, ?, now(), now())";

              PreparedStatement pStmt = conn.prepareStatement(sql);
              pStmt.setString(1, loginId);
              pStmt.setString(2, password);
              pStmt.setString(3, name);
              pStmt.setString(4, birthDate);

              pStmt.executeUpdate();



          } catch (SQLException e) {
              e.printStackTrace();
              throw e;
          } finally {
        	  if (conn != null) {
                  try {
                      conn.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
        	  }

          }
     }
    	  public void update( String password)throws SQLException {
        	  Connection conn = null;
        	  conn = DBManager.getConnection();

        	  try {
                  String sql = "SELECT loginId, name, birth_date FROM user";

                  Statement stmt = conn.createStatement();
                  stmt.executeQuery(sql);




              } catch (SQLException e) {
                  e.printStackTrace();
                  throw e;
              } finally {
            	  if (conn != null) {
                      try {
                          conn.close();
                      } catch (SQLException e) {
                          e.printStackTrace();
                      }
            	  }

              }
    }
}
