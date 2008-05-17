package org.mule.module.xml.castor.config;

import org.mule.config.spring.handlers.AbstractMuleNamespaceHandler;
import org.mule.config.spring.parsers.specific.TransformerDefinitionParser;
import org.mule.transformers.xml.castor.CastorObjectToXml;
import org.mule.transformers.xml.castor.CastorXmlToObject;

public class CastorNamespaceHandler extends AbstractMuleNamespaceHandler
{
    public void init()
    {
        registerBeanDefinitionParser("object-to-xml", new TransformerDefinitionParser(CastorObjectToXml.class));
        registerBeanDefinitionParser("xml-to-object", new TransformerDefinitionParser(CastorXmlToObject.class));
    }
}
