/*
 * Copyright 2014 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onlab.onos.net.intent;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutableBaseClass;

/**
 * Suite of tests of the point-to-point intent descriptor.
 */
public class PointToPointIntentTest extends ConnectivityIntentTest {

    /**
     * Checks that the MultiPointToSinglePointIntent class is immutable.
     */
    @Test
    public void checkImmutability() {
        assertThatClassIsImmutableBaseClass(PointToPointIntent.class);
    }

    @Test
    public void basics() {
        PointToPointIntent intent = createOne();
        assertEquals("incorrect id", APPID, intent.appId());
        assertEquals("incorrect match", MATCH, intent.selector());
        assertEquals("incorrect ingress", P1, intent.ingressPoint());
        assertEquals("incorrect egress", P2, intent.egressPoint());
    }

    @Override
    protected PointToPointIntent createOne() {
        return new PointToPointIntent(APPID, MATCH, NOP, P1, P2);
    }

    @Override
    protected PointToPointIntent createAnother() {
        return new PointToPointIntent(APPID, MATCH, NOP, P2, P1);
    }
}
