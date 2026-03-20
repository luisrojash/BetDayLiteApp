# BetDay Lite — Android App

Aplicación Android de apuestas deportivas simuladas desarrollada con **Kotlin + Jetpack Compose**, aplicando Clean Architecture, MVI y modularización por features.

---

## Descripción

**BetDay Lite** permite:

- Visualizar eventos deportivos organizados por fecha y hora
- Realizar apuestas simuladas en mercado **1X2**
- Consultar el historial de apuestas desde la sección de perfil
- Ver el detalle completo de una apuesta seleccionada

La app consume una API REST mockeada con **Mockoon** y persiste los datos localmente con **Room**.

---

## Arquitectura

Implementa **Clean Architecture** con tres capas bien definidas:

```
Presentation → Domain → Infrastructure
```

> La capa `Infrastructure` cumple el rol que normalmente ocupa `data`, centralizando repositorios, data sources, mappers y acceso a la base de datos.

### Patrón MVI

El flujo de la UI es unidireccional:

```
Intent (acción del usuario)
  → ViewModel (orquestación)
    → Reducer (transformación de estado)
      → State (UI reactiva via StateFlow)
```

### Principios aplicados

- SOLID
- Single Source of Truth
- Separation of Concerns
- Bajo acoplamiento entre capas

---

## Módulos

```
app/
core/
  ├── common/         # BaseViewModel, NetworkMonitor, dispatchers
  ├── database/       # Room: AppDatabase, DAOs, entidades
  ├── designsystem/   # Componentes Compose, Theme, Typography
  ├── domain/         # Result, Failure (tipos base)
  ├── navigation/     # NavGraph, BottomNavigation
  └── networking/     # Retrofit, OkHttp, manejo de errores

features/
  ├── home/
  │   ├── domain/          # MatchesUseCase, MatchesRepository (interfaz), entidades
  │   ├── infrastructure/  # MatchesRepositoryImpl, MatchesService, Mappers
  │   └── presentation/    # HomeScreen, HomeViewModel, HomeState, HomeIntent
  ├── profile/
  │   ├── domain/          # BetUseCase, BetRepository (interfaz), BetUi, BetStatus
  │   ├── infrastructure/  # BetRepositoryImpl, BetService, Mappers
  │   └── presentation/    # ProfileScreen, ProfileViewModel, ProfileState
  └── detailbets/
      └── presentation/    # DetailBetsScreen, componentes de detalle
```

---

## Stack tecnológico

| Categoría | Tecnologías |
|-----------|-------------|
| Lenguaje & UI | Kotlin 2.3.20, Jetpack Compose, Material3 |
| Arquitectura | Clean Architecture, MVI, ViewModel, UseCases |
| Async | Coroutines, Flow, StateFlow |
| DI | Hilt 2.59.2 |
| Networking | Retrofit 3, OkHttp 4, Chucker, Mockoon |
| Persistencia | Room 2.8.4 |
| Imágenes | Coil 2.7.0 |
| Testing | JUnit 4, Mockito, Mockito-Kotlin, Coroutines Test |
| Build | Gradle KTS, Version Catalog (libs.versions.toml) |

---

## Funcionalidades

### Home

- Lista de eventos deportivos con selector de día
- Visualización de equipos, liga y cuotas (1 / X / 2)
- Timeline visual de partidos por estado (próximo, en vivo, finalizado)
- Selección de apuesta con feedback visual reactivo

### Perfil

- Historial de apuestas guardadas localmente
- Estados: `PENDING` / `WON` / `LOST`
- Empty state cuando no hay apuestas registradas
- Navegación al detalle de cada apuesta

### Detalle

- Información completa del evento (liga, equipos, marcador)
- Opción seleccionada y cuota aplicada
- Indicador de partido en vivo
- Estado actual de la apuesta

---

## Testing

Pruebas unitarias con el patrón **AAA (Arrange — Act — Assert)**.

**Clases cubiertas:**

| Feature | Capa | Clase |
|---------|------|-------|
| Home | Domain | `MatchesUseCaseTest` |
| Home | Infrastructure | `MatchesDataSourceImplTest` |
| Profile | Domain | `BetUseCaseTest` |
| Profile | Infrastructure | `BetDataSourceImplTest` |

---

## Ambientes

El proyecto define tres flavors de Gradle:

| Flavor | Descripción |
|--------|-------------|
| `dev` | Desarrollo local con Mockoon |
| `qa` | Integración y pruebas |
| `prod` | Producción |

Las URLs base se configuran en `gradle.properties` como `URL_BASE_DEV`, `URL_BASE_QA` y `URL_BASE_PROD`.

---

## Configuración local

### Requisitos

- Android Studio Ladybug o superior
- JDK 11+
- Mockoon (para desarrollo local)

### Pasos

1. Clonar el repositorio
2. Importar en Android Studio
3. Iniciar Mockoon con los endpoints de eventos y apuestas
4. Verificar que `URL_BASE_DEV` en `gradle.properties` apunta al servidor local
5. Ejecutar con el flavor `dev`

---

## Estrategia de ramas

| Rama | Propósito |
|------|-----------|
| `master` | Versión estable |
| `develop` | Integración de features |
| `feature/*` | Desarrollo por funcionalidad |
| `fixes/*` | Correcciones puntuales |
| `releaseV1` | Preparación de release |

---

## FOTOS Y VIDEOS

**| BASE DE DATOS SQLITE ROOM |**

![Home Screen](https://drive.google.com/uc?export=view&id=1a3l3IdeucmY62r7EpWizcJefFsY-IDjo)

**|PANTALLA DE HOME |**

![Profile Screen](https://drive.google.com/uc?export=view&id=1_4_BrCM5bRlcFgRhbNnjTFd6ouM4wDmZ)

**| GENERAL FOTOS Y VIDEOS |**

| LINK  | [APK](https://drive.google.com/file/d/15fCRA0DC8DlbWlm9dNBadkMi2ywlHGc8/view?usp=sharing) |

**| APK DE LA APLICACIÓN |**

| LINK  | [APK](https://drive.google.com/file/d/15fCRA0DC8DlbWlm9dNBadkMi2ywlHGc8/view?usp=sharing) |


## Consideraciones de diseño

- **Infrastructure vs Data:** se optó por llamar `infrastructure` a la capa de datos para enfatizar que centraliza no solo el acceso a datos sino también la orquestación de fuentes remotas y locales.
- **Sin sincronización remota:** el enfoque estuvo en la arquitectura, el manejo de estado y la persistencia local. Las apuestas se guardan únicamente en Room.
- **`usesCleartextTraffic="true"`:** habilitado para permitir conexión HTTP al servidor Mockoon en desarrollo local.
