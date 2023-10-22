package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import myWebService.QuizWebService;
import myWebService.QuizService;
import java.util.ArrayList;
import java.lang.String;

public final class GradeQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("          ");

            QuizService proxy = quizWebService.getQuizServicePort();
            ArrayList<String> quiz = (ArrayList<String>) proxy.getQuestions();
            ArrayList<Boolean> answers = new ArrayList<Boolean>();
            for (int i = 0; i < quiz.size(); i++) {
                String trueOrFalse = request.getParameter("question" + i);
                if (trueOrFalse.equals("True"))answers.add(true);
                else answers.add(false);
            }
            ArrayList<Boolean> result = (ArrayList<Boolean>) proxy.gradeQuiz(answers);
            int correctCount = 0;
            for (int i = 0; i < result.size(); i++) {
                correctCount += result.get(i) ? 1 : 0;
            }
        
      out.write("\n");
      out.write("        Out of ");
      out.print( result.size());
      out.write(" questions, ");
      out.print( correctCount);
      out.write(" correct.\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
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
