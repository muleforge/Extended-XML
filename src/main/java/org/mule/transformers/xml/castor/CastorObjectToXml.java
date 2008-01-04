package org.mule.transformers.xml.castor;

import java.io.IOException;
import java.io.StringWriter;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.mule.umo.UMOEventContext;
import org.mule.umo.transformer.TransformerException;

public class CastorObjectToXml extends AbstractCastorTransformer {
    private static final long serialVersionUID = 5779508056594486777L;

    public CastorObjectToXml() {
        registerSourceType(Object.class);
        setReturnClass(String.class);
    }

    public Object transform(Object src, String encoding, UMOEventContext context)
            throws TransformerException {
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
        logger.debug(xml);
        return xml;
    }
}
