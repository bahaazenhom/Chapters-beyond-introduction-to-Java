package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import myWebService.QuizWebService;
import myWebService.QuizService;
import java.util.*;
import java.lang.*;

public final class DisplayQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      myWebService.QuizWebService quizWebService = null;
      synchronized (session) {
        quizWebService = (myWebService.QuizWebService) _jspx_page_context.getAttribute("quizWebService", PageContext.SESSION_SCOPE);
        if (quizWebService == null){
          quizWebService = new myWebService.QuizWebService();
          _jspx_page_context.setAttribute("quizWebService", quizWebService, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            QuizService proxy = quizWebService.getQuizServicePort();
            ArrayList<String> questions = (ArrayList<String>) proxy.getQuestions();
        
      out.write("\n");
      out.write("        <form method = \"post\" action =\"GradeQuiz.jsp\">\n");
      out.write("            <table>\n");
      out.write("                ");
 for (int i = 0; i < questions.size(); i++) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <label>");
      out.print( questions.get(i));
      out.write("</label>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type =\"radio\" name = ");
      out.print( "question" + i);
      out.write("\n");
      out.write("                               value=\"True\"/>True\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type =\"radio\" name = ");
      out.print( "question" + i);
      out.write("\n");
      out.write("                               value=\"False\"/>False\n");
      out.write("                    </td>\n");
      out.write("                </tr>  \n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <p><input type =\"submit\" name =\"Submit\" value=\"Submit\">\n");
      out.write("                <input type =\"reset\" value=\"Reset\">\n");
      out.write("            </p>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
