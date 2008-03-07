/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.transformers.xml.xquery.i18n;

import org.mule.config.i18n.MessageFactory;
import org.mule.config.i18n.Message;

/**
 * I18n messages for the XQuery Module
 */
public class XQueryMessages extends MessageFactory
{
    private static final String BUNDLE_PATH = getBundlePath("xquery");

    public static Message streamNotAvailble(String transformerName)
    {
        return createMessage(BUNDLE_PATH, 1, transformerName);
    }

    public static Message objectNotAvailble(String transformerName)
    {
        return createMessage(BUNDLE_PATH, 2, transformerName);
    }
}
