# Óptica - Gestión de Base de Datos

## 📄 Descripción
Este proyecto implementa un sistema de gestión para una óptica, con funcionalidades para manejar clientes, empleados, facturas, proveedores y gafas. Utiliza Java para conectar con una base de datos MySQL, crear tablas e interactuar con los datos almacenados.

### Características
1. **Conexión a la base de datos:**
    - Clase `Conexion` para gestionar la conexión a MySQL.
2. **Creación de tablas:**
    - Clase `CreateTables` para crear las siguientes tablas:
        - Address
        - Supplier
        - Brand
        - Glasses
        - Client
        - Employee
        - Bill
3. **Relaciones complejas:**
    - Soporta relaciones entre tablas como:
        - Proveedores y direcciones.
        - Marcas y proveedores.
        - Gafas y marcas.
        - Clientes y facturas.
        - Empleados y facturas.
4. **Operaciones avanzadas:**
    - Diseño optimizado para futuras consultas, como modelos de gafas vendidas por empleados o proveedores de gafas exitosamente comercializadas.

---

## 💻 Tecnologías Utilizadas
- **Java 17**
- **MySQL**
- **IDE recomendado:** IntelliJ IDEA.

---

## 📊 Requisitos
- **Java Development Kit (JDK):** Versión 17 o superior.
- **MySQL:** Servidor en funcionamiento con permisos de escritura.

---

## 🛠️ Instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/eze-ms/Optica-DB-Management
   ```
2. Configura la base de datos:
    - Crea una base de datos llamada `optica_db`.
    - Ajusta las credenciales en la clase `Conexion`:
      ```java
      var usuario = "root";
      var password = "tu_contraseña";
      ```
3. Ejecuta el archivo `CreateTables.java` para crear las tablas.

---

## 🔧 Ejecución
1. Asegúrate de tener la base de datos configurada correctamente.
2. Compila y ejecuta la clase `CreateTables` desde tu IDE o terminal.
3. Verifica que las tablas se han creado en tu base de datos MySQL.

---

## ✨ Características Adicionales
Este proyecto está diseñado para ser escalable, con soporte para futuras funcionalidades como:
- Gestión avanzada de empleados.
- Reportes detallados de ventas por cliente o empleado.
- Integración con sistemas de inventario automatizado.

---

## 📢 Notas
Si tienes problemas con la conexión, verifica:
- La URL del servidor MySQL.
- Las credenciales configuradas en la clase `Conexion`.
- Que el servidor MySQL esté en funcionamiento.

---

© 2024. Proyecto desarrollado por Ezequiel Macchi Seoane.
