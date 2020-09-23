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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

/**
 * Test class for the resource {@link ResponseResource}.
 */
class ResponseResourceTest {

  private ResponseResource resource;

  @BeforeEach
  void setUp() {
    resource = new ResponseResource();
  }

  @Test
  void getResponseForStatusCode200() {
    Response response = resource.getResponse(200);
    assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
  }

  @Test
  void getResponseForStatusCode400() {
    Response response = resource.getResponse(400);
    assertThat(response.getStatus()).isEqualTo(Response.Status.BAD_REQUEST.getStatusCode());
  }

  @Test
  void getResponseForStatusCode401() {
    Response response = resource.getResponse(401);
    assertThat(response.getStatus()).isEqualTo(Response.Status.UNAUTHORIZED.getStatusCode());
  }

  @Test
  void getResponseForStatusCode403() {
    Response response = resource.getResponse(403);
    assertThat(response.getStatus()).isEqualTo(Response.Status.FORBIDDEN.getStatusCode());
  }

  @Test
  void getResponseForStatusCode404() {
    Response response = resource.getResponse(404);
    assertThat(response.getStatus()).isEqualTo(Response.Status.NOT_FOUND.getStatusCode());
  }
  @Test
  void getResponseForStatusCode405() {
    Response response = resource.getResponse(405);
    assertThat(response.getStatus()).isEqualTo(Response.Status.METHOD_NOT_ALLOWED.getStatusCode());
  }

  @Test
  void getResponseForStatusCode408() {
    Response response = resource.getResponse(408);
    assertThat(response.getStatus()).isEqualTo(Response.Status.REQUEST_TIMEOUT.getStatusCode());
  }

  @Test
  void getResponseForStatusCode415() {
    Response response = resource.getResponse(415);
    assertThat(response.getStatus()).isEqualTo(Response.Status.UNSUPPORTED_MEDIA_TYPE.getStatusCode());
  }

  @Test
  void getResponseForStatusCode422() {
    Response response = resource.getResponse(422);
    assertThat(response.getStatus()).isEqualTo(422);
  }

  @Test
  void getResponseForStatusCode500() {
    Response response = resource.getResponse(500);
    assertThat(response.getStatus()).isEqualTo(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
  }

  @Test
  void getResponseForStatusCode501() {
    Response response = resource.getResponse(501);
    assertThat(response.getStatus()).isEqualTo(Response.Status.NOT_IMPLEMENTED.getStatusCode());
  }

  @Test
  void getResponseForStatusCode502() {
    Response response = resource.getResponse(502);
    assertThat(response.getStatus()).isEqualTo(Response.Status.BAD_GATEWAY.getStatusCode());
  }

  @Test
  void getResponseForStatusCode503() {
    Response response = resource.getResponse(503);
    assertThat(response.getStatus()).isEqualTo(Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
  }
}
