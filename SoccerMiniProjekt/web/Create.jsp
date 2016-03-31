<%-- 
    Document   : create
    Created on : Feb 25, 2016, 11:16:12 AM
    Author     : Thesoap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <table>
              <col width="300">
              <col width="300">             
              <col width="300">
              <col width="300">
              
            <td>

            <form action="Createctrl">
                <h2>Add player</h2>
            Name:<br>
            <input type="text" name="name"><br>
            Playernumber:<br>
            <input type="text" name="playernumber"><br>
            TeamID:<br>
            <input type="text" name="teamid"><br>
            <select name="position">
                <option>GK</option>
                <option>DFF</option>
                <option>ATT</option>
                <option>MF</option>
            </select>
            <input type="submit" name="dothis" value="addplayer">
            </form>
            </td>
            
            
            <td>
            <form action="Createctrl">
            <h2>Add match</h2>
            Hometeam:<br>
            <input type="text" name="team1"><br>
            Awayteam:<br>
            <input type="text" name="team2"><br>
            <input type="submit" name="dothis" value="match">
            </form>
            </td>
            
            
            <td>
            <form action="Createctrl">
            <h2>Add goal</h2>
            Player:<br>
            <input type="text" name="player"><br>
            Match:<br>
            <input type="text" name="match"><br>
            <input type="submit" name="dothis" value="addgoal">
            </form>
            </td>
            
            
            <td>
            <form action="Createctrl">
            <h2>Update goal</h2>
            Goal:<br>
            <input type="text" name="goal"><br>
            Player:<br>
            <input type="text" name="player"><br>
            <input type="submit" name="dothis" value="updategoal">
            </form>
            </td>
            
            
            <td>
            <form action="Createctrl">
            <h2>Delete goal</h2>
            Goal:<br>
            <input type="text" name="goal"><br>
            <input type="submit" name="dothis" value="deletegoal">
            </form>
            </td>
            </table>
    </body>
</html>
