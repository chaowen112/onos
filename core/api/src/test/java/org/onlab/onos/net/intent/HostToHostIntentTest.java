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
import org.onlab.onos.TestApplicationId;
import org.onlab.onos.core.ApplicationId;
import org.onlab.onos.net.HostId;
import org.onlab.onos.net.flow.TrafficSelector;

import com.google.common.testing.EqualsTester;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.onlab.junit.ImmutableClassChecker.assertThatClassIsImmutable;
import static org.onlab.onos.net.NetTestTools.APP_ID;
import static org.onlab.onos.net.NetTestTools.hid;

/**
 * Unit tests for the HostToHostIntent class.
 */
public class HostToHostIntentTest extends IntentTest {
    private final TrafficSelector selector = new IntentTestsMocks.MockSelector();
    private final IntentTestsMocks.MockTreatment treatment = new IntentTestsMocks.MockTreatment();
    private final HostId id1 = hid("12:34:56:78:91:ab/1");
    private final HostId id2 = hid("12:34:56:78:92:ab/1");
    private final HostId id3 = hid("12:34:56:78:93:ab/1");

    private static final ApplicationId APPID = new TestApplicationId("foo");

    private HostToHostIntent makeHostToHost(HostId one, HostId two) {
        return new HostToHostIntent(APPID, one, two, selector, treatment);
    }

    /**
     * Tests the equals() method where two HostToHostIntents have references
     * to the same hosts. These should compare equal.
     */
    @Test
    public void testSameEquals() {

        HostId one = hid("00:00:00:00:00:01/-1");
        HostId two = hid("00:00:00:00:00:02/-1");
        HostToHostIntent i1 = makeHostToHost(one, two);
        HostToHostIntent i2 = makeHostToHost(one, two);

        assertThat(i1.one(), is(equalTo(i2.one())));
        assertThat(i1.two(), is(equalTo(i2.two())));
    }

    /**
     * Checks that the HostToHostIntent class is immutable.
     */
    @Test
    public void testImmutability() {
        assertThatClassIsImmutable(HostToHostIntent.class);
    }

    /**
     * Tests equals(), hashCode() and toString() methods.
     */
    @Test
    public void testEquals() {
        final HostToHostIntent intent1 = new HostToHostIntent(APP_ID,
                id1,
                id2,
                selector,
                treatment);

        final HostToHostIntent intent2 = new HostToHostIntent(APP_ID,
                id2,
                id3,
                selector,
                treatment);

        new EqualsTester()
                .addEqualityGroup(intent1)
                .addEqualityGroup(intent2)
                .testEquals();
    }

    @Override
    protected Intent createOne() {
        return new HostToHostIntent(APP_ID, id1, id2, selector, treatment);
    }

    @Override
    protected Intent createAnother() {
        return new HostToHostIntent(APP_ID, id1, id3, selector, treatment);
    }
}
