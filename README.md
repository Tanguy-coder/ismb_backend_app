# ISMB App Backend

Application backend de gestion scolaire développée avec Spring Boot 3.3.0 et Java 17, suivant une architecture hexagonale (Clean Architecture).

## 🏗️ Architecture

Le projet suit une **architecture hexagonale** avec séparation claire des couches :

### Domain Layer (`com.tanguydev.ismb.Domain`)
- **Entity** : Entités métier pures
- **UseCases** : Cas d'utilisation métier (Create, List, GetById, Update, Delete)
- **Ports** : Interfaces de services métier
- **Gateway** : Interfaces de repositories (abstraction de la persistance)
- **Presenter** : Interfaces de présentation
- **Response** : DTOs de réponse

### Infrastructure Layer (`com.tanguydev.ismb.Infrastructure`)
- **Controllers** : API REST endpoints
- **Models** : Entités JPA (persistance)
- **Repositories** : Implémentations JPA
- **Mapper** : MapStruct pour conversion Domain ↔ Models
- **Request** : DTOs de requête
- **Security** : JWT, UserDetails, SecurityConfig
- **Config** : CORS, Storage, WebSocket

## 🛠️ Stack Technique

- **Framework** : Spring Boot 3.3.0
- **Java** : 17
- **Base de données** : MySQL (JPA/Hibernate)
- **Build** : Maven
- **Mapping** : MapStruct 1.5.5
- **Sécurité** : Spring Security + JWT (jjwt 0.11.5)
- **Utilitaires** : Lombok, WebSocket, Actuator

## 📋 Entités Principales

1. **User** : Utilisateur avec rôles et permissions (RBAC)
2. **Etudiant** : Profil étudiant avec photo, filière, notes, parcours
3. **Enseignant** : Profil enseignant
4. **Filiere** : Filière d'études liée à un niveau
5. **Niveau** : Niveau d'études
6. **Matiere** : Matière d'enseignement
7. **Ue** : Unité d'enseignement
8. **Note** : Notes des étudiants
9. **Etablissement** : Établissement scolaire
10. **AnneeScolaire** : Année scolaire
11. **ParcourtEtudiant** : Parcours de l'étudiant

## 🚀 Installation et Démarrage

### Prérequis

- Java 17
- Maven 3.6+
- MySQL 8.0+

### Configuration

1. **Créer la base de données MySQL** :
```sql
CREATE DATABASE ismb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. **Configurer l'application** :
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

3. **Modifier `application.properties`** avec vos paramètres :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ismb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=votre_mot_de_passe

# Clé secrète JWT (à changer en production)
security.jwt.secret=votre-cle-secrete-tres-longue-et-aleatoire-minimum-32-caracteres
security.jwt.expiration-ms=86400000
```

### Démarrage

```bash
# Compiler le projet
./mvnw clean compile

# Démarrer l'application
./mvnw spring-boot:run
```

L'application démarre sur **http://localhost:8080**

## 🔐 Authentification

### Utilisateurs par défaut

Le seeder crée automatiquement deux utilisateurs :

| Username | Password | Rôle  |
|----------|----------|-------|
| admin    | 1234     | Admin |
| user     | 1234     | User  |

### Connexion

**Endpoint** : `POST /api/auth/login`

**Request** :
```json
{
  "username": "admin",
  "password": "1234"
}
```

**Response** :
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Utilisation du token

Ajoutez le token dans l'en-tête `Authorization` de vos requêtes :
```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

## 📡 API Endpoints

### Authentification
- `POST /api/auth/login` - Connexion

### Étudiants
- `GET /api/etudiants` - Liste des étudiants
- `GET /api/etudiants/{id}` - Détails d'un étudiant
- `POST /api/etudiants` - Créer un étudiant (multipart/form-data)
- `PUT /api/etudiants/{id}` - Modifier un étudiant
- `DELETE /api/etudiants/{id}` - Supprimer un étudiant

### Enseignants
- `GET /api/enseignants` - Liste des enseignants
- `GET /api/enseignants/{id}` - Détails d'un enseignant
- `POST /api/enseignants` - Créer un enseignant
- `PUT /api/enseignants/{id}` - Modifier un enseignant
- `DELETE /api/enseignants/{id}` - Supprimer un enseignant

### Filières
- `GET /api/filieres` - Liste des filières
- `GET /api/filieres/{id}` - Détails d'une filière
- `POST /api/filieres` - Créer une filière
- `PUT /api/filieres/{id}` - Modifier une filière

### Niveaux
- `GET /api/niveaux` - Liste des niveaux
- `GET /api/niveaux/{id}` - Détails d'un niveau
- `POST /api/niveaux` - Créer un niveau
- `PUT /api/niveaux/{id}` - Modifier un niveau

### Matières
- `GET /api/matieres` - Liste des matières
- `GET /api/matieres/{id}` - Détails d'une matière
- `POST /api/matieres` - Créer une matière
- `PUT /api/matieres/{id}` - Modifier une matière
- `DELETE /api/matieres/{id}` - Supprimer une matière

### UE (Unités d'Enseignement)
- `GET /api/ues` - Liste des UE
- `GET /api/ues/{id}` - Détails d'une UE
- `POST /api/ues` - Créer une UE
- `PUT /api/ues/{id}` - Modifier une UE
- `DELETE /api/ues/{id}` - Supprimer une UE

### Établissements
- `GET /api/etablissements` - Liste des établissements
- `GET /api/etablissements/{id}` - Détails d'un établissement
- `POST /api/etablissements` - Créer un établissement
- `PUT /api/etablissements/{id}` - Modifier un établissement

### Années Scolaires
- `GET /api/annees` - Liste des années scolaires
- `GET /api/annees/{id}` - Détails d'une année
- `POST /api/annees` - Créer une année
- `PUT /api/annees/{id}` - Modifier une année

### Rôles et Permissions
- `GET /api/roles` - Liste des rôles
- `GET /api/roles/{id}` - Détails d'un rôle
- `POST /api/roles/{roleId}/permissions/{permissionId}` - Ajouter une permission
- `DELETE /api/roles/{roleId}/permissions/{permissionId}` - Retirer une permission
- `GET /api/permissions` - Liste des permissions
- `POST /api/permissions` - Créer une permission

### Utilisateurs
- `GET /api/users` - Liste des utilisateurs
- `POST /api/users` - Créer un utilisateur

### Actuator
- `GET /actuator/health` - État de santé de l'application
- `GET /actuator/info` - Informations sur l'application

## 📁 Upload de Fichiers

Les photos des étudiants sont stockées dans le dossier `/uploads` et accessibles via :
```
http://localhost:8080/uploads/{filename}
```

## 🧪 Tests

### Exécuter les tests

```bash
# Tous les tests
./mvnw test

# Tests d'une classe spécifique
./mvnw test -Dtest=CreateFiliereUseCaseTest

# Tests avec rapport de couverture
./mvnw test jacoco:report
```

### Types de tests

#### Tests Unitaires
Testent les UseCases de manière isolée avec Mockito :
- `CreateFiliereUseCaseTest` - Création de filières
- `ListEtudiantUseCaseTest` - Liste des étudiants
- Etc.

#### Tests d'Intégration
Testent les controllers avec MockMvc et base H2 en mémoire :
- `FiliereControllerIntegrationTest` - API Filières
- Utilise `@SpringBootTest` et `@AutoConfigureMockMvc`
- Profile `test` avec H2 database

### Configuration des tests

Les tests utilisent une base de données H2 en mémoire configurée dans `application-test.properties`.

## 🚨 Gestion des Erreurs

### Exceptions Personnalisées

Le projet utilise un système de gestion des erreurs global avec des exceptions personnalisées :

- **ResourceNotFoundException** : Ressource non trouvée (404)
- **BadRequestException** : Requête invalide (400)
- **DuplicateResourceException** : Ressource déjà existante (409)
- **UnauthorizedException** : Non autorisé (401)

### Format des Réponses d'Erreur

```json
{
  "timestamp": "2025-11-11T08:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Filiere avec l'ID 999 n'a pas été trouvé",
  "path": "/api/filieres/999"
}
```

### Validation des Données

Les erreurs de validation retournent un format détaillé :

```json
{
  "timestamp": "2025-11-11T08:00:00Z",
  "status": 400,
  "error": "Validation Failed",
  "message": "Les données fournies ne sont pas valides",
  "path": "/api/filieres",
  "validationErrors": {
    "libelle": "Le libellé est obligatoire",
    "niveau": "Le niveau est obligatoire"
  }
}
```

### Gestionnaire Global

Le `GlobalExceptionHandler` intercepte toutes les exceptions et retourne des réponses JSON standardisées avec :
- Logging approprié
- Codes HTTP corrects
- Messages d'erreur clairs en français
- Détails de validation si applicable

## ⚙️ Configuration de Sécurité

### CORS
Actuellement configuré pour accepter toutes les origines (`*`). **À restreindre en production** dans `WebConfig.java`.

### Endpoints Publics
Par défaut, tous les endpoints sont publics (`/**` dans `SecurityConfig.java`). **À sécuriser en production**.

## 🐛 Résolution de Problèmes

### Erreur : "Could not resolve placeholder 'security.jwt.secret'"
➡️ Vérifiez que `application.properties` existe et contient les propriétés JWT.

### Erreur de connexion à MySQL
➡️ Vérifiez que MySQL est démarré et que les credentials sont corrects.

### Port 8080 déjà utilisé
➡️ Modifiez le port dans `application.properties` :
```properties
server.port=8081
```

## 📝 Notes de Développement

- **Hibernate DDL** : Configuré en mode `update` (crée/modifie les tables automatiquement)
- **Logs SQL** : Activés pour le développement (`spring.jpa.show-sql=true`)
- **DevTools** : Activé pour le rechargement automatique
- **LiveReload** : Port 35729

## 🔒 Sécurité en Production

Avant de déployer en production :

1. ✅ Changer la clé secrète JWT (minimum 256 bits)
2. ✅ Restreindre les origines CORS
3. ✅ Configurer les endpoints protégés dans `SecurityConfig`
4. ✅ Passer Hibernate en mode `validate`
5. ✅ Désactiver `spring.jpa.show-sql`
6. ✅ Utiliser des variables d'environnement pour les secrets

## 📄 Licence

Projet développé pour l'ISMB.
