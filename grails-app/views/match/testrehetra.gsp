<!DOCTYPE html>
<html lang="en">
<head>

    <title>VSJoueur</title>

</head><!--/head-->

<body>
    <header id="header"><!--header-->

    </header><!--/header-->

    <section id="form"><!--form-->


    Envoye Message --------------------
    <form action="http://localhost:8080/message/envoyerMessage" method="POST">
        ID ANLE JOUEUR iray <input type="text" name="idAutreJoueur" /> <br><br>
    <input type="text" name="message"/>
        <input type="submit" value="envoyer"/>
    </form>

    <br><br><br><br><br><br>

    Vue Message --------------------
    <form action="http://localhost:8080/message/vueMessage" method="POST">
        ID ANLE message atao vue <input type="text" name="idMessage" /><br><br>
        <input type="submit" value="Voir"/>
    </form>

    <br><br><br><br><br><br>

    Liste Message --------------------
    <form action="http://localhost:8080/message/listeMessage" method="POST">
        ID ANLE JOUEUR iray <input type="text" name="idAutreJoueur" /><br><br>
        <input type="submit" value="Liste"/>
    </form>

    <br><br><br><br><br><br>

    Login Admin --------------------
    <form action="http://localhost:8080/admin/authentification" method="POST">
        username <input type="text" name="username" /><br><br>
        Mot de passe <input type="text" name="motDePasse" /><br><br>
        <input type="submit" value="Liste"/>
    </form>

</section><!--/form-->


    <footer id="footer"><!--Footer-->

    </footer><!--/Footer-->
</body>
</html>