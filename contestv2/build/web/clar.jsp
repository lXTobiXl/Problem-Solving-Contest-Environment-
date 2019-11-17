<%@page import="clarificationsJSPSide.Clarification"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList, java.util.List, java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Clarification</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="icon" href="img/favicon.ico"  type="image/x-icon">
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body class="container">

        <div class="card-header" style="font-family: Roboto, sans-serif; display: flex;">
            <span style="font-weight: bold;">Clarification</span> 
            <span class="link" style="margin-left: auto;"><a href="Standing">Standing</a></span>
            <span class="link"><a href="Problems">Problems</a></span>
            <span class="link">2019</span>

        </div>
        
        <table   class="scoreboard" cellspacing="2" cellpadding="2">
            <thead>
                <tr class="scoreheader" >
                    <th title="count" scope="col">Number</th>
                    <th title="question" scope="col">Question</th>
                    <th title="answer" scope="col">Answer</th>
                </tr>
            </thead>
            <% ArrayList<Clarification> all = (ArrayList<Clarification>) request.getAttribute("data");
                int count = 1;
                for (Clarification c : all) {
            %>    
            <tr class="sortorderswitch">
                <td class="scorepl" ><%= count%></td>
                <td class="scoretn" ><%=c.getQuestion()%></td>
                <td class="scorenc" ><%=c.getAnswer()%></td>
            </tr>
            <%count++;
                }%>
        </table>
    </body>
</html>
