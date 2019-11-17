package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import problemsJSPSide.Problem;
import java.util.ArrayList;

public final class problems_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Problems</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("        <script type=\"text/x-mathjax-config\">\n");
      out.write("            MathJax.Hub.Config({\n");
      out.write("            tex2jax: {inlineMath: [[\"$\",\"$\"],[\"\\\\(\",\"\\\\)\"]]}\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/MathJax/MathJax.js?config=TeX-AMS_CHTML\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"icon\" href=\"img/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("\n");
      out.write("        <div class=\"card-header\" style=\"font-family: Roboto, sans-serif; display: flex;\">\n");
      out.write("            <span style=\"font-weight: bold;\">Problems</span> \n");
      out.write("            <span class=\"link\" style=\"margin-left: auto;\"><a href=\"Clarification\">Clarification</a></span>\n");
      out.write("            <span class=\"link\"><a href=\"Standing\">Standing</a></span>\n");
      out.write("            <span class=\"link\">2019</span>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <table   class=\"scoreboard\" cellspacing=\"2\" cellpadding=\"2\">\n");
      out.write("            <thead>\n");
      out.write("                <tr class=\"scoreheader\" >\n");
      out.write("                    <th title=\"count\" scope=\"col\">ID</th>\n");
      out.write("                    <th title=\"time\" scope=\"col\" style=\"max-width: 15px;\">Time Limit</th>\n");
      out.write("                    <th title=\"problem\" scope=\"col\">Problem</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            ");
 ArrayList<Problem> all = (ArrayList<Problem>) request.getAttribute("data");
                int count = 65;
                for (Problem p : all) {
            
      out.write("    \n");
      out.write("            <tr class=\"sortorderswitch\">\n");
      out.write("                <td class=\"scorepl\" >");
      out.print( (char) count);
      out.write("</td>\n");
      out.write("                <td class=\"scoretn\" >");
      out.print(p.getTimelimit());
      out.write("</td>\n");
      out.write("                <td class=\"scorenc\" >");
      out.print(p.getProblem());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");
count++;
                }
      out.write("\n");
      out.write("        </table>\n");
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
