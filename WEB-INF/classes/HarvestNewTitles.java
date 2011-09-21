// Depends on HttpClient and Axiom, plus a few other things. This
// is inherited from joailib (http://code.google.com/p/joailib/)

import java.io.*;
import java.util.List;
import java.util.Iterator;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.http.client.ClientProtocolException;

import com.rdksys.oai.Harvester;
import com.rdksys.oai.repository.Identify;
import com.rdksys.oai.repository.Set;
import com.rdksys.oai.data.Record;
import com.rdksys.oai.data.RecordIterator;

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

		try {
			Harvester harvester = new Harvester(repositoryurl);
			// Identify
			Identify identify = harvester.identify();
			out.println(identify.getRepositoryName());
			out.println(identify.getProtocolVersion());

			// List sets
			out.println("<h2>settejä</h2>");
			out.println("<ul>");
			List<Set> sets = harvester.listSets();
			for(Set set : sets) {
				out.println("<li>");
				out.println(set.getSetName());
				out.println("</li>");
   			}
			out.println("</ul>");

			// List titles in a set give in the URL as parameter "set"
			String fromdate = "2011-06-01";
			String untildate = "2011-06-30";
			String set = paramvalue;

			File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tmpdir");
			File tempFile = File.createTempFile(getServletName(), ".tmp", tempDir);
			FileWriter fw = new FileWriter(tempFile);
			String filename = tempFile.getPath();
			out.println(filename);

			// These two lines create two different iterators... how do i create only one?
			// The thing is that this Servlet isn't allowed to create files without
			// guidance (see above), but i don't understand how do i pass the "filename" as
			// an argument to the RecordIterator constructor, and do the harvesting too...
			/// constructor creates the iterator
			RecordIterator records = new RecordIterator(filename);
			/// method to populate it with data
			//records = harvester.listRecords(fromdate, untildate, set);
			
			out.println("<ol>");
			while(records.hasNext()) {
				Record record = records.next();
				out.println("<li>");
				out.println(record.getMetadata().getTitleList().get(0));
				out.println("</li>");
			}
			out.println("</ol>");

	        } catch (Exception ex) {
		            ex.printStackTrace ();
		}
		out.println("</body>");
		out.println("</html>");
	}
}
