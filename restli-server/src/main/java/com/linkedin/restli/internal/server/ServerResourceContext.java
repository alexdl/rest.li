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

/**
 * $Id: $
 */

package com.linkedin.restli.internal.server;

import java.net.URI;
import java.util.Map;

import com.linkedin.data.DataMap;
import com.linkedin.restli.server.ResourceContext;
import com.linkedin.restli.server.RestLiServiceException;

/**
 * Richer resource context used inside server framework
 *
 * @author Josh Walker
 * @version $Revision: $
 */

public interface ServerResourceContext extends ResourceContext
{
  /**
   * @return {@link DataMap} of request parameters.
   */
  DataMap getParameters();

  /**
   * @return request {@link URI}
   */
  URI getRequestURI();

  /**
   * @return rest.li request action name
   */
  String getRequestActionName();

  /**
   * @return rest.li request finder name
   */
  String getRequestFinderName();

  @Override
  MutablePathKeys getPathKeys();

  /**
   * @return response headers
   */
  Map<String, String> getResponseHeaders();

  /**
   * @return map of {@link RestLiServiceException}s keyed by batch key values
   */
  Map<String, RestLiServiceException> getBatchKeyErrors();

  /**
   * @return rest.li request method
   */
  String getRestLiRequestMethod();
}
