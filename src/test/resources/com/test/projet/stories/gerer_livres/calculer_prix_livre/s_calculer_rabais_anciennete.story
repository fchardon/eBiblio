
Etant donné les Histoires:
com/test/projet/stories/gerer_livres/regles/regles_anciennete.story

Scénario: Calcul de prix avec 1 an d'ancienneté

Etant donné que nous sommes le 2016/10/01.
Etant donné que l'adhérent 123 existe.
Etant donné que mon adhérent est client depuis le 2015/01/01.
Quand l'adhérent emprunte un livre à 10 €.
Alors l'adhérent paye 9.9 €.

Scénario: Calcul de prix sans ancienneté

Etant donné que nous sommes le 2016/10/01.
Etant donné que l'adhérent 123 existe.
Etant donné que mon adhérent est client depuis le 2016/01/01.
Quand l'adhérent emprunte un livre à 10 €.
Alors l'adhérent paye 10 €.