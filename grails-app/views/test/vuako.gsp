<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>
    <table border="1px">
        <tr>
            <th> </th>
            <th> </th>
        </tr>
    <g:each var="joueur" in="${testVar}" status="i">
        <tr>
            <td> ${joueur.id} ${testa}</td>
            <td> ${joueur.nom}</td>
        </tr>
    </g:each>
    </table>
</body>
</html>