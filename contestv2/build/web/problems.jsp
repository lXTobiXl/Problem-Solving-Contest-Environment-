<%@page import="problemsJSPSide.Problem"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Problems</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/x-mathjax-config">
            MathJax.Hub.Config({
            tex2jax: {inlineMath: [["$","$"],["\\(","\\)"]]}
            });
        </script>
        <script type="text/javascript" src="js/MathJax/MathJax.js?config=TeX-AMS_CHTML"></script>

        <link rel="icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body class="container">

        <div class="card-header" style="font-family: Roboto, sans-serif; display: flex;">
            <span style="font-weight: bold;">Problems</span> 
            <span class="link" style="margin-left: auto;"><a href="Clarification">Clarification</a></span>
            <span class="link"><a href="Standing">Standing</a></span>
            <span class="link">2019</span>

        </div>

        <table   class="scoreboard" cellspacing="2" cellpadding="2">
            <thead>
                <tr class="scoreheader" >
                    <th title="count" scope="col">ID</th>
                    <th title="time" scope="col" style="max-width: 15px;">Time Limit</th>
                    <th title="problem" scope="col">Problem</th>
                </tr>
            </thead>
            <% ArrayList<Problem> all = (ArrayList<Problem>) request.getAttribute("data");
                int count = 65;
                for (Problem p : all) {
            %>    
            <tr class="sortorderswitch">
                <td class="scorepl" ><%= (char) count%></td>
                <td class="scoretn" ><%=p.getTimelimit()%></td>
                <td class="scorenc" ><%=p.getProblem()%></td>
            </tr>
            <%count++;
                }%>
        </table>
    </body>
</html>
