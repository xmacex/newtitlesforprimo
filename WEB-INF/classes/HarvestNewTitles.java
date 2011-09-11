// Depends on HttpClient and Axiom, plus a few other things. This
// is inherited from joailib (http://code.google.com/p/joailib/)

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.http.client.ClientProtocolException;

import com.rdksys.oai.Harvester;
import com.rdksys.oai.repository.Identify;
import com.rdksys.oai.repository.Set;

public class HarvestNewTitles extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		// Let's digest some parameters
		String paramvalue = request.getParameter("test");
		String repositoryurl = getServletContext().getInitParameter("repository.url");

		// We need a writer, let's summon one
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>rips raps harava</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(paramvalue);
		out.println("kahtotaas josko löytyisi mitään haravoitavaa");

		try {
//			Harvester harvester = new Harvester("http://biblio.ugent.be/oai");
			Harvester harvester = new Harvester(repositoryurl);
			// Identify
			Identify identify = harvester.identify();
			out.println(identify.getRepositoryName());
			out.println(identify.getProtocolVersion());

			// List sets
			List<Set> sets = harvester.listSets();
			for(Set set : sets) {
				out.println(set.getSetName());
   			}
	        } catch (Exception ex) {
		            ex.printStackTrace ();
		}
		out.println("</body>");
		out.println("</html>");
	}
}
