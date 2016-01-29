/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
+ * KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
+ * under the License.
 */

package com.example.engine.internal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.messaging.TransportSender;

/**
 * Created by senduran on 12/19/15.
 */
@Component(
        name = "com.example.engine.internal.EchoServiceComponent",
        immediate = true
)
public class EchoServiceComponent {
    @Reference(
            name = "transport-sender",
            service = TransportSender.class,
            cardinality = ReferenceCardinality.OPTIONAL,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "removeTransportSender"
    )
    protected void addTransportSender(TransportSender transportSender) {
        EchoContextHolder.getInstance().addTransportSender(transportSender);
    }

    protected void removeTransportSender(TransportSender transportSender) {
        EchoContextHolder.getInstance().removeTransportSender(transportSender);
    }

 }
