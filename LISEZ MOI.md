
============== Dimensions Scalable Android (DSA) , for the Android Design guidelines. By CodingZip(Drex) ========================
 version: 1.0
==============
________________le ficher jar exécutable ou .exe se trouve dans le répertoire -> Executable Jar or exe <-_____________________

DSA est un générateur de fichier xml qui fournit des unité de taille évolutifs pour différentes taille d'écrans.

cet outils a pour but de générer plusieurs ou un seul fichier xml de dimension pour une mise à l'échelle
tout en le plaçant dans le dossier correspondant (values-sw<N>dp) pour vos projets Android.

#pour l'utilisation dans vos projets lire fichiers -> COMMENT UTILISEZ DSA
================================================================================================================================

Avec **Dimensions Scalable Android**, vous pouvez :

- Sélectionner et dupliquer votre propre fichier xml existant comme départ pour une nouvelles mise à l'échelle avec une nouvelle valeurs spécifier par vous-mêmes.
***NB: Veuillez désélectionné la case à cocher "utiliser les valeurs par"
défaut pour avoir la possibilité de localisé votre propre ficher xml comme source de départ. 


- Commencer de zero en générer un fichier xml avec les valeurs par défaut déjà prédéfinis dans l'outil.

- Choisir le répertoire de destinations (sortie) ou seras directement copier vôtre nouvelles valeurs (soit directement dans le dossier src/ de vôtre projet).
  afin de ne pas avoir à les déplacer manuellement.

- Générer plusieurs fichier xml à la fois.


*********** Si vous générer les fichiers xml en utilisant les valeurs par défaut de l'outil vous bénéficierai :**************************

-des valeus en dp ,sp ,px compris chacun entre (0 et 1000 pour les valeurs positifs) et (0 et -1000 pour les valeurs négatifs) 
que vous pourrez utiliser ainsi: @dimen/dp_50_dsa ou @dimen/dp_50_minus_dsa

-aussi des valeurs par défaut utilser pour le material design dans le xml généré.
****************************************************************************************************************************************

-----------ATTENTION: -------------------------------------------------------------------------------------------------------------------
Dans la plupart des cas, vous devez toujours concevoir une mise en page différentes (layout) pour chaque dossier (values-sw<N>dp) créé.
exemple pour un : (values-sw480dp) -> (layout-sw480dp)
------------------------------------------------------------------------------------------------------------------------------------------

Si vous aimez cet outil et voulez contribuer avec le développeur n'hésitez pas à le forker ou le partager à d'autre dev .
Merci. 

--------------------------------------------------------- ANECDOTE --------------------------------------------------------
J’ai développé ce mini outils parce que j’étais fatigué de remodifier manuellement à chaque fois mon fichier xml existant  
pour adapter ma conception aussi précisément que possible pour les différentes tailles d’écran des appareils.
Donc je ne vous en parle pas quand je devais partir de zéro sachant que les valeurs vont de 0 à 1000 :(
---------------------------------------------------------------------------------------------------------------------------
