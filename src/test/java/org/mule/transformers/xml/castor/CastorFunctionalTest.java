package org.mule.transformers.xml.castor;

import org.mule.extras.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.umo.UMOMessage;

public class CastorFunctionalTest extends FunctionalTestCase {
    private String testData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><entity age=\"37\"><name>werner</name></entity>";

    @Override
    protected String getConfigResources() {
        return "castor-mule-config.xml";
    }

    public void testCastorXmlToObject() throws Exception{
        MuleClient client = new MuleClient();
        UMOMessage message = client.send("vm://testComponentXmlToObject",testData, null);
    }
    
    public void testCastorObjectToXml() throws Exception{
        MuleClient client = new MuleClient();
        Entity e = new Entity();
        e.setAge(37);
        e.setName("werner");
        UMOMessage message = client.send("vm://testComponentObjectToXml",e, null);
    }

}
