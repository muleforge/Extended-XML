package org.mule.transformers.xml.castor;

import java.io.StringReader;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.TransformerException;

public class CastorXmlToObject extends AbstractCastorTransformer {
    private static final long serialVersionUID = 2843156176957514091L;

    @SuppressWarnings("unchecked")
    private Class rootClass;
    
    public CastorXmlToObject() throws InitialisationException{
        registerSourceType(String.class);
        setReturnClass(Object.class);
      	initialise();
    }

    public Class getRootClass() {
        return rootClass;
    }

    public void setRootClass(final Class rootClass) {
        logger.debug("Setting >"+ rootClass.getName() + "< as root class.");
        this.rootClass = rootClass;
    }

	@Override
	protected Object doTransform(Object src, String encoding)	throws TransformerException {
        Object object;
        Unmarshaller unmarshaller = getXMLContext().createUnmarshaller();
        if (rootClass != null) {
            unmarshaller.setClass(rootClass);
        }
        try {
            object = unmarshaller.unmarshal(new StringReader((String) src));
        } catch (MarshalException e) {
            throw new TransformerException(this, e);
        } catch (ValidationException e) {
            throw new TransformerException(this, e);
        }
        return object;
	}

}
