# Auto-évaluation
Pour commencer, tout ce qui est CRUD (create, read, update, delete) des compagnies avec la base de données SQLite fonctionne bien. Il y a même un message de confirmation pour la suppression d’une compagnie. L’actualisation de la page d’accueil est aussi faite pour que l’affichage du nom des compagnies dans le RecyclerView puisse être mise à jour. La liste des compagnies est également triée par ordre croissant comme dans l’énoncé grâce à une requête SQL avec ORDER BY. Ensuite, les Intents concernant l’envoi d’un courriel, l’appel téléphonique et la redirection vers le lien de la compagnie dans un navigateur également bien. Pour Google Maps, il y a la caméra centrée sur la localisation de l’appareil au démarrage de l’activité qui fonctionne bien, représentée par un cercle bleu et une flèche, puis le bouton pour se recentrer sur sa localisation est présente en haut dans le coin supérieur droit au besoin. Le mode portrait fonctionne également bien.
En revanche, l’ajout des marqueurs des compagnies provenant de la base de données ne fonctionne pas. J’ai tenté à plusieurs reprises fois et je n’arrive simplement pas à passer les données vers MapsActivity, la variable est toujours null. Donc, je ne peux pas faire de geocoding pour mettre les marqueurs puisqu’il me faut l’adresse de chaque compagnie pour effectuer la recherche. L’ajout des images ne fonctionne pas également, je l’ai oublié de le faire et je n’ai pas eu le temps de le faire.

Voici ma clé d’API si jamais vous en avez besoin une (cependant, elle est liée à ma carte de crédit, alors je ne sais pas trop si l’essai gratuit tiendra vos tests) :
•	MAPS_API_KEY=AIzaSyCvz_-rYZ9lz3YvwFrCaxVvEPAk4KsICCw
 
# Médiagraphie 
Les sources sont directement incluses en commentaires dans le code.
