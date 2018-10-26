package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getComputerGameData_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      com.fczyz.sklep.service.GameService storage = null;
      synchronized (application) {
        storage = (com.fczyz.sklep.service.GameService) _jspx_page_context.getAttribute("storage", PageContext.APPLICATION_SCOPE);
        if (storage == null){
          storage = new com.fczyz.sklep.service.GameService();
          _jspx_page_context.setAttribute("storage", storage, PageContext.APPLICATION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      com.fczyz.sklep.game.ComputerGame computergame = null;
      synchronized (session) {
        computergame = (com.fczyz.sklep.game.ComputerGame) _jspx_page_context.getAttribute("computergame", PageContext.SESSION_SCOPE);
        if (computergame == null){
          computergame = new com.fczyz.sklep.game.ComputerGame();
          _jspx_page_context.setAttribute("computergame", computergame, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form action=\"addComputerGame.jsp\">\r\n");
      out.write("\r\n");
      out.write("  Title :<input type=\"text\" name=\"Title\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${computergame.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br />\r\n");
      out.write("  Release Date :<input type=\"date\"  name=\"releaseDate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${computergame.releaseDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br />\r\n");
      out.write("  Price :<input type=\"number\" step=\"0.01\"  name=\"price\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${computergame.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br />\r\n");
      out.write("  Available :<input type=\"text\"  name=\"available\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${computergame.available}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /><br />\r\n");
      out.write("  <input type=\"submit\" value=\" Add \">\r\n");
      out.write("  \r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
