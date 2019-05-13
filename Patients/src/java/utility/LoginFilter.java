package utility;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.User;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "loginFilter", urlPatterns = { "/admin/*" })
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	  try {
			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
                        
                        User usr=(User) reqt.getSession().getAttribute("user"); 
                        if(usr==null){
			if (reqURI.contains("/admin/login.xhtml")
                                ||reqURI.contains("logout")){
                            resp.sendRedirect(reqt.getContextPath()+"/frontend/");
                        }else{
                            chain.doFilter(request, response);
                        }
					
				chain.doFilter(request, response);
                        }
                        else{
                            if(reqURI.contains("/admin/login.xhtml")||reqURI.contains("logout")){
                               resp.sendRedirect(reqt.getContextPath() + "/faces/admin/login.xhtml"); 
                            }else if(reqURI.contains("logout")){
                                reqt.getSession().getAttribute("user");
                                 resp.sendRedirect(reqt.getContextPath() + "/frontend/");
                            }
                        }
				//resp.sendRedirect(reqt.getContextPath() + "/faces/admin/login.xhtml");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void init(FilterConfig config) throws ServletException {
		
	}

	public void destroy() {
		
	}

}
