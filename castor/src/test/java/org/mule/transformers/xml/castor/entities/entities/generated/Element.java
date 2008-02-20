/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.2</a>, using an XML
 * Schema.
 * $Id$
 */

package org.mule.transformers.xml.castor.entities.entities.generated;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class Element.
 * 
 * @version $Revision$ $Date$
 */
public class Element implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _age.
     */
    private short _age;

    /**
     * keeps track of state for field: _age
     */
    private boolean _has_age;

    /**
     * Field _extendedName.
     */
    private java.lang.String _extendedName;


      //----------------/
     //- Constructors -/
    //----------------/

    public Element() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     */
    public void deleteAge(
    ) {
        this._has_age= false;
    }

    /**
     * Returns the value of field 'age'.
     * 
     * @return the value of field 'Age'.
     */
    public short getAge(
    ) {
        return this._age;
    }

    /**
     * Returns the value of field 'extendedName'.
     * 
     * @return the value of field 'ExtendedName'.
     */
    public java.lang.String getExtendedName(
    ) {
        return this._extendedName;
    }

    /**
     * Method hasAge.
     * 
     * @return true if at least one Age has been added
     */
    public boolean hasAge(
    ) {
        return this._has_age;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'age'.
     * 
     * @param age the value of field 'age'.
     */
    public void setAge(
            final short age) {
        this._age = age;
        this._has_age = true;
    }

    /**
     * Sets the value of field 'extendedName'.
     * 
     * @param extendedName the value of field 'extendedName'.
     */
    public void setExtendedName(
            final java.lang.String extendedName) {
        this._extendedName = extendedName;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled xml.mule.generated.Element
     */
    public static org.mule.transformers.xml.castor.entities.entities.generated.Element unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (org.mule.transformers.xml.castor.entities.entities.generated.Element)
           Unmarshaller.unmarshal(org.mule.transformers.xml.castor.entities.entities.generated.Element.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Element other = (Element) obj;
        if (_age != other._age)
            return false;
        if (_extendedName == null) {
            if (other._extendedName != null)
                return false;
        } else if (!_extendedName.equals(other._extendedName))
            return false;
        if (_has_age != other._has_age)
            return false;
        return true;
    }
    
    

}
