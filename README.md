<h1>TP Injection des dependances</h1>
<h2>Partie I : Création de l'interface et des implémentations</h2>
<h3>1. Création de l'interface IDao avec une méthode getData</h3>
<p>L'interface IDao est conçue pour représenter une source de données abstraite. Elle contient une seule
méthode :</p>
<img src="CAPTURES/Image1.png">
<p>Cette méthode getData() est censée retourner une donnée de type double, sans spécifier d'où elle
provient (par exemple, une base de données ou une API).</p>
<h3>2. Implémentation de l'interface IDao</h3>
<p>Nous implémentons l'interface IDao à travers une classe qui simule la récupération de données depuis
une source précise :</p>
<img src="CAPTURES/Image2.png">
<p>Ici, la classe DaoImp retourne une valeur aléatoire pour simuler la récupération de données externes.
</p>
<h3>3. Création de l'interface IMetier avec une méthode calcul
</h3>
<p>L'interface IMetier est une abstraction de la logique métier. Elle contient une méthode :</p>
<img src="CAPTURES/Image3.png">
<p>Cette méthode calcul() utilise des données fournies par un objet de type IDao pour effectuer un
calcul.</p>
<h3>4. Implémentation de l'interface IMetier avec couplage faible</h3>
<p>Dans cette partie, nous implémentons l'interface IMetier en utilisant le principe du couplage faible
(Dépendance par abstraction). La classe ne dépendra pas directement de l'implémentation spécifique de
IDao mais de l'interface.
</p>
<img src="CAPTURES/Image4.png">
<p>Ici, la classe MetierImpl utilise un objet de type IDao pour récupérer les données nécessaires à son
calcul, mais elle ne connaît pas l'implémentation spécifique de IDao. Cela permet de changer
l'implémentation de IDao sans impacter la classe MetierImpl.</p>
<h2>Partie II : Injection des dépendances</h2>
<h3>1. Injection par instanciation statique</h3>
<p>Dans cette méthode, l'objet dépendant est créé manuellement au sein de l'application, créant ainsi une forte dépendance entre les classes.
</p>
<img src="CAPTURES/Image5.png">
<p>Ici, DaoImpl est instancié directement dans la classe principale, puis injecté dans MetierImpl. Cela
crée un couplage relativement fort entre les classes.
</p>
<h3>2. Injection par instanciation dynamique (Réflexion)</h3>
<p>L’instanciation dynamique permet de réduire le couplage en créant les objets à la volée en utilisant la
réflexion Java, ce qui donne plus de flexibilité.</p>
<img src="CAPTURES/Image6.png">
<p>Cette méthode utilise la réflexion pour créer les objets et injecter les dépendances dynamiquement. Elle
réduit le couplage direct entre les classes, mais peut rendre le code plus difficile à maintenir et à
déboguer.</p>
<h3>3. Injection avec le Framework Spring :
</h3>
<h4>a. Version XML :</h4>
<p>Spring permet d'injecter les dépendances via des configurations XML, rendant le code encore
plus flexible.</p>
<h4>Fichier « applicationContext.xml »</h4>
<img src="CAPTURES/Image7.png">
<h4>Code JAVA :</h4>
<img src="CAPTURES/Image8.png">
<p>Spring gère l'instanciation et l'injection des dépendances grâce à la configuration dans le fichier
XML.</p>
<h4>Version annotation :</h4>
<p>Spring permet également de gérer l'injection de dépendances avec des annotations pour éviter
les fichiers de configuration XML.
</p>
<br>
<p>Avec les annotations @Component et @Autowired, Spring peut injecter automatiquement
les dépendances sans avoir besoin de fichier XML, ce qui simplifie la configuration.</p>
<img src="CAPTURES/Image9.png">
<img src="CAPTURES/Image10.png">
<h4>Code JAVA :</h4>
<img src="CAPTURES/Image11.png">