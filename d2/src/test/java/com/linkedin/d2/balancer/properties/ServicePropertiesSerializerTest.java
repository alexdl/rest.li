/*
   Copyright (c) 2012 LinkedIn Corp.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.linkedin.d2.balancer.properties;

import static org.testng.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.Collections;

import com.linkedin.d2.discovery.PropertySerializationException;
import org.testng.annotations.Test;

public class ServicePropertiesSerializerTest
{
  public static void main(String[] args) throws URISyntaxException, PropertySerializationException
  {
    new ServicePropertiesSerializerTest().testServicePropertiesSerializer();
  }

  @Test(groups = { "small", "back-end" })
  public void testServicePropertiesSerializer() throws URISyntaxException,
          PropertySerializationException
  {
    ServicePropertiesJsonSerializer serializer = new ServicePropertiesJsonSerializer();

    ServiceProperties property =
        new ServiceProperties("servicename", "clustername", "/foo", "rr");
    assertEquals(serializer.fromBytes(serializer.toBytes(property)), property);

    property = new ServiceProperties("servicename2", "clustername2", "/path2", "strategy2", Collections.<String,Object>singletonMap("foo", "bar"));
    assertEquals(serializer.fromBytes(serializer.toBytes(property)), property);

/*
    property = new ServiceProperties("servicename", "clustername", "/foo", null);
    assertEquals(serializer.fromBytes(serializer.toBytes(property)), property);

    property = new ServiceProperties("servicename", "clustername", null, null);
    assertEquals(serializer.fromBytes(serializer.toBytes(property)), property);

    property = new ServiceProperties("servicename", null, null, null);
    assertEquals(serializer.fromBytes(serializer.toBytes(property)), property);
*/
  }
}
