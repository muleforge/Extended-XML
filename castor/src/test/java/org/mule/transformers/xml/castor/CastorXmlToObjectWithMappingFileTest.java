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

import java.net.URL;

import org.custommonkey.xmlunit.XMLUnit;
import org.mule.tck.AbstractTransformerTestCase;
import org.mule.umo.transformer.UMOTransformer;
import org.mule.util.IOUtils;

public class CastorXmlToObjectWithMappingFileTest extends AbstractTransformerTestCase {
	private String testData;
	private URL mappingFileURL;

	protected void doSetUp() throws Exception {
		super.doSetUp();
		XMLUnit.setIgnoreWhitespace(true);
		testData = IOUtils.getResourceAsString("entity.xml", getClass());
		mappingFileURL = getClass().getClassLoader().getResource("mapping.xml");
	}

    public Object getTestData() {
        return testData;
    }

    public UMOTransformer getRoundTripTransformer() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getResultData() {
        Entity entity = new Entity();
        entity.setName("werner");
        entity.setAge(37);
        return entity;
    }

    public UMOTransformer getTransformer() throws Exception {
        CastorXmlToObject transformer = new CastorXmlToObject();
        transformer.setMappingFile(mappingFileURL);
        transformer.setRootClass(Entity.class);
        transformer.initialise();
        return transformer;
    }

}
