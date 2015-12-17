package ch07_02;

import java.util.*;

import javax.servlet.*;


public class SelectMemberDataListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        String dbString = context.getInitParameter("DBString");
        MemberDAO dao = new MemberDAO(dbString);
        Collection<MemberBean> col = dao.select();
        context.setAttribute("contextMemberBean", col);
    }


    public void contextDestroyed(ServletContextEvent event) {
        // TODO Auto-generated method stub
    }
	
}
