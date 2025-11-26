# 🛒 Sistema de Punto de Venta para Tienda

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Licencia](https://img.shields.io/badge/licencia-MIT-blue)
![Backend](https://img.shields.io/badge/backend-Groovy%20%2B%20SpringBoot-orange)
![Frontend](https://img.shields.io/badge/frontend-JavaFX-lightblue)

---

## 📑 Índice
- [Descripción](#-descripción)
- [Características](#-características)
- [Tecnologías utilizadas](#-tecnologías-utilizadas)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Instalación y ejecución](#-instalación-y-ejecución)
    - [Backend](#-backend)
    - [Frontend](#-frontend)
- [Demo y documentación](#-demo-y-documentación)
- [Capturas](#-capturas)
- [Contribuciones](#-contribuciones)
- [Licencia](#-licencia)

---

## 📌 Descripción
Este proyecto es un **Sistema de Punto de Venta (POS)** dividido en dos módulos:
- **Backend**: API REST desarrollada en **Groovy con Spring Boot**, encargada de la lógica de negocio y persistencia.
- **Frontend**: Aplicación de escritorio en **JavaFX**, que consume el backend y ofrece una interfaz amigable para el usuario.

---

## 🚀 Características
- ✅ Gestión de productos (alta, baja y modificación)
- ✅ Control de inventario con actualización automática
- ✅ Registro de ventas con historial detallado
- ✅ Reportes diarios y mensuales
- ✅ Interfaz intuitiva en JavaFX

---

## 🛠️ Tecnologías utilizadas
- **Backend**: Groovy, Spring Boot, PostgreSQL
- **Frontend**: JavaFX, Java 21
- **Build Tools**: Maven (backend), Maven (frontend)

---

## 📂 Estructura del proyecto
```
punto-de-venta/
│
├── pos-back/          # API REST en Groovy + Spring Boot
│   ├── src/
│   └── pom.xml
│
├── pos-front/         # Aplicación JavaFX
│   ├── src/
│   └── pom.xml
│
└── README.md
```

---

## ⚙️ Instalación y ejecución

### 🔹 Backend
```bash
git clone https://github.com/refrazul2025/pos-back.git
cd pos-back
./mvnw clean package
```

### 🔹 Frontend
```bash
git clone https://github.com/refrazul2025/pos-front.git
cd pos-front
mvn javafx:run
```

---

## 🌐 Demo y documentación
- **Documentación del proyecto**: [GitHub Pages](https://refrazul2025.github.io/punto-de-venta)
- **API Backend**:  [Heroku URL - En proceso](https://tu-backend.herokuapp.com)

---

## 📸 Capturas
Agrega imágenes aquí:
```markdown
![Pantalla principal](img/pantalla-principal.png)
![Gestión de productos](img/gestion-productos.png)
```

---

## 🤝 Contribuciones
¡Las contribuciones son bienvenidas!
1. Haz un **fork** del repositorio.
2. Crea una rama para tu mejora:
   ```bash
   git checkout -b feature-nueva
   ```
3. Haz un **pull request**.

---

## 📄 Licencia
Este proyecto está bajo la licencia **MIT**.
