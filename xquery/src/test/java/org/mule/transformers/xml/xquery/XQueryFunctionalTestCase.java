/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.transformers.xml.xquery;

import org.mule.extras.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.umo.UMOMessage;
import org.mule.util.IOUtils;

import java.util.HashMap;
import java.util.Map;

import org.custommonkey.xmlunit.XMLUnit;

//START SNIPPET: test-code
public class XQueryFunctionalTestCase extends FunctionalTestCase
{
    protected String getConfigResources()
    {
        //Our Mule configuration file
        return "xquery-functional-test.xml";
    }

    public void testMessageTransform() throws Exception
    {
        //We're using Xml Unit to compare results
        //Ignore whitespace and comments
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreComments(true);

        //Read in src and result data
        String srcData = IOUtils.getResourceAsString("cd-catalog.xml", getClass());
        String resultData = IOUtils.getResourceAsString("cd-catalog-result-with-params.xml", getClass());

        //Create a new Mule Client
        MuleClient client = new MuleClient();

        //These are the message roperties that will get passed into the XQuery context
        Map props = new HashMap();
        props.put("ListTitle", "MyList");
        props.put("ListRating", new Integer(6));

        //Invoke the service
        UMOMessage message = client.send("vm://test.in", srcData, props);
        assertNotNull(message);
        assertNull(message.getExceptionPayload());
        //Compare results
        assertTrue(XMLUnit.compareXML(message.getPayloadAsString(), resultData).similar());
    }
}
//END SNIPPET: test-code
