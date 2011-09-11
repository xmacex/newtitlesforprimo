// Depends on HttpClient and Axiom, this is inherited from
// joailib (http://code.google.com/p/joailib/). Have them in your
// classpath when you run this like so:
// java -classpath .:/usr/share/java/axiom-api.jar:/usr/share/java/axiom-impl.jar:/usr/share/java/httpclient.jar:/usr/share/java/httpcore.jar:/usr/share/java/commons-logging-api.jar:lib/joailib.jar HarvestNewTitles

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.rdksys.oai.Harvester;
import com.rdksys.oai.repository.Identify;
import com.rdksys.oai.repository.Set;
import com.rdksys.oai.data.Record;
import com.rdksys.oai.data.RecordIterator;

class HarvestNewTitles {
	public static void main(String[] args) throws Exception {
//		Harvester harvester = new Harvester("http://biblio.ugent.be/oai");
		Harvester harvester = new Harvester("http://memory.loc.gov/cgi-bin/oai2_0");
		// Identify
		Identify identify = harvester.identify();
		System.out.println(identify.getRepositoryName());
		System.out.println(identify.getProtocolVersion());

		// List sets
//		List<Set> sets = harvester.listSets();
//		for(Set set : sets) {
//			System.out.println(set.getSetName());
//   		}

		// List titles in a set
		String fromdate = "2011-06-01";
		String untildate = "2011-06-30";
		String set = "";

		RecordIterator records = harvester.listRecords(fromdate, untildate, set);
		while(records.hasNext()) {
			Record record = records.next();
			System.out.println(record.getMetadata().getTitleList().get(0));
		}

	}
}
