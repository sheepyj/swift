package cn.first;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class CopyOfDBTest {

	public static void main(String[] args) {
		try {
			DBConnection b =new DBConnection();
			String sql = "insert into student(id,question,optionA,optionB,optionC,optionD,answer) values('t1','Tom',20,'计算机','湖南')";
			
			b.execute(sql);
			ResultSet rs = b.executeQuery("select * from dati");
			
			ArrayList<Question> list = new ArrayList<Question>();
			while(rs.next()){
				String id = rs.getString(1);
				String question = rs.getString(2);
				String optionA = rs.getString(3);
				String optionB = rs.getString(4);
				String optionC = rs.getString(5);
				String optionD = rs.getString(6);
				String answer = rs.getString(7);
				
				Question t = new Question(id,question,optionA,optionB,optionC,optionD,answer);
				list.add(t);
			}
			b.close();
			Random r = new Random();
			int j=0;
			int[] ques= {-1,-1,-1,-1};
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				System.out.println(randnumber);
				//if not exist 
				ques[j] = randnumber;
				j++;
			}
			
			for(int k=0;k<4;k++) {
				Question s = list.get(k);
				System.out.println(s.getId());
				System.out.println(s.getQuestion());
				System.out.println(s.getOptionA());
				System.out.println(s.getOptionB());
				System.out.println(s.getOptionC());
				System.out.println(s.getOptionD());
				System.out.println(s.getAnswer());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
