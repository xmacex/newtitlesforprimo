// depends on the OCLC Harvester2

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import ORG.oclc.oai.harvester2.verb.*;

class HarvestNewTitles {
	public static void main(String[] args) throws Exception {
		String baseurl = "http://memory.loc.gov/cgi-bin/oai2_0";
		ListSets listSets = new ListSets(baseurl);

		System.out.println(listSets.toString());
	}
}
