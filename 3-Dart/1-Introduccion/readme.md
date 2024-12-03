
### **Capítulo 1: Introducción a Dart y Variables**  


#### **1. ¿Qué es Dart? (5 min)**  
- **Definición**:  
  Dart es un lenguaje de programación desarrollado por Google, diseñado para construir interfaces de usuario (UI) modernas y rápidas.  
  - Es multiparadigma: soporta programación orientada a objetos, funcional y reactiva.  
  - Es fuertemente tipado pero permite cierta flexibilidad con tipos como `dynamic`.  
- **Características principales**:  
  - Optimizado para Flutter.  
  - Compilación Just-in-Time (JIT) para desarrollo rápido y Ahead-of-Time (AOT) para aplicaciones de producción.  
  - Soporte nativo para programación asíncrona.  
- **Contexto en Flutter**:  
  - Dart se utiliza para desarrollar la lógica de las aplicaciones en Flutter, incluyendo diseño de interfaces, manejo de estados y acceso a servicios externos.  

---

#### **2. Variables en Dart (15 min)**  
- **Declaración de Variables**  
  Dart permite declarar variables utilizando palabras clave:  
  - `var`: Para variables cuyo tipo se infiere en tiempo de compilación.  
    ```dart
    var nombre = "Juan";  // Infere que es un String
    ```
  - `final`: Para valores que no se pueden reasignar, pero se inicializan en tiempo de ejecución.  
    ```dart
    final hoy = DateTime.now();  // Solo se asigna una vez
    ```
  - `const`: Para valores constantes conocidos en tiempo de compilación.  
    ```dart
    const pi = 3.14;  // Valor constante
    ```
  - **Diferencia clave entre `final` y `const`**:  
    - `final`: Valor conocido en tiempo de ejecución.  
    - `const`: Valor conocido en tiempo de compilación.  

- **Tipos de Datos Básicos**  
  - `int`: Enteros. Ejemplo: `int edad = 25;`.  
  - `double`: Decimales. Ejemplo: `double peso = 72.5;`.  
  - `String`: Texto. Ejemplo: `String saludo = "Hola";`.  
  - `bool`: Booleanos. Ejemplo: `bool esActivo = true;`.  
  - **Tipos especiales**:  
    - `dynamic`: Para variables que pueden cambiar de tipo durante la ejecución.  
      ```dart
      dynamic variable = "texto";  
      variable = 42;  // Cambia a un número
      ```  
    - `null`: Representa la ausencia de un valor. En Dart, las variables no pueden ser `null` a menos que se declare explícitamente (`nullable types` con `?`).  
      ```dart
      String? nombre;  // Puede ser null
      nombre = null;
      ```

- **Operadores Básicos**  
  - **Aritméticos**: `+`, `-`, `*`, `/`, `%`.  
  - **Asignación**: `=`, `+=`, `-=`, `*=`, `/=`.  
  - **Comparación**: `==`, `!=`, `<`, `>`, `<=`, `>=`.  
  - **Lógicos**: `&&`, `||`, `!`.  
  - **Null-aware operators**:  
    - `??`: Retorna el valor de la izquierda si no es `null`, de lo contrario el de la derecha.  
      ```dart
      String? nombre;  
      print(nombre ?? "Anónimo");  // Imprime "Anónimo"
      ```  
    - `??=`: Asigna un valor si la variable es `null`.  
      ```dart
      nombre ??= "Invitado";  // Asigna "Invitado" si nombre es null
      ```  

---

#### **3. Ejemplo Integrador (10 min)**  
**Problema práctico**:  
Escribe un programa en Dart que:  
1. Pida el nombre, la edad y el salario de un usuario (hardcodeado o con `stdin`).  
2. Use una combinación de `var`, `final`, y `const` para definir variables.  
3. Imprima un mensaje como:  
   - "Hola Juan, tienes 30 años y tu salario es de 30000."  

**Código ejemplo**:  
```dart
void main() {
  // Variables
  const saludo = "Hola";
  var nombre = "Juan";
  int edad = 30;
  double salario = 30000.0;

  // Imprimir mensaje
  print("$saludo $nombre, tienes $edad años y tu salario es de \$${salario.toStringAsFixed(2)}.");
}
```  

---

#### **4. Actividades Prácticas (10 min)**  
1. **Actividad 1: Declaración y uso de variables**  
   - Declara tres variables: tu nombre, tu edad y tu país. Imprímelas en una sola línea utilizando interpolación de cadenas.  
2. **Actividad 2: Uso de operadores**  
   - Crea un programa que reciba un número (hardcodeado) y calcule su cuadrado.  
3. **Actividad 3: Null-aware operator**  
   - Define una variable opcional (`String?`) y usa el operador `??` para asignarle un valor predeterminado si es `null`.  

