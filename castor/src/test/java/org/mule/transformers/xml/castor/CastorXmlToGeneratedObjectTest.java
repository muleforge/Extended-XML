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

import org.mule.tck.AbstractTransformerTestCase;
import org.mule.transformers.xml.castor.entities.entities.generated.Element;
import org.mule.umo.transformer.UMOTransformer;

public class CastorXmlToGeneratedObjectTest extends AbstractTransformerTestCase {

    public Object getTestData() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><element><age>37</age><name>werner</name></element>";
    }

    public UMOTransformer getRoundTripTransformer() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getResultData() {
        Element entity = new Element();
        entity.setExtendedName("werner");
        entity.setAge((short) 37);
        return entity;
    }

    public UMOTransformer getTransformer() throws Exception {
        CastorXmlToObject transformer = new CastorXmlToObject();
        transformer.setRootClass(Element.class);
        transformer.initialise();
        return transformer;
    }

}
