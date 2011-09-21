// Depends on HttpClient and Axiom, plus a few other things. This
// is inherited from joailib (http://code.google.com/p/joailib/)

import java.io.*;
import java.util.List;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.http.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;

import org.apache.http.client.ClientProtocolException;
import org.apache.xpath.XPathAPI;
import ORG.oclc.oai.harvester2.verb.*;

public class HarvestNewTitles extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		// Let's digest some parameters
		String paramvalue = request.getParameter("set");
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

		String baseurl = "http://memory.loc.gov/cgi-bin/oai2_0";
		Namespace OAI_NS = Namespace.getNamespace("http://www.openarchives.org/OAI/2.0/");
		DOMBuilder db = new DOMBuilder();

		try {
			ListSets ls = new ListSets(baseurl);
			Document reply = db.build(ls.getDocument());
			Element root = reply.getRootElement();
			List<Element> sets = root.getChild("ListSets",OAI_NS).getChildren("set",OAI_NS);

			for (Element set : sets) {
				String setName = set.getChildText("setName",OAI_NS);
					out.println(setName);
			}
	        } catch (Exception ex) {
		            ex.printStackTrace ();
		}
		out.println("</body>");
		out.println("</html>");
	}
}
