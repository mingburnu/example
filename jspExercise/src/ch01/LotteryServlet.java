package ch01;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LotteryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 try {
			  // 說明瀏覽器送來之使用者所輸入資料的編碼
	          request.setCharacterEncoding("UTF-8");  
	          // 讀取使用者在 <input name='visitor' ...>標籤內所輸入的資料，放入變數 name內
	          String name = request.getParameter("visitor");
	          // 如果瀏覽器沒有送來名為visitor的資料 或 瀏覽器有送來名為visitor的資料，但去掉該資料的頭尾空白後，長度為 0  
	          if (name == null || name.trim().length() == 0 ) {
	             name = "訪客";
	          }
	          // 產生 LotteryBean 類別的物件 
	          LotteryBean lottery = new LotteryBean();
	          // 設定樂透號碼的下限為 1	          
	          lottery.setLowerBound(1);
	          // 設定樂透號碼的上限為 49	 
	          lottery.setUpperBound(49);
	          // 設定樂透號碼的數字個數為 6	 	                  
	          lottery.setBallNumber(6);
	          // 呼叫產生 LotteryBean 物件的 getLuckyNumbers()來產生六個樂透數字        
	          Collection<Integer> coll = lottery.getLuckyNumbers();
              // 將name資料放入request物件內，成為它屬性物件，屬性物件可以讓別的程式共用。
	          request.setAttribute("visitName", name);
              // 將coll資料放入request物件內，成為它屬性物件，屬性物件可以讓別的程式共用。	          
	          request.setAttribute("luckyNumber", coll);
	          // 準備將程式的執行順序移轉到 /ch01/goodLuck.jsp 
	          RequestDispatcher rd = request.getRequestDispatcher("/ch01/goodLuck.jsp");
	          rd.forward(request, response);
	          return ;
	       } catch(UnsupportedEncodingException e) {
	          throw new ServletException(e); 
	       }
	}
}