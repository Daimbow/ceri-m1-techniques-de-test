# UCE Génie Logiciel Avancé : Techniques de tests

## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.

## Informations supplémentaires

- Nom, prénom : JAMME Julien
- Groupe : Alternance / ILSEN M1
- Badge CircleCI : [![CircleCI](https://dl.circleci.com/status-badge/img/gh/Daimbow/ceri-m1-techniques-de-test/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/Daimbow/ceri-m1-techniques-de-test/tree/master)
- Badge couverture de test : [![codecov](https://codecov.io/gh/Daimbow/ceri-m1-techniques-de-test/graph/badge.svg?token=ITXLY2VFN4)](https://codecov.io/gh/Daimbow/ceri-m1-techniques-de-test)


![codecov](https://codecov.io/gh/Daimbow/ceri-m1-techniques-de-test/graphs/sunburst.svg?token=ITXLY2VFN4)


## Rapports

Le rapport checkstyle.xml se trouve dans circleCI dans le l'onglet Artifcats sur le build 


## Rapport TP6

Cette classe présente plusieurs problèmes causés par la Team Rocket. 
La gestion des index des Pokémon est incorrecte : les index valides doivent être compris entre 0 et 150 et toute valeur en dehors de cet intervalle devrait déclencher une erreur. 
De plus la génération aléatoire des statistiques telles que la stamina, la défense et l'attaque, peut produire des valeurs négatives, ce qui est invalide. 
La gestion des Pokémon utilise une implémentation non modifiable, ce qui limite l'évolutivité tout en introduisant des risques si de nouvelles entrées doivent être ajoutées dynamiquement.
Il y a un manque documentation dans la classe Rocket.
Pour remédier à ces problèmes, j'ai mis en place des tests dans la classe IPokemonFactoryTest, en suivant une approche TDD. 
Ces tests serviront de base pour l’implémentation future de la classe RocketPokemonFactory, permettant ainsi aux développeurs de corriger les erreurs tout en respectant les contraintes définies.