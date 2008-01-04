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

import org.mule.tck.AbstractTransformerTestCase;
import org.mule.umo.transformer.UMOTransformer;

public class CastorXmlToObjectWithMappingFileTest extends AbstractTransformerTestCase {

    public Object getTestData() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><entity><age>37</age><name>werner</name></entity>";
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
        URL mappingFileURL = getClass().getClassLoader().getResource("mapping.xml");
        transformer.setMappingFile(mappingFileURL);
        transformer.initialise();
        return transformer;
    }

}
