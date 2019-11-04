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

package web.servlet.dynamicregistration_war;

import javax.servlet.*;

public class TestServletRequestListener implements ServletRequestListener {

    /**
     * Receives notification that a request is about to enter the scope
     * of the web application.
     *
     * @param sre The ServletRequestEvent
     */
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletRequest().setAttribute("listenerAttributeName",
            "listenerAttributeValue");
    }
    
    /**
     * Receives notification that a request is about to leave the scope
     * of the web application.
     *
     * @param sre The ServletRequestEvent
     */
    public void requestDestroyed(ServletRequestEvent sre) {
        // Do nothing
    }

}
