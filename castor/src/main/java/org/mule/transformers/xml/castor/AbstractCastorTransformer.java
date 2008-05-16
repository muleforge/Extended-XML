package org.mule.transformers.xml.castor;

import java.io.IOException;
import java.net.URL;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.XMLContext;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.transformer.AbstractTransformer;

public abstract class AbstractCastorTransformer extends AbstractTransformer{
    private XMLContext xmlContext;

    private URL mappingFile;

    public void initialise() throws InitialisationException {
        xmlContext = new XMLContext();
        if (getMappingFile() != null) {
            Mapping mapping = new Mapping();
            try {
                mapping.loadMapping(mappingFile);
                xmlContext.addMapping(mapping);
            } catch (IOException e) {
                throw new InitialisationException(e, this);
            } catch (MappingException e) {
                throw new InitialisationException(e, this);
            }
        }
    }

    public XMLContext getXMLContext() {
        return xmlContext;
    }

    public URL getMappingFile() {
        return mappingFile;
    }

    public void setMappingFile(URL mappingFile) {
        if (mappingFile != null) {
            logger.debug("Loading XML mapping from URL " + mappingFile.toExternalForm());
        }
        this.mappingFile = mappingFile;
    }

}
