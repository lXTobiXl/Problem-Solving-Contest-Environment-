<%@page import="java.util.Arrays"%>
<%@page import="JSPSide.Problem, JSPSide.Standing"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="JSPSide.Team"%>
<%@page import="java.util.ArrayList, java.util.List, java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Standings</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body class="container">
        
        <div class="card-header" style="font-family: Roboto, sans-serif; display: flex;">
            <span style="font-weight: bold;">Standing</span> 
            <span class="link" style="margin-left: auto;"><a href="Clarification">Clarification</a></span>
            <span class="link"><a href="Problems">Problems</a></span>
            <span class="link">2019</span>

        </div>

        <%
            int nProblems = Standing.getNumberOfProblems();
            int flag[] = new int[nProblems];
            boolean f2[] = new boolean[nProblems];
            char c;
        %>
        <table   class="scoreboard" cellspacing="2" cellpadding="2">
            <thead>
            <tr class="scoreheader" >
                <th title="rank" scope="col">Rank</th>
                <th title="team name" scope="col">Team Name</th>
                <th title="solved" scope="col" colspan="2" >Solved / Time</th>
                    <% for (int i = 0; i < nProblems; i++) {%>
                <th scope="col"><%=(char) (i + 65)%></th>                       
                    <%}%> 
            </tr>
            </thead>
            <% List<Team> allTeams = (List<Team>) request.getAttribute("data");
               int count = 1;
               for (Team t : allTeams) {
            %>    
            <tr class="sortorderswitch">
                <td class="scorepl" ><%= count%></td>
                <td class="scoretn" ><%=t.getTeamName()%></td>
                <td class="scorenc" ><%=t.getCountAcceptedSolutions()%></td>
                <td class="scorett" ><%=t.getTimePenality()%></td>

                <%
                    Set<Map.Entry<Character, Problem>> hshUni = t.getProblems().entrySet();
                    Iterator<Map.Entry<Character, Problem>> HMIterator = hshUni.iterator();
                    flag = new int[nProblems];
                    f2 = new boolean[nProblems];

                    while (HMIterator.hasNext()) {
                        Map.Entry<Character, Problem> entry = HMIterator.next();
                        c = entry.getKey();
                        flag[((int)c - 65)] = entry.getValue().getTriedCount();
                        f2[((int)c - 65)] = entry.getValue().getState();
                    }

                    for (int i = 0; i < flag.length; i++) {
                        if (flag[i] != 0) {
                            if(f2[i]){%>
                                <td class="score_cell score_correct"><%=flag[i]%></td>
                            <%}else{%>
                                <td class="score_cell score_incorrect"><%=flag[i]%></td>
                            <% } %>    
                            
                        <%} else {%>
                         <td class="score_cell score_neutral"> </td>
                        <%}
                    }%>  
            </tr>
            <%count++;}%>
        </table>
        
        <p><br /><br /></p>
		<table id="cell_legend" class="scoreboard scorelegend">
			<thead>
				<tr>
					<th scope="col">Cell colours</th>
				</tr>
			</thead>
			<tbody>
				<!--<tr class="score_first">
					<td>Solved first</td>
				</tr>-->
				<tr class="score_correct">
					<td>Solved</td>
				</tr>
				<tr class="score_incorrect">
					<td>Tried, incorrect</td>
				</tr>
				<!--<tr class="score_pending">
					<td>Tried, pending</td>
				</tr>-->
				<tr class="score_neutral">
					<td>Untried</td>
				</tr>
			</tbody>
		</table>
        
    </body>
</html>
