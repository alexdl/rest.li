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

package com.linkedin.restli.server;

import com.linkedin.restli.internal.server.methods.response.ErrorResponseBuilder;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Configuration for rest.li servers.
 *
 * @author dellamag
 */
public class RestLiConfig
{
  private final Set<String> _resourcePackageNames = new HashSet<String>();
  private final Set<String> _resourceClassNames = new HashSet<String>();
  private URI _serverNodeUri = URI.create("");
  private RestLiDocumentationRequestHandler _documentationRequestHandler = null;
  private ErrorResponseFormat _errorResponseFormat = ErrorResponseFormat.FULL;
  private String _internalErrorMessage = ErrorResponseBuilder.DEFAULT_INTERNAL_ERROR_MESSAGE;
  private boolean _permissiveEncoding = false;

  /**
   * Constructor.
   */
  public RestLiConfig()
  {
    this (Collections.<String, Object>emptyMap());
  }

  /**
   * @param mapConfig not currently used
   */
  public RestLiConfig(final Map<String, Object> mapConfig)
  {
  }

  public Set<String> getResourcePackageNamesSet()
  {
    return Collections.unmodifiableSet(_resourcePackageNames);
  }

  public Set<String> getResourceClassNamesSet()
  {
    return Collections.unmodifiableSet(_resourceClassNames);
  }

  /**
   * @param commaDelimitedResourcePackageNames comma-delimited package names list
   */
  public void setResourcePackageNames(final String commaDelimitedResourcePackageNames)
  {
    if (commaDelimitedResourcePackageNames != null &&
        ! "".equals(commaDelimitedResourcePackageNames.trim()))
    {
      _resourcePackageNames.clear();
      addResourcePackageNames(commaDelimitedResourcePackageNames.split(","));
    }
  }

  /**
   * @param packageNames set of package names to be scanned
   */
  public void setResourcePackageNamesSet(final Set<String> packageNames)
  {
    if (packageNames != null && !packageNames.isEmpty())
    {
      _resourcePackageNames.clear();
      _resourcePackageNames.addAll(packageNames);
    }
  }

  /**
   * @param packageNames collection of package names to be scanned
   */
  public void addResourcePackageNames(final Collection<String> packageNames)
  {
    _resourcePackageNames.addAll(packageNames);
  }

  /**
   * @param packageNames array of package names to be scanned
   */
  public void addResourcePackageNames(final String... packageNames)
  {
    _resourcePackageNames.addAll(Arrays.asList(packageNames));
  }

  /**
   * @param classNames set of class names to be loaded
   */
  public void setResourceClassNamesSet(final Set<String> classNames)
  {
    if (classNames != null && !classNames.isEmpty())
    {
      _resourceClassNames.clear();
      _resourceClassNames.addAll(classNames);
    }
  }

  /**
   * @param classNames collection of specific resource class names to be loaded
   */
  public void addResourceClassNames(final Collection<String> classNames)
  {
    _resourceClassNames.addAll(classNames);
  }

  /**
   * @param classNames array of specific resource class names to be loaded
   */
  public void addResourceClassNames(final String... classNames)
  {
    _resourceClassNames.addAll(Arrays.asList(classNames));
  }

  public URI getServerNodeUri()
  {
    return _serverNodeUri;
  }

  public void setServerNodeUri(final URI serverNodeUri)
  {
    _serverNodeUri = serverNodeUri;
  }

  public RestLiDocumentationRequestHandler getDocumentationRequestHandler()
  {
    return _documentationRequestHandler;
  }

  public void setDocumentationRequestHandler(final RestLiDocumentationRequestHandler handler)
  {
    _documentationRequestHandler = handler;
  }

  public ErrorResponseFormat getErrorResponseFormat()
  {
    return _errorResponseFormat;
  }

  public void setErrorResponseFormat(ErrorResponseFormat errorResponseFormat)
  {
    this._errorResponseFormat = errorResponseFormat;
  }

  public String getInternalErrorMessage()
  {
    return _internalErrorMessage;
  }

  public void setInternalErrorMessage(String internalErrorMessage)
  {
    _internalErrorMessage = internalErrorMessage;
  }

  public boolean getPermissiveEncoding()
  {
    return _permissiveEncoding;
  }

  public void setPermissiveEncoding(boolean permissiveEncoding)
  {
    _permissiveEncoding = permissiveEncoding;
  }
}
