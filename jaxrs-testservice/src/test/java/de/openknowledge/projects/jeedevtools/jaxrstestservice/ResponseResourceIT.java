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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

/**
 * Integration test for the resource {@link ResponseResource}.
 */
class ResponseResourceIT extends AbstractIntegrationTest {

  private static final Logger LOG = LoggerFactory.getLogger(ResponseResourceIT.class);

  private static RequestSpecification requestSpecification;

  @BeforeAll
  static void setUpUri() {
    APPLICATION.withLogConsumer(new Slf4jLogConsumer(LOG));

    requestSpecification = new RequestSpecBuilder()
        .setPort(APPLICATION.getFirstMappedPort())
        .build();
  }

  @Test
  void getResponseForStatusCode200() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 200)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.OK.getStatusCode());
  }

  @Test
  void getResponseForStatusCode400() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 400)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
  }

  @Test
  void getResponseForStatusCode401() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 401)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.UNAUTHORIZED.getStatusCode());
  }

  @Test
  void getResponseForStatusCode403() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 403)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.FORBIDDEN.getStatusCode());
  }

  @Test
  void getResponseForStatusCode404() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 404)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.NOT_FOUND.getStatusCode());
  }

  @Test
  void getResponseForStatusCode405() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 405)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.METHOD_NOT_ALLOWED.getStatusCode());
  }

  @Test
  void getResponseForStatusCode408() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 408)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.REQUEST_TIMEOUT.getStatusCode());
  }

  @Test
  void getResponseForStatusCode415() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 415)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.UNSUPPORTED_MEDIA_TYPE.getStatusCode());
  }

  @Test
  void getResponseForStatusCode422() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 422)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(422);
  }

  @Test
  void getResponseForStatusCode500() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 500)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
  }

  @Test
  void getResponseForStatusCode501() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 501)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.NOT_IMPLEMENTED.getStatusCode());
  }

  @Test
  void getResponseForStatusCode502() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 502)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.BAD_GATEWAY.getStatusCode());
  }

  @Test
  void getResponseForStatusCode503() {
    RestAssured.given(requestSpecification)
        .accept(MediaType.APPLICATION_JSON)
        .pathParam("statusCode", 503)
        .when()
        .get("/api/responses/{statusCode}")
        .then()
        .statusCode(Response.Status.SERVICE_UNAVAILABLE.getStatusCode());
  }
}
