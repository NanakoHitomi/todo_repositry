package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {  //親クラスを継承　
    //HttpServletはさまざまなSクラスを含む。継承することでリストサーブレットはうまく動く

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getAttribute("message") == null) {
            request.setAttribute("message", "todoを管理しましょう");
        }
        
        int postId = Integer.parseInt(request.getParameter("id"));

        String url = "jdbc:mysql://localhost/todo";
        String user = "root";
        String password = ""; //mysqlでpwなしに設定されているためpw設定するとダメそう
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM posts WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement statement = connection.prepareStatement(sql)) {
        	
        	statement.setInt(1, postId);
        	
        	ResultSet results = statement.executeQuery();
        			
            while (results.next()) {

                String id = results.getString("id");
                request.setAttribute("id", id);

                String title = results.getString("title");
                request.setAttribute("title", title);

                String content = results.getString("content").replaceAll("¥n", "<br>");
                request.setAttribute("content", content);
                
                String priority = results.getString("priority");
                request.setAttribute("priority", priority);
                
                String date = results.getString("date");
                request.setAttribute("date", date);

            }
        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }


        String view = "/WEB-INF/views/post.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);


    }
    
}
