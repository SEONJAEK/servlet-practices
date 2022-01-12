package helloweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 처리(request handle)
		
		//응답(response)
		//응답헤더에 이걸 넣어야 함
		response.setContentType("text/html; charset=utf-8");
		//여기서 부터 바디
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Hello World</h1>");
		pw.println("<h1>안녕하세요.</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
