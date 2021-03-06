/*
 	Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved.
	
	This program and the accompanying materials are made available under the
	terms of the Eclipse Public License v. 2.0, which is available at
	http://www.eclipse.org/legal/epl-2.0.
	
	This Source Code may also be made available under the following Secondary
	Licenses when the conditions for such availability set forth in the
	Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
	version 2 with the GNU Classpath Exception, which is available at
	https://www.gnu.org/software/classpath/license.html.
	
	SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
*/

package webservices.simple_jaxb;
 
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

// import java content classes generated by binding compiler
import primer.po.*;
 
public class UnmarshalRead {
    
    // This sample application demonstrates how to unmarshal an instance
    // document into a Java content tree and access data contained within it.
    
    public static void main( String[] args ) {
        try {
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance( "primer.po" );
            
            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            
            // unmarshal a po instance document into a tree of Java content
            // objects composed of classes from the primer.po package.
            JAXBElement<?> poElement = (JAXBElement<?>)u.unmarshal( new File( "po.xml" ) );
            PurchaseOrderType po = (PurchaseOrderType)poElement.getValue();
            
            // examine some of the content in the PurchaseOrder
            System.out.println( "Ship the following items to: " );
            
            // display the shipping address
            USAddress address = po.getShipTo();
            displayAddress( address );
            
            // display the items
            Items items = po.getItems();
            displayItems( items );
            
        } catch( JAXBException je ) {
            je.printStackTrace();
        }
    }
    
    public static void displayAddress( USAddress address ) {
        // display the address
        System.out.println( "\t" + address.getName() );
	name = address.getName();
        System.out.println( "\t" + address.getStreet() ); 
        System.out.println( "\t" + address.getCity() +
                            ", " + address.getState() + 
                            " "  + address.getZip() ); 
        System.out.println( "\t" + address.getCountry() + "\n"); 
    }
    
    public static void displayItems( Items items ) {
        // the items object contains a List of primer.po.ItemType objects
        List itemTypeList = items.getItem();

                
        // iterate over List
        for( Iterator iter = itemTypeList.iterator(); iter.hasNext(); ) {
            Items.Item item = (Items.Item)iter.next(); 
            System.out.println( "\t" + item.getQuantity() +
                                " copies of \"" + item.getProductName() +
                                "\"" ); 
        }
    }

    public static String getName() {
	if (name == null) {
		main(null);
	}
	return name;
    }
   
    private static String name;
}
