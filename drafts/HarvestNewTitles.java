// depends on the OCLC Harvester2

import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;

import org.apache.http.client.ClientProtocolException;
import org.apache.xpath.XPathAPI;

import ORG.oclc.oai.harvester2.verb.*;

class HarvestNewTitles {
	public static void main(String[] args) throws Exception {
		String baseurl = "http://memory.loc.gov/cgi-bin/oai2_0";
		Namespace OAI_NS = Namespace.getNamespace("http://www.openarchives.org/OAI/2.0/");
		DOMBuilder db = new DOMBuilder();
		ListSets ls = new ListSets(baseurl);

		// System.out.println(listSets.toString());
		// Drilling down to /OAI-PMH/ListSets/set
		Document reply = db.build(ls.getDocument());
		Element root = reply.getRootElement();
		List<Element> sets = root.getChild("ListSets",OAI_NS).getChildren("set",OAI_NS);

		for (Element set : sets) {
			String setName = set.getChildText("setName",OAI_NS);
				System.out.println(setName);
		}
	}
}
