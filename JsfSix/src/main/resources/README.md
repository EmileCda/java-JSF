[< précédent](../README.md)

# RedRose

sam. 06 mai 2023 11:01:24 CEST
RedRose

![Logo](./doc/images/Logo-defaut.png)

# Installation

1. Cloner le repository

# Qu'il a t-il sous le capot ?

1. [Java jdk-8u202-linux-x64](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
1. [apache maven project](https://maven.apache.org/)
1. [Mysql](https://www.mysql.com/fr/)

# Organisation du code

![organisation du code](./doc/images/organisation-code.png)

1. /src/main/java/fr/emile/RedRose/Main.java : Point d'entrée de l'application
1. /src/main/java/fr/emile/RedRose/entity/: Les Pojos et beans
1. /src/main/java/fr/emile/RedRose/common/: Les constantes commun au projet
1. /src/main/java/fr/emile/RedRose/entity/: Les Pojos et beans
1. /src/main/java/fr/emile/RedRose/enums/: Les types enumérés
1. /src/main/java/fr/emile/RedRose/model/connection: Les connexions vers l'extérieur
1. /src/main/java/fr/emile/RedRose/model/dao: Les class d'acces aux bases de données
1. /src/main/java/fr/emile/RedRose/utils: Les class utilitaires
1. /src/main/resources/ Les fichiers de ressources
1. /src/test/java/fr/emile/RedRose/ Les class de tests unitaire

# Spécification

1. [définition des entitées](./doc/entity-definition.md)
1. [User stories](./doc/user-stories.md)
1. [charte graphique](./doc/graphical-charter.md)
