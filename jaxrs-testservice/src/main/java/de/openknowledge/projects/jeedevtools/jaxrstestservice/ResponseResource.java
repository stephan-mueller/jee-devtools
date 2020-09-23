/*
 * Copyright (C) open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.openknowledge.projects.jeedevtools.jaxrstestservice;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A resource that provides responses with a given status code.
 */
@Path("responses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResponseResource {

  private static final Logger LOG = LoggerFactory.getLogger(ResponseResource.class);

  @GET
  @Path("{statusCode}")
  @Operation(description = "Response")
  public Response getResponse(@Parameter(description = "statusCode") @PathParam("statusCode") final int statusCode) {
    LOG.info("Get response with status code {}", statusCode);

    Response.ResponseBuilder builder;

    Response.Status status = Response.Status.fromStatusCode(statusCode);
    if (status != null) {
      builder = Response.status(status);
    } else {
      builder = Response.status(statusCode);
    }

    return builder.build();
  }
}
