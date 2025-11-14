# Tests et Gestion des Erreurs - ISMB Backend

## 📋 Vue d'ensemble

Ce document décrit le système de tests et de gestion des erreurs mis en place dans l'application ISMB Backend.

## 🚨 Système de Gestion des Erreurs

### Architecture

Le système utilise un gestionnaire global d'exceptions (`GlobalExceptionHandler`) avec l'annotation `@RestControllerAdvice` pour intercepter toutes les exceptions de l'application.

### Exceptions Personnalisées

Toutes les exceptions personnalisées sont dans le package `com.tanguydev.ismb.Domain.Exception` :

#### 1. ResourceNotFoundException (404)
```java
// Par ID
throw new ResourceNotFoundException("Filiere", 123L);
// Message: "Filiere avec l'ID 123 n'a pas été trouvé"

// Par champ
throw new ResourceNotFoundException("User", "username", "admin");
// Message: "User avec username='admin' n'a pas été trouvé"

// Message personnalisé
throw new ResourceNotFoundException("La ressource demandée n'existe pas");
```

#### 2. BadRequestException (400)
```java
throw new BadRequestException("Les données fournies sont invalides");
```

#### 3. DuplicateResourceException (409)
```java
// Par champ
throw new DuplicateResourceException("User", "email", "test@example.com");
// Message: "User avec email='test@example.com' existe déjà"

// Message personnalisé
throw new DuplicateResourceException("Cette ressource existe déjà");
```

#### 4. UnauthorizedException (401)
```java
throw new UnauthorizedException("Vous devez être connecté pour accéder à cette ressource");
```

### Gestion Automatique

Le `GlobalExceptionHandler` gère également :

- **AccessDeniedException** (403) - Accès refusé
- **BadCredentialsException** (401) - Identifiants incorrects
- **MethodArgumentNotValidException** (400) - Erreurs de validation
- **MaxUploadSizeExceededException** (413) - Fichier trop volumineux
- **Exception** (500) - Erreur serveur inattendue

### Format de Réponse

Toutes les erreurs retournent un objet `ErrorResponse` standardisé :

```json
{
  "timestamp": "2025-11-11T08:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Filiere avec l'ID 999 n'a pas été trouvé",
  "path": "/api/filieres/999"
}
```

Pour les erreurs de validation :

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

### Utilisation dans les UseCases

```java
public class GetFiliereByIdUseCase {
    public DomainFiliere execute(Long id) {
        return filiereService.getFiliereById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Filiere", id));
    }
}
```

### Logging

Le gestionnaire log automatiquement :
- **WARN** pour les erreurs client (4xx)
- **ERROR** pour les erreurs serveur (5xx)

## 🧪 Système de Tests

### Structure

```
src/test/java/
├── com/tanguydev/ismb/
│   ├── Domain/
│   │   └── UseCases/          # Tests unitaires
│   │       ├── Filiere/
│   │       │   └── CreateFiliereUseCaseTest.java
│   │       └── Etudiant/
│   │           └── ListEtudiantUseCaseTest.java
│   └── Infrastructure/
│       └── Controllers/        # Tests d'intégration
│           └── FiliereControllerIntegrationTest.java
```

### Tests Unitaires

#### Caractéristiques
- Testent les UseCases de manière isolée
- Utilisent Mockito pour mocker les dépendances
- Rapides et sans dépendances externes
- Annotation `@ExtendWith(MockitoExtension.class)`

#### Exemple : CreateFiliereUseCaseTest

```java
@ExtendWith(MockitoExtension.class)
@DisplayName("Tests unitaires - CreateFiliereUseCase")
class CreateFiliereUseCaseTest {

    @Mock
    private FiliereServiceInterface filiereService;

    @InjectMocks
    private CreateFiliereUseCase createFiliereUseCase;

    @Test
    @DisplayName("Devrait créer une filière avec succès")
    void shouldCreateFiliereSuccessfully() {
        // Given
        DomainFiliere filiere = new DomainFiliere();
        filiere.setLibelle("Informatique");
        
        when(filiereService.createFiliere(any())).thenReturn(filiere);

        // When
        DomainFiliere result = createFiliereUseCase.execute(filiere);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getLibelle()).isEqualTo("Informatique");
        verify(filiereService, times(1)).createFiliere(filiere);
    }
}
```

### Tests d'Intégration

#### Caractéristiques
- Testent les controllers avec le contexte Spring complet
- Utilisent MockMvc pour simuler les requêtes HTTP
- Base de données H2 en mémoire
- Annotations : `@SpringBootTest`, `@AutoConfigureMockMvc`, `@Transactional`

#### Exemple : FiliereControllerIntegrationTest

```java
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class FiliereControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /api/filieres - Devrait retourner toutes les filières")
    void shouldReturnAllFilieres() throws Exception {
        mockMvc.perform(get("/api/filieres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].libelle", is("Informatique")));
    }
}
```

### Configuration des Tests

#### application-test.properties

```properties
# Base de données H2 en mémoire
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate pour H2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=false

# JWT pour les tests
security.jwt.secret=test-secret-key-for-jwt-token-generation-in-test-environment-minimum-32-characters
security.jwt.expiration-ms=3600000

# Logs minimaux
logging.level.root=ERROR
logging.level.com.tanguydev.ismb=WARN
```

### Dépendances de Test

```xml
<!-- Tests Spring Boot -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<!-- H2 Database pour les tests -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>test</scope>
</dependency>

<!-- Spring Security Test -->
<dependency>
    <groupId>org.springframework.security</groupId>
    <artifactId>spring-security-test</artifactId>
    <scope>test</scope>
</dependency>
```

### Exécution des Tests

```bash
# Tous les tests
./mvnw test

# Tests d'une classe spécifique
./mvnw test -Dtest=CreateFiliereUseCaseTest

# Tests d'un package
./mvnw test -Dtest="com.tanguydev.ismb.Domain.UseCases.**"

# Tests avec rapport de couverture (nécessite jacoco)
./mvnw test jacoco:report
```

### Bonnes Pratiques

#### Nommage
- Tests unitaires : `[ClassName]Test.java`
- Tests d'intégration : `[ClassName]IntegrationTest.java`
- Méthodes : `should[ExpectedBehavior]When[Condition]()`

#### Structure Given-When-Then
```java
@Test
void shouldReturnFiliereWhenIdExists() {
    // Given - Préparation des données
    Long id = 1L;
    DomainFiliere filiere = new DomainFiliere();
    
    // When - Action testée
    DomainFiliere result = useCase.execute(id);
    
    // Then - Vérifications
    assertThat(result).isNotNull();
}
```

#### Annotations DisplayName
```java
@Test
@DisplayName("Devrait retourner 404 si la filière n'existe pas")
void shouldReturn404WhenFiliereNotFound() {
    // ...
}
```

## 📊 Couverture de Code

Pour générer un rapport de couverture avec JaCoCo, ajoutez dans `pom.xml` :

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.10</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Le rapport sera généré dans `target/site/jacoco/index.html`.

## 🎯 Objectifs de Couverture

- **UseCases** : > 80%
- **Services** : > 70%
- **Controllers** : > 60%
- **Global** : > 70%

## 📝 Checklist pour Nouveaux Tests

- [ ] Test unitaire pour le UseCase
- [ ] Test d'intégration pour le Controller
- [ ] Tests des cas d'erreur (exceptions)
- [ ] Tests des validations
- [ ] Tests des cas limites (null, vide, etc.)
- [ ] Annotations `@DisplayName` descriptives
- [ ] Structure Given-When-Then
- [ ] Assertions claires et précises
