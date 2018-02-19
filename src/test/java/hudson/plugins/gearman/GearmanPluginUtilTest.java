/*
 *
 * Copyright 2013 Hewlett-Packard Development Company, L.P.
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
 *
 */

package hudson.plugins.gearman;

import hudson.slaves.DumbSlave;
import jenkins.model.Jenkins;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import static org.junit.Assert.assertEquals;

/**
 * Test for the {@link GearmanPluginUtil} class.
 *
 * @author Khai Do
 */
public class GearmanPluginUtilTest {

    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    public void testGetRealNameSlave() throws Exception {
        DumbSlave slave = j.createOnlineSlave();

        // createOnlineSlave sets the slave name to slave0. Do not change
        // this with setNodeName as the name is supposed to be immutable
        // except when cloning a preexisting slave.
        assertEquals("slave0", GearmanPluginUtil.getRealName(slave.toComputer()));
        j.getInstance().removeNode(slave);
    }

    @Test
    public void testGetRealNameMaster() throws Exception {

        assertEquals("master", GearmanPluginUtil.getRealName(Jenkins.getInstance().getComputer("")));
    }

}
