# 🚀 BetDay Lite - Android App

> Aplicación moderna de apuestas deportivas desarrollada en Android utilizando **Kotlin + Jetpack Compose**, aplicando **Clean Architecture**, **MVI**, pruebas unitarias y buenas prácticas de desarrollo.

---

## 📌 Descripción general

Desarrollé **BetDay Lite**, una aplicación Android enfocada en la visualización de eventos deportivos y apuestas simuladas, aplicando arquitectura moderna, buenas prácticas y un enfoque escalable.

La app permite:

- 🏟️ Visualizar eventos deportivos organizados por hora  
- 🎯 Realizar apuestas simuladas en mercado **1X2**  
- 👤 Gestionar apuestas realizadas desde la sección de perfil  
- 📄 Visualizar el detalle completo de una apuesta seleccionada  

Durante el desarrollo prioricé:

- 🧠 Arquitectura limpia y mantenible  
- 🧪 Testing estructurado  
- 🎨 Experiencia de usuario fluida  
- 🔄 Manejo de estado predecible  
- 📡 Consumo de servicios desacoplado  
- 💾 Persistencia local  

---

## 🏗️ Arquitectura implementada

Implementé una arquitectura moderna basada en:

- 🧩 **Clean Architecture**
- 🔄 **MVI (Model - View - Intent)**
- 🔁 **Unidirectional Data Flow**
- 📦 **Modularización por features**

### 🧱 Capas
presentation → domain → infrastructure

> ⚠️ En mi implementación, la capa que normalmente se denomina `data` la estructuré como **Infrastructure**, ya que centraliza:
- acceso a datos  
- repositorios  
- consumo de servicios  
- persistencia local  
- mapeos  

### ✅ Principios aplicados

- 🧠 SOLID  
- 🎯 Single Source of Truth  
- 🧩 Separation of Concerns  
- 🪶 Bajo acoplamiento  
- ♻️ Reutilización de componentes  

---

## 🔄 Patrón MVI

Implementé el patrón **MVI** para asegurar un flujo de datos predecible y una UI reactiva.

### 🔁 Flujo

- 👉 **Intent** → acciones del usuario  
- 🧾 **State** → estado único de la UI  
- ⚙️ **Reducer** → transformación del estado  
- 🧠 **ViewModel** → orquestación  

### 🌟 Beneficios

- Estado centralizado  
- UI consistente  
- Fácil debugging  
- Escalabilidad  

---

## 🛠️ Tecnologías y herramientas

### 👨‍💻 Core
- Kotlin  
- Jetpack Compose  
- Coroutines  
- Flow / StateFlow  

### 🧠 Arquitectura
- Clean Architecture  
- MVI  
- ViewModel  
- UseCases  

### 🏢 Infrastructure
- Retrofit  
- OkHttp  
- Room  
- Mappers (DTO → Domain → UI / Entity)  

### 🌐 Networking
- Interceptores personalizados  
- Chucker  
- Manejo de errores centralizado  
- Servicios mockeados con **Mockoon**  

### 🧪 Testing
- JUnit  
- Mockito  
- Patrón AAA (Arrange - Act - Assert)  

### ⚙️ Ambientes
- 🔧 Dev  
- 🧪 QA  
- 🚀 UAT  

---

## 🌐 Servicios mockeados

Para desacoplar completamente el desarrollo del backend, utilicé **Mockoon** para simular servicios HTTP.

### 📍 Implementación

- Mock de endpoints de eventos y apuestas  
- Simulación de respuestas controladas  
- Validación de contratos JSON  
- Entorno local independiente del backend  

### 💡 Beneficios

- 🚀 Mayor velocidad de desarrollo  
- 🔒 Control de escenarios  
- 🧪 Pruebas estables  
- 🧩 Independencia del backend  

---

## 📡 Networking

Implementé la capa de red con **Retrofit + OkHttp**, incorporando herramientas de debugging.

### 🔍 Incluye

- Consumo de APIs  
- Interceptores personalizados  
- Logging HTTP  
- Integración con **Chucker**  
- Manejo desacoplado de errores  
- Integración con Mockoon  

---

## ✨ Funcionalidades

### 🏠 Home

- Lista de eventos ordenados por fecha/hora  
- Visualización de:
  - Liga  
  - Equipos  
  - Cuotas (1X2)  

- Interacción:
  - Selección de apuesta  
  - Feedback visual  
  - Estado reactivo con MVI  

---

### 👤 Perfil

- Lista de apuestas realizadas  
- Estados:
  - 🟡 PENDING  
  - 🟢 WON  
  - 🔴 LOST  

- Incluye:
  - Empty state  
  - Navegación al detalle  

---

### 📄 Detalle

- Información completa del evento  
- Selección realizada  
- Cuota  
- Estado  

---

## 💾 Persistencia

Utilicé **Room** para almacenar localmente las apuestas.

### Implementé

- Guardado de apuestas  
- Lectura desde base de datos  
- Consulta para perfil y detalle  

> ⚠️ No implementé sincronización remota, ya que el enfoque estuvo en arquitectura, estado y persistencia local.

---

## 🎨 UI / UX

Diseñé la UI utilizando Jetpack Compose priorizando:

- 🎨 Diseño limpio  
- 🧩 Componentes reutilizables  
- ✨ Feedback visual  
- 📱 Experiencia fluida  
- 🔄 Integración con MVI  

---

## 🧪 Testing

Implementé pruebas unitarias utilizando el patrón:

### AAA (Arrange - Act - Assert)

### 📚 Capas cubiertas

- Domain  
- Infrastructure  

### ✅ Enfoque

- Validación de lógica de negocio  
- Uso de mocks  
- Pruebas aisladas  
- Verificación clara de resultados  

---

## ✅ Clases de test

### 🏠 HOME

#### 🧠 Domain
`dominio/usecase/MatchesUseCaseTest.kt`

- Validación de obtención de eventos  
- Verificación de lógica del caso de uso  
- Interacción con repositorio  

#### 🏢 Infrastructure
`infraestructura/repository/MatchesDataSourceImplTest.kt`

- Consumo de datos mockeados  
- Transformación de datos  
- Validación del data source  

---

### 👤 PERFIL

#### 🧠 Domain
`dominio/usecase/BetUseCaseTest.kt`

- Validación de recuperación de apuestas  
- Lógica de negocio  
- Interacción con Infrastructure  

#### 🏢 Infrastructure
`infraestructura/repository/BetDataSourceImplTest.kt`

- Acceso a datos  
- Transformación de información  
- Validación del repositorio  

---

## 🌿 Estrategia de ramas

Durante el desarrollo utilicé una estrategia basada en ramas por feature.

### 📂 Principales

- `master` → versión estable  
- `develop` → integración  

### 🚀 Features

- `feature/config_application`  
- `feature/detailsbets`  
- `feature/home`  
- `feature/home_offline`  
- `feature/profile`  
- `feature/test_home`  

### 🛠️ Fixes

- `fixes/designsystem`  

### 📦 Release

- `releaseV1`  

### 🎯 Enfoque

- Desarrollo por funcionalidades  
- Integración controlada  
- Preparación de releases  

---

## 🚀 Diferenciales

- 🔥 MVI implementado correctamente  
- 🔥 Clean Architecture  
- 🔥 Infrastructure como capa de datos  
- 🔥 Testing con AAA  
- 🔥 Mockoon para servicios  
- 🔥 Chucker para debugging  
- 🔥 Multi-environment  
- 🔥 Modularización  
- 🔥 Manejo de estado con Flow  

---

## 📸 Screenshots

- screenshots/home.png  
- screenshots/profile.png  
- screenshots/detail.png  

---

## 🎥 Demo

[Ver video demo](https://tu-link-aqui.com)

---

## 📦 Instalación

```bash
git clone https://github.com/tu-repo.git
