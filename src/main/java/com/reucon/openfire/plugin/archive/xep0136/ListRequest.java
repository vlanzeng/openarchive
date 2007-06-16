package com.reucon.openfire.plugin.archive.xep0136;

import com.reucon.openfire.plugin.archive.util.DateUtil;
import com.reucon.openfire.plugin.archive.XmppResultSet;
import org.dom4j.Element;
import org.dom4j.QName;

import java.util.Date;

/**
 * A request to retrieve a list of collections.
 */
public class ListRequest
{
    private String with;
    private Date start;
    private Date end;

    private XmppResultSet resultSet;

    public ListRequest(Element listElement)
    {
        if (listElement.attribute("with") != null)
        {
            this.with = listElement.attributeValue("with");
        }
        if (listElement.attribute("start") != null)
        {
            this.start = DateUtil.parseDate(listElement.attributeValue("start"));
        }
        if (listElement.attribute("end") != null)
        {
            this.end = DateUtil.parseDate(listElement.attributeValue("end"));
        }

        Element setElement = listElement.element(QName.get("set", "http://jabber.org/protocol/rsm"));
        if (setElement != null)
        {
            resultSet = new XmppResultSet(setElement);
        }
    }

    public String getWith()
    {
        return with;
    }

    public Date getStart()
    {
        return start;
    }

    public Date getEnd()
    {
        return end;
    }

    public XmppResultSet getResultSet()
    {
        return resultSet;
    }
}
