package ch07.ex02.controller ; 

import java.io.IOException;
//import java.util.List;
//import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *  本程式能產生大樂透(六個 1-49 數字)或小樂透(五個1-39數字)的隨機數字
 * 
 *  同一Servlet程式，經由起始參數的設定可以有不同的行為
 */
import ch07.ex02.model.GenerateLotteryNumbers;
@WebServlet(
	name="Lottery1",
	urlPatterns={"/ch07/BigLottery.do"},
	initParams={
			@WebInitParam(name="maxNumber", value="49"),
			@WebInitParam(name="amountOfBalls", value="6"),
	}
)
public class LotteryServletBig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int maxNumber; 
	int amountOfBalls;
	
	public void init() {
		 maxNumber = Integer.parseInt(getInitParameter("maxNumber"));
		 amountOfBalls = Integer.parseInt(getInitParameter("amountOfBalls"));
	}
	 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		
		GenerateLotteryNumbers   gln = new GenerateLotteryNumbers(maxNumber,  amountOfBalls);
		request.setAttribute("numberArray", gln.getNumbers()); 
		if (maxNumber == 49) {
			request.setAttribute("title", "大樂透明牌");
		} else if (maxNumber == 39){
			request.setAttribute("title", " 539 明牌");
		} else {
			request.setAttribute("title", "樂透明牌");
		}
		RequestDispatcher view = request.getRequestDispatcher("/ch07/lotteryResult.jsp");
		view.forward(request, response);
		
	}
}
	

	      
	    

	   
		

