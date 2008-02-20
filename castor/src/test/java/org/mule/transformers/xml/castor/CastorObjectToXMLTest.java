/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.transformers.xml.castor;

import org.custommonkey.xmlunit.XMLUnit;
import org.mule.tck.AbstractTransformerTestCase;
import org.mule.umo.transformer.UMOTransformer;
import org.mule.util.IOUtils;

public class CastorObjectToXMLTest extends AbstractTransformerTestCase {
	private String resultData;
	
	
	protected void doSetUp() throws Exception {
		super.doSetUp();
        XMLUnit.setIgnoreWhitespace(true);
		resultData = IOUtils.getResourceAsString("entity.xml", getClass());
	}

    public UMOTransformer getRoundTripTransformer() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getTestData() {
        Entity entity = new Entity();
        entity.setName("werner");
        entity.setAge(37);
        return entity;
    }

    public UMOTransformer getTransformer() throws Exception {
        CastorObjectToXml transformer = new CastorObjectToXml();
        transformer.initialise();
        return transformer;

    }
    
	public Object getResultData() {
        return resultData;
    }


}
