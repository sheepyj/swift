package cn.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.JSONException;
import org.json.JSONObject;

//import cn.first.DBConnection;

public class Wenti extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");

		
		try {
			////////////
			// do something
			////////////
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery("select * from dati");
			
			String id = "";
			String question = "";
			String optionA = "";
			String optionB = "";
			String optionC= "" ;
			String optionD= "" ;
			String answer = "";
			
			
			int count=0;
			ArrayList<Question> list=new ArrayList<Question>();
			while(rs.next()){
				
				count++;
				id=rs.getString(1);
				question=rs.getString(2);
				optionA=rs.getString(3);
				optionB=rs.getString(4);
				optionC=rs.getString(5);
				optionD=rs.getString(6);
				answer=rs.getString(7);
				Question q=new Question(id,question,optionA,optionB,optionC,optionD,answer);
				list.add(q);
			}
			db.close();
			
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			
			JSONObject obj1 = new JSONObject();
			Question q1=list.get(0);
			//obj.put("result", "ok");
			obj1.put("id", q1.id);
			obj1.put("question",q1.question);
			obj1.put("optionA", q1.optionA);
			obj1.put("optionB",q1.optionB);
			obj1.put("optionC",q1.optionC);
			obj1.put("optionD",q1.optionD);
			obj1.put("answer",q1.answer);
			obj.put("question1",obj1);
			
			JSONObject obj2 = new JSONObject();
			Question q2=list.get(1);
			//obj.put("result", "ok");
			obj2.put("id", q2.id);
			obj2.put("question",q2.question);
			obj2.put("optionA", q2.optionA);
			obj2.put("optionB",q2.optionB);
			obj2.put("optionC",q2.optionC);
			obj2.put("optionD",q2.optionD);
			obj2.put("answer",q2.answer);
			obj.put("question2",obj2);
			
			JSONObject obj3 = new JSONObject();
			Question q3=list.get(2);
			//obj.put("result", "ok");
			obj3.put("id", q3.id);
			obj3.put("question",q3.question);
			obj3.put("optionA", q3.optionA);
			obj3.put("optionB",q3.optionB);
			obj3.put("optionC",q3.optionC);
			obj3.put("optionD",q3.optionD);
			obj3.put("answer",q3.answer);
			obj.put("question3",obj3);
			
			JSONObject obj4 = new JSONObject();
			Question q4=list.get(3);
			//obj.put("result", "ok");
			obj4.put("id", q4.id);
			obj4.put("question",q4.question);
			obj4.put("optionA", q4.optionA);
			obj4.put("optionB",q4.optionB);
			obj4.put("optionC",q4.optionC);
			obj4.put("optionD",q4.optionD);
			obj4.put("answer",q4.answer);
			obj.put("question4",obj4);
			
			JSONObject obj5 = new JSONObject();
			Question q5=list.get(4);
			//obj.put("result", "ok");
			obj5.put("id", q5.id);
			obj5.put("question",q5.question);
			obj5.put("optionA", q5.optionA);
			obj5.put("optionB",q5.optionB);
			obj5.put("optionC",q5.optionC);
			obj5.put("optionD",q5.optionD);
			obj5.put("answer",q5.answer);
			obj.put("question5",obj5);
			
			
			
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
	}

}
