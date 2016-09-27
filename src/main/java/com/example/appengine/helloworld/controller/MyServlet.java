/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * COMMANDS:
 * cd C:\Users\3299779\IdeaProjects\java-docs-samples\appengine\helloworld
 * mvn appengine:update
 */

package com.example.appengine.helloworld.controller;


import com.example.appengine.helloworld.dao.account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {

  private String word = null;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    boolean isRegistered = false;
    Scanner input = new Scanner(new File("data/login.txt"));
    word = request.getParameter("textarea");
    String button = request.getParameter("btn");

    int cue = 0;

    while (input.hasNextLine() && button == null) {

      String next = input.nextLine();
      account acc = new account();

      if (next.contains(request.getParameter("username")) &&
              next.contains(request.getParameter("password")) &&
              next.contains("user")) {

        acc.name = request.getParameter("username");
        acc.pass = request.getParameter("password");
        acc.role = "user";

        isRegistered = true;
        cue = 1;
      }

      else if (next.contains(request.getParameter("username")) &&
              next.contains(request.getParameter("password")) &&
              next.contains("admin")) {

        acc.name = request.getParameter("username");
        acc.pass = request.getParameter("password");
        acc.role = "admin";

        isRegistered = true;
        cue = 2;
      }

      if (!isRegistered) {
        cue = 3;
      }

    }

      if (cue == 1) {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Using POST Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>Username</b>: "
                + request.getParameter("username") + "\n" +
                "  <li><b>Password</b>: "
                + request.getParameter("password") + "\n" +
                "  <li><b>Textarea</b>: "
                + word + "\n" +
                "</ul>\n" +
                "<a href=\"index.jsp\">" +
                "<input type=\"submit\" name=\"backBtn\" value=\"back\">" +
                "</a>" + "\n" +
                "</body></html>");
      }

      if (cue == 2) {

        RequestDispatcher dispatch2 = request.getRequestDispatcher("jsp/home.jsp");

        dispatch2.forward(request, response);
      }

      if (cue == 3) {
        RequestDispatcher dispatch3 = request.getRequestDispatcher("jsp/index.jsp");

        dispatch3.forward(request, response);
      }
    }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    word = request.getParameter("textarea");
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    String title = "Using POST Method to Read Form Data";
    String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " +
                    "transitional//en\">\n";
    out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor=\"#f0f0f0\">\n" +
            "<h1 align=\"center\">" + title + "</h1>\n" +
            "<ul>\n" +
            "  <li><b>Textarea</b>: "
            + word + "\n" +
            "</ul>\n" +
            "<a href=\"index.jsp\">" +
            "<input type=\"submit\" name=\"backBtn\" value=\"back\">" +
            "</a>" + "\n" +
            "</body></html>");
  }
}

