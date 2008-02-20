package org.mule.transformers.xml.castor;

import org.custommonkey.xmlunit.XMLUnit;
import org.mule.extras.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.umo.UMOMessage;
import org.mule.util.IOUtils;

public class CastorFunctionalTest extends FunctionalTestCase {
	private String testData;

	protected void doPreFunctionalSetUp() throws Exception {
		super.doPreFunctionalSetUp();
		XMLUnit.setIgnoreWhitespace(true);
		testData = IOUtils.getResourceAsString("entity.xml", getClass());
	}

	protected String getConfigResources() {
		return "castor-mule-config.xml";
	}

	public void testCastorXmlToObject() throws Exception {
		MuleClient client = new MuleClient();
		UMOMessage message = client.send("vm://testComponentXmlToObject", testData, null);
	}

	public void testCastorObjectToXml() throws Exception {
		MuleClient client = new MuleClient();
		UMOMessage message = client.send("vm://testComponentObjectToXml", getEntity(), null);
	}
	
	public void testCastorXmlToObjectWithMappingFile() throws Exception {
		MuleClient client = new MuleClient();
		UMOMessage message = client.send("vm://testComponentXmlToObjectWithMapping", testData, null);
	}
	
	public void testCastorObjectToXmlWithMappingFile() throws Exception {
		MuleClient client = new MuleClient();
		UMOMessage message = client.send("vm://testComponentObjectToXmlWithMapping", getEntity(), null);
	}
	
	private Entity getEntity(){
		Entity e = new Entity();
		e.setAge(37);
		e.setName("werner");
		return e;
	}

}
