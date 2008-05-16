package org.mule.transformers.xml.castor;

import java.io.IOException;
import java.io.StringWriter;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.TransformerException;

public class CastorObjectToXml extends AbstractCastorTransformer {
    private static final long serialVersionUID = 5779508056594486777L;

    public CastorObjectToXml() throws InitialisationException{
        registerSourceType(Object.class);
        setReturnClass(String.class);
       	initialise();
    }

	@Override
	protected Object doTransform(Object src, String encoding) throws TransformerException {
        Marshaller marshaller = getXMLContext().createMarshaller();
        StringWriter writer = new StringWriter();
        try {
            marshaller.setWriter(writer);
            marshaller.marshal(src);
        } catch (MarshalException e) {
            throw new TransformerException(this, e);
        } catch (ValidationException e) {
            throw new TransformerException(this, e);
        } catch (IOException e) {
            throw new TransformerException(this, e);
        }
        String xml = writer.toString();
        logger.debug("XML after conversion to XML: " + xml);
        return xml;
	}
}
