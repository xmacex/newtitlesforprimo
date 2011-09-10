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

class HarvestNewTitles {
	public static void main(String[] args) throws Exception {
		Harvester harvester = new Harvester("http://biblio.ugent.be/oai");

		// Identify
		Identify identify = harvester.identify();
		System.out.println(identify.getRepositoryName());
		System.out.println(identify.getProtocolVersion());

		// List sets
		List<Set> sets = harvester.listSets();
		for(Set set : sets) {
			System.out.println(set.getSetName());
   		}
	}
}
