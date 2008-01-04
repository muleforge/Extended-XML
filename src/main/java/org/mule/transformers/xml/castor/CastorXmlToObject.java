package org.mule.transformers.xml.castor;

import java.io.StringReader;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.mule.umo.UMOEventContext;
import org.mule.umo.lifecycle.InitialisationException;
import org.mule.umo.transformer.TransformerException;

public class CastorXmlToObject extends AbstractCastorTransformer {
    private static final long serialVersionUID = 2843156176957514091L;
    private Unmarshaller unmarshaller;

    private Class rootClass;

    
    public CastorXmlToObject() {
        registerSourceType(String.class);
        setReturnClass(Object.class);
    }

    public void initialise() throws InitialisationException {
        super.initialise();
        unmarshaller = getXMLContext().createUnmarshaller();
        if (rootClass != null) {
            unmarshaller.setClass(rootClass);
        }
    }
    
    public Object transform(Object src, String encoding, UMOEventContext context)
            throws TransformerException {
        Object object;
        try {
            object = unmarshaller.unmarshal(new StringReader((String) src));
        } catch (MarshalException e) {
            throw new TransformerException(this, e);
        } catch (ValidationException e) {
            throw new TransformerException(this, e);
        }
        return object;
    }


    public Class getRootClass() {
        return rootClass;
    }

    public void setRootClass(Class rootClass) {
        this.rootClass = rootClass;
    }

}
