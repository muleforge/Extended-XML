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

    public void testCastorObjectToXMLTest() throws Exception{
        MuleClient client = new MuleClient();
        UMOMessage message = client.send("vm://testComponent",testData, null);
    }
}
