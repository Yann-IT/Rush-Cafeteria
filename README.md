### Instructions

Ecrivez une fonction qui prend en paramètre un tableau de chaine de caractère et un deuxième tableau de chaine de caractère et un tableau d'int.

Le premier tableau correspondra à des prénoms des employés de la caféteria du MIT.

Le second tableau correspondra aux différentes sections de la caféria ( Lobby, Dining room, Kitchen).

Le tableau d'int sera interprété comme un jour de travail. 

But du programme MitCafeteria.java , il devra renvoyer un planning des employés par binome tout en les affectant à une section différente avec un partenaire différent pour chaque jour qui passe.

```java
exemple 

staff = ["Marcus", "Lateefa", "Donald", "Rashad", "Quincy", "Mia"]
cafeteria = ["Lobby", "Dining Room", "Kitchen"]
shifts = [0, 1, 2, 3, 4, 5, 6, 7]

OUTPUT ===> 

Day 00 : Lobby [ Marcus & Lateefa ] DR [ Donald & Rashad ] Kitchen [ Quincy & Mia ]
Day 01 : Lobby [ Donald & Quincy ] DR [ Marcus & Mia ] Kitchen [ Lateefa & Rashad ]
Day 02 : Lobby [ Mia & Rashad ] DR [ Lateefa & Quincy ] Kitchen [ Donald & Marcus ]
.....
.....
.....
.....
.....
Day XX : Lobby [ Marcus & Lateefa ] DR [ Donald & Rashad ] Kitchen [ Quincy & Mia ]
```