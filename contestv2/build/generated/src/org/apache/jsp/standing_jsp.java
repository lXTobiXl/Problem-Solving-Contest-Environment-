package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Arrays;
import JSPSide.Problem;
import JSPSide.Standing;
import java.util.Set;
import java.util.Map;
import JSPSide.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public final class standing_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Standings</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        \n");
      out.write("        <link rel=\"icon\" href=\"img/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body class=\"container\">\n");
      out.write("        \n");
      out.write("        <div class=\"card-header\" style=\"font-family: Roboto, sans-serif; display: flex;\">\n");
      out.write("            <span style=\"font-weight: bold;\">Standing</span> \n");
      out.write("            <span class=\"link\" style=\"margin-left: auto;\"><a href=\"Clarification\">Clarification</a></span>\n");
      out.write("            <span class=\"link\"><a href=\"Problems\">Problems</a></span>\n");
      out.write("            <span class=\"link\">2019</span>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            int nProblems = Standing.getNumberOfProblems();
            int flag[] = new int[nProblems];
            boolean f2[] = new boolean[nProblems];
            char c;
        
      out.write("\n");
      out.write("        <table   class=\"scoreboard\" cellspacing=\"2\" cellpadding=\"2\">\n");
      out.write("            <thead>\n");
      out.write("            <tr class=\"scoreheader\" >\n");
      out.write("                <th title=\"rank\" scope=\"col\">Rank</th>\n");
      out.write("                <th title=\"team name\" scope=\"col\">Team Name</th>\n");
      out.write("                <th title=\"solved\" scope=\"col\" colspan=\"2\" >Solved / Time</th>\n");
      out.write("                    ");
 for (int i = 0; i < nProblems; i++) {
      out.write("\n");
      out.write("                <th scope=\"col\">");
      out.print((char) (i + 65));
      out.write("</th>                       \n");
      out.write("                    ");
}
      out.write(" \n");
      out.write("            </tr>\n");
      out.write("            </thead>\n");
      out.write("            ");
 List<Team> allTeams = (List<Team>) request.getAttribute("data");
               int count = 1;
               for (Team t : allTeams) {
            
      out.write("    \n");
      out.write("            <tr class=\"sortorderswitch\">\n");
      out.write("                <td class=\"scorepl\" >");
      out.print( count);
      out.write("</td>\n");
      out.write("                <td class=\"scoretn\" >");
      out.print(t.getTeamName());
      out.write("</td>\n");
      out.write("                <td class=\"scorenc\" >");
      out.print(t.getCountAcceptedSolutions());
      out.write("</td>\n");
      out.write("                <td class=\"scorett\" >");
      out.print(t.getTimePenality());
      out.write("</td>\n");
      out.write("\n");
      out.write("                ");

                    Set<Map.Entry<Character, Problem>> hshUni = t.getProblems().entrySet();
                    Iterator<Map.Entry<Character, Problem>> HMIterator = hshUni.iterator();
                    flag = new int[nProblems];
                    f2 = new boolean[nProblems];

                    while (HMIterator.hasNext()) {
                        Map.Entry<Character, Problem> entry = HMIterator.next();
                        c = entry.getKey();
                        flag[((int)c - 65)] = entry.getValue().getTriedCount();
                        f2[((int)c - 65)] = entry.getValue().getState();
                    }

                    for (int i = 0; i < flag.length; i++) {
                        if (flag[i] != 0) {
                            if(f2[i]){
      out.write("\n");
      out.write("                                <td class=\"score_cell score_correct\">");
      out.print(flag[i]);
      out.write("</td>\n");
      out.write("                            ");
}else{
      out.write("\n");
      out.write("                                <td class=\"score_cell score_incorrect\">");
      out.print(flag[i]);
      out.write("</td>\n");
      out.write("                            ");
 } 
      out.write("    \n");
      out.write("                            \n");
      out.write("                        ");
} else {
      out.write("\n");
      out.write("                         <td class=\"score_cell score_neutral\"> </td>\n");
      out.write("                        ");
}
                    }
      out.write("  \n");
      out.write("            </tr>\n");
      out.write("            ");
count++;}
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
      out.write("        <p><br /><br /></p>\n");
      out.write("\t\t<table id=\"cell_legend\" class=\"scoreboard scorelegend\">\n");
      out.write("\t\t\t<thead>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th scope=\"col\">Cell colours</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</thead>\n");
      out.write("\t\t\t<tbody>\n");
      out.write("\t\t\t\t<!--<tr class=\"score_first\">\n");
      out.write("\t\t\t\t\t<td>Solved first</td>\n");
      out.write("\t\t\t\t</tr>-->\n");
      out.write("\t\t\t\t<tr class=\"score_correct\">\n");
      out.write("\t\t\t\t\t<td>Solved</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr class=\"score_incorrect\">\n");
      out.write("\t\t\t\t\t<td>Tried, incorrect</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<!--<tr class=\"score_pending\">\n");
      out.write("\t\t\t\t\t<td>Tried, pending</td>\n");
      out.write("\t\t\t\t</tr>-->\n");
      out.write("\t\t\t\t<tr class=\"score_neutral\">\n");
      out.write("\t\t\t\t\t<td>Untried</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</tbody>\n");
      out.write("\t\t</table>\n");
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
