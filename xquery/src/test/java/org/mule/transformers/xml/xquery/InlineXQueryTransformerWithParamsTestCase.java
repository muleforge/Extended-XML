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

import org.mule.impl.RequestContext;
import org.mule.tck.AbstractTransformerTestCase;
import org.mule.umo.UMOEvent;
import org.mule.umo.transformer.UMOTransformer;
import org.mule.util.IOUtils;

import java.util.Properties;

import org.custommonkey.xmlunit.XMLUnit;
import org.w3c.dom.Document;

/**
 * TODO
 */
public class InlineXQueryTransformerWithParamsTestCase extends AbstractTransformerTestCase
{

    private String srcData;
    private String resultData;

    protected void doSetUp() throws Exception
    {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreComments(true);
        srcData = IOUtils.getResourceAsString("cd-catalog.xml", getClass());
        resultData = IOUtils.getResourceAsString("cd-catalog-result-with-params.xml", getClass());
    }

    public UMOTransformer getTransformer() throws Exception
    {
        //We need a current event for the transformer to be invoked. However we pass in the src data directly
        UMOEvent event = getTestEvent("testing");
        //We can set params on the event that can be picked up in the Xquery expression. In the Transformer config we
        //map the value of 'ListTitle' to '$title' param
        event.getMessage().setProperty("ListTitle", "MyList");
        event.getMessage().setIntProperty("ListRating", 6);
        RequestContext.setEvent(event);


        XQueryTransformer transformer = new XQueryTransformer();
        transformer.setXquery(
                "declare variable $document external;\n" +
                "declare variable $title external;\n" +
                "declare variable $rating external;\n" +
                " <cd-listings title='{$title}' rating='{$rating}'>\n" +
                "{\n" +
                "    for $cd in $document/catalog/cd\n" +
                "    return <cd-title>{data($cd/title)}</cd-title>\n" +
                "} \n</cd-listings>");
        transformer.setReturnClass(String.class);
        Properties params = new Properties();
        params.setProperty("title", "#ListTitle");
        params.setProperty("rating", "#ListRating");
        transformer.setTransformParameters(params);
        transformer.initialise();
        return transformer;
    }

    public UMOTransformer getRoundTripTransformer() throws Exception
    {
        return null;
    }

    public void testRoundtripTransform() throws Exception
    {
        // disable this test
    }

    public Object getTestData()
    {
        return srcData;
    }

    public Object getResultData()
    {
        return resultData;
    }

    // @Override
    public boolean compareResults(Object expected, Object result)
    {
        if (expected instanceof Document && result instanceof Document)
        {
            return XMLUnit.compareXML((Document)expected, (Document)result).similar();
        }
        else if (expected instanceof String && result instanceof String)
        {
            try
            {
                String expectedString = this.normalizeString((String)expected);
                String resultString = this.normalizeString((String)result);
                return XMLUnit.compareXML(expectedString, resultString).similar();
            }
            catch (Exception ex)
            {
                return false;
            }
        }

        // all other comparisons are passed up
        return super.compareResults(expected, result);
    }
}